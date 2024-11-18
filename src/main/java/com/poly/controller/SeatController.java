package com.poly.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.model.Movie;
import com.poly.model.Room;
import com.poly.model.Schedule;
import com.poly.model.Seat;
import com.poly.service.MovieService;
import com.poly.service.RoomService;
import com.poly.service.ScheduleService;
import com.poly.service.SeatService;

@Controller
@RequestMapping("/homeuser")
public class SeatController {

	@Autowired
	SeatService seatService;
	@Autowired
	RoomService roomService;
	@Autowired
	MovieService movieService;
	@Autowired
	ScheduleService scheduleService;

	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	@GetMapping("/seat")
	public String ghe(@RequestParam("roomId") int roomId, @RequestParam("showtimeId") String showtimeId,
			@RequestParam("movieId") String movieId, @RequestParam("scheduleId") String scheduled, Model model) {
		List<Seat> seats = seatService.findByRoomId(roomId);
		Optional<Movie> optmovie = movieService.findById(Integer.parseInt(movieId));
		if (optmovie.isEmpty()) {
		    throw new ResourceNotFoundException("Phim không tồn tại cho ID: " + movieId);
		}
		Movie movie = optmovie.get();
		Optional<Room> optroom = roomService.findById(roomId);
		if (optmovie.isEmpty()) {
		    throw new ResourceNotFoundException("phòng không tồn tại cho ID: " + roomId);
		}
		Room room = optroom.get();

		Optional<Schedule> optschedule = scheduleService.findById(Integer.parseInt(scheduled));
		if (optschedule.isEmpty()) {
		    throw new ResourceNotFoundException("Lịch chiếu không tồn tại cho ID: " + scheduled);
		}
		Schedule schedule = optschedule.get();

		Map<String, List<Seat>> groupedSeats = new HashMap<>();

		for (Seat seat : seats) {
			String rowNumber = seat.getRowNumber();
			// Kiểm tra nếu Map đã có key cho rowNumber này
			if (!groupedSeats.containsKey(rowNumber)) {
				groupedSeats.put(rowNumber, new ArrayList<>());
			}
			groupedSeats.get(rowNumber).add(seat);
		}

		// Đưa danh sách ghế theo hàng vào model
		model.addAttribute("gheListGroupedByRow", groupedSeats);
		model.addAttribute("movie", movie);
		model.addAttribute("room", room);
		model.addAttribute("schedule", schedule);
		System.out.println(optschedule.get());
		return "user/giaodienghe";
	}

	@MessageMapping("/release-seat")
	@SendTo("/topic/seat-status")
	public Seat releaseSeat(@RequestBody Seat seat) {
		// Cập nhật trạng thái ghế thành "bỏ chọn"
		Optional<Seat> existingSeat = seatService.findByRoomIdAndRowNumberAndSeatNumber(seat.getRoom().getId(),
				seat.getRowNumber(), seat.getSeatNumber());

		if (existingSeat.isPresent()) {
			Seat seatToUpdate = existingSeat.get();
			if (seatToUpdate.isStatus() == true) {
				throw new IllegalArgumentException("Seat is already available.");
			}
			seatToUpdate.setStatus(true);
			seatService.save(seatToUpdate);

			messagingTemplate.convertAndSend("/topic/seat-status", seatToUpdate);
			return seatToUpdate;
		} else {
			throw new IllegalArgumentException("Seat not found for the given details.");
		}

	}

	@MessageMapping("/submit-seats")
	@SendTo("/topic/seat-status")
	public List<Seat> submitSeats(@RequestBody List<Seat> seats) {
		List<Seat> updatedSeats = new ArrayList<>();

		// Kiểm tra nếu chỉ có một ghế đơn, biến nó thành danh sách
		if (seats.size() == 1) {
			seats.add(seats.get(0));
		}

		for (Seat seat : seats) {
			Optional<Seat> existingSeat = seatService.findByRoomIdAndRowNumberAndSeatNumber(seat.getRoom().getId(),
					seat.getRowNumber(), seat.getSeatNumber());

			if (existingSeat.isPresent()) {
				Seat seatToUpdate = existingSeat.get();
				seatToUpdate.setStatus(false); // Đánh dấu ghế là đã chọn
				seatService.save(seatToUpdate); // Lưu lại ghế đã cập nhật
				updatedSeats.add(seatToUpdate);
			} else {
				throw new IllegalArgumentException("Seat not found: " + seat.getRowNumber() + seat.getSeatNumber());
			}
		}

		// Gửi thông tin ghế đã được chọn qua WebSocket
		messagingTemplate.convertAndSend("/topic/seat-status", updatedSeats);
		return updatedSeats;
	}

}
