package com.poly.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.model.Movie;
import com.poly.model.MovieCategory;
import com.poly.model.Room;
import com.poly.model.Schedule;
import com.poly.model.Showtime;
import com.poly.service.MovieCategoryService;
import com.poly.service.MovieService;
import com.poly.service.RoomService;
import com.poly.service.ScheduleService;
import com.poly.service.ShowtimeService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class Moviecontroller {
	@Autowired
	MovieService movieService;
	@Autowired
	ScheduleService scheduleService;
	@Autowired
	ShowtimeService showtimeService;
	@Autowired
	RoomService roomService;
	@Autowired
	MovieCategoryService movieCategoryService;

	@RequestMapping("/homeuser")
	public String index(Model model) {
		List<Movie> movie = movieService.findAll();
		model.addAttribute("Movie", movie);
		return "user/homeuser";
	}

	@GetMapping("/detail/movie/{id}")
	public String detailMovie(@PathVariable("id") Integer id, Model model) {
	    // Tìm kiếm bộ phim theo ID
	    Optional<Movie> opt = movieService.findById(id);

	    if (opt.isPresent()) {
	        Movie entity = opt.get();

	        // Lấy danh sách ngày chiếu duy nhất
	        List<LocalDate> screeningDates = scheduleService.findDistinctScreeningDates(entity.getId());

	        // Sắp xếp ngày chiếu theo thứ tự gần nhất đến xa nhất
	        screeningDates.sort(Comparator.naturalOrder());

	        // Định dạng ngày tháng thành chuỗi
//	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//	        List<String> formattedDates = screeningDates.stream()
//	                                                    .map(date -> date.format(formatter))
//	                                                    .collect(Collectors.toList());

	        // Lấy danh sách lịch chiếu theo từng ngày chiếu
	        List<Schedule> allSchedules = new ArrayList<>();
	        for (LocalDate date : screeningDates) {
	            List<Schedule> schedules = scheduleService.findByScreeningDateAndMovieId(date, entity.getId());
	            if (schedules != null && !schedules.isEmpty()) {
	                allSchedules.addAll(schedules);
	            }
	        }

	        // Lấy danh mục phim
	        List<MovieCategory> category = movieCategoryService.findByMovieId(entity.getId());

	        // Chuyển đổi từ entity sang DTO
	        com.poly.DTO.Movie dto = new com.poly.DTO.Movie();
	        BeanUtils.copyProperties(entity, dto);
	        dto.setImages(entity.getImages());
	        dto.setMovie_duration(entity.getMovieDuration());
	        dto.setID(entity.getId());
	        dto.setRelease_date(entity.getReleaseDate());

	        // Thêm thuộc tính vào model
	        model.addAttribute("detailMovie", dto);
	        model.addAttribute("category", category);
	        model.addAttribute("schedule", allSchedules);
	        model.addAttribute("dates", screeningDates);  // Truyền danh sách ngày đã định dạng
	    } else {
	        // Xử lý nếu không tìm thấy bộ phim
	        model.addAttribute("errorMessage", "Movie not found.");
	        return "error-page"; // Thay đổi đường dẫn đến trang lỗi phù hợp
	    }

	    return "user/about";  // Trả về trang thông tin chi tiết
	}




	  // Xử lý khi người dùng chọn một lịch chiếu
	@GetMapping("/select-seat")
	public String selectShowtime(@RequestParam("showtimeId") String showtimeId, 
	                             @RequestParam("movieId") String movieId, 
	                             @RequestParam("scheduleId") String scheduled, 
	                             Model model) {

	    // Truy xuất showtime và movie từ database dựa trên ID
	    Optional<Showtime> showtimeOpt = showtimeService.findById(Integer.parseInt(showtimeId));
	    Optional<Movie> movieOpt = movieService.findById(Integer.parseInt(movieId));

	    // Kiểm tra xem showtime có tồn tại không
	    if (!showtimeOpt.isPresent()) {
	        model.addAttribute("error", "Không tìm thấy lịch chiếu");
	        return "error-page";  // Chuyển hướng tới trang lỗi nếu không tìm thấy
	    }

	    Showtime showtime = showtimeOpt.get();
	    Movie movie = movieOpt.orElse(null);  // Tuỳ chọn: xử lý nếu không tìm thấy movie

	    // Giả sử `showtime` có mối quan hệ với `Room`, lấy dữ liệu phòng
	    Room room = showtime.getRoom(); // Điều chỉnh nếu có getter cho room
	    if (room == null) {
	        model.addAttribute("error", "Không tìm thấy phòng cho lịch chiếu này");
	        return "error-page";  // Chuyển hướng nếu không có phòng
	    }

	    // Tạo đối tượng Schedule và gán thông tin lịch chiếu và phim
	    Schedule schedule = new Schedule();
	    schedule.setShowtime(showtime);
	    schedule.setMovie(movie);
	    

	    // Sao chép thuộc tính sang ScheduleDTO để sử dụng trong view
	    com.poly.DTO.Schedule scheduleDTO = new com.poly.DTO.Schedule();
	    BeanUtils.copyProperties(schedule, scheduleDTO);

	    // Thêm các thuộc tính vào model để sử dụng trong view
	    model.addAttribute("selectedSchedule", scheduleDTO);
	    model.addAttribute("room", room);

	    // Chuyển hướng tới trang xác nhận hoặc bước xử lý tiếp theo
	    return "redirect:/homeuser/seat";
	}




}
