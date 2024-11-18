package com.poly.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.poly.model.Room;
import com.poly.model.Seat;
import com.poly.model.SeatClass;
import com.poly.service.SeatService;
import com.poly.service.RoomService;
import com.poly.service.SeatClassService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/seats")
public class SeatRestController {
    
    @Autowired
    private SeatService seatService;
    
    @Autowired
    private SeatClassService seatClassService;
    
    @Autowired
    private RoomService roomService;

    // Lấy danh sách tất cả ghế
    @GetMapping
	public List<Seat> getAllSeats() {
        return seatService.getAllSeats();
    }
    // Lấy thông tin ghế theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Seat> getSeatById(@PathVariable("id") int id) {
        Optional<Seat> seat = seatService.getSeatById(id);
        return seat.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Cập nhật thông tin ghế
    @PutMapping("/{id}")
    public ResponseEntity<Seat> updateSeat(@PathVariable("id") int id, @RequestBody Seat seat) {
        if (!seatService.getSeatById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Seat updatedSeat = seatService.saveSeat(seat);
        return ResponseEntity.ok(updatedSeat);
    }

    // Tạo mới ghế
    @PostMapping
    public ResponseEntity<Seat> createSeat(@RequestBody Seat seat) {
        Seat createdSeat = seatService.saveSeat(seat);
        return ResponseEntity.status(201).body(createdSeat);
    }

    // Xóa ghế theo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeat(@PathVariable("id") int id) {
        if (!seatService.getSeatById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        seatService.deleteSeatById(id);
        return ResponseEntity.noContent().build();
    }

    // Lấy tất cả các loại ghế
    @GetMapping("/seatclass")
    public List<SeatClass> getSeatClasses() {
        return seatClassService.getAllSeatClasses();
    }
    // Lấy danh sách ghế theo ID phòng
    @GetMapping("/room/{roomId}")
    public ResponseEntity<List<Seat>> getSeatsByRoomId(@PathVariable("roomId") int roomId) {
        List<Seat> seats = seatService.getSeatsByRoomId(roomId);
        if (seats.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(seats);
    }
    
    @GetMapping("/room")
	public  List<Room> getRoom() {
		// TODO Auto-generated method stub
		return roomService.findAll();

	}
    
}
