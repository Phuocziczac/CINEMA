package com.poly.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

import com.poly.model.Schedule;
import com.poly.service.ScheduleService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/schedule")
public class ScheduleRestController {

    @Autowired
    private ScheduleService scheduleService;

    /**
     * Lấy tất cả các lịch chiếu.
     * @return Danh sách các lịch chiếu.
     */
    @GetMapping
    public List<Schedule> getAllSchedules() {
        return scheduleService.findAll();
    }

    /**
     * Lấy thông tin lịch chiếu theo ID.
     * @param id ID của lịch chiếu.
     * @return Lịch chiếu nếu tìm thấy, ngược lại trả về null.
     */
    @GetMapping("/{id}")
    public Schedule getScheduleById(@PathVariable Integer id) {
        return scheduleService.findById(id).orElse(null);
    }

    /**
     * Tạo mới một lịch chiếu.
     * @param schedule Thông tin lịch chiếu mới.
     * @return Lịch chiếu đã được lưu.
     */
    @PostMapping
    public Schedule createSchedule(@RequestBody Schedule schedule) {
        return scheduleService.save(schedule);
    }

    /**
     * Cập nhật một lịch chiếu theo ID.
     * @param id ID của lịch chiếu cần cập nhật.
     * @param schedule Thông tin lịch chiếu mới.
     * @return Lịch chiếu đã được cập nhật.
     */
    @PutMapping("/{id}")
    public Schedule updateSchedule(@PathVariable Integer id, @RequestBody Schedule schedule) {
        schedule.setId(id);
        return scheduleService.save(schedule);
    }

    /**
     * Xóa một lịch chiếu theo ID.
     * @param id ID của lịch chiếu cần xóa.
     */
    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable Integer id) {
        scheduleService.deleteById(id);
    }

    /**
     * Lấy danh sách các lịch chiếu theo ID phim.
     * @param movieId ID của phim.
     * @return Danh sách các lịch chiếu.
     */
    @GetMapping("/by-movie/{movieId}")
    public List<Schedule> getSchedulesByMovieId(@PathVariable int movieId) {
        return scheduleService.findByMovieId(movieId);
    }

    /**
     * Lấy danh sách các ngày chiếu không trùng lặp theo ID phim.
     * @param movieId ID của phim.
     * @return Danh sách các ngày chiếu không trùng lặp.
     */
    @GetMapping("/distinct-dates/{movieId}")
    public List<LocalDate> getDistinctScreeningDates(@PathVariable int movieId) {
        return scheduleService.findDistinctScreeningDates(movieId);
    }

    /**
     * Lấy danh sách các lịch chiếu theo ngày chiếu và ID phim.
     * @param screeningDate Ngày chiếu.
     * @param movieId ID của phim.
     * @return Danh sách các lịch chiếu.
     */
    @GetMapping("/by-date-and-movie")
    public List<Schedule> getSchedulesByScreeningDateAndMovieId(@RequestParam LocalDate screeningDate,
                                                                @RequestParam int movieId) {
        return scheduleService.findByScreeningDateAndMovieId(screeningDate, movieId);
    }

    /**
     * Lấy thông tin thời gian chiếu theo ID lịch chiếu.
     * @param id ID của lịch chiếu.
     * @return Danh sách thời gian chiếu dưới dạng chuỗi.
     */
    @GetMapping("/showtimes/{id}")
    public List<String> getShowtimesByScheduleId(@PathVariable Integer id) {
        Schedule schedule = scheduleService.findById(id).orElse(null);

        if (schedule == null || schedule.getShowtime() == null) {
            return Collections.emptyList(); // Trả về danh sách rỗng nếu không tìm thấy lịch chiếu hoặc thời gian chiếu
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        
        // Tạo danh sách chứa một thời gian chiếu đã được định dạng
        List<String> showtimes = Collections.singletonList(schedule.getShowtime().getStartTime().format(formatter));
        
        return showtimes;
    }

    /**
     * Lấy thông tin nhiều suất chiếu trong một hàng cho cùng một ngày và cùng một bộ phim.
     * @param screeningDate Ngày chiếu.
     * @param movieId ID của phim.
     * @return Danh sách các suất chiếu được gộp lại trong một hàng.
     */
    @GetMapping("/multiple-showtimes")
    public List<Object[]> getShowtimesByDateAndMovie(@RequestParam LocalDate screeningDate,
                                                     @RequestParam int movieId) {
        return scheduleService.findShowtimesByDateAndMovie(screeningDate, movieId);
    }
}
