package com.poly.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.poly.model.Movie;
import com.poly.service.MovieService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/movies")
public class MovieRestController {

    @Autowired
    private MovieService movieService;

    /**
     * Lấy tất cả các phim.
     * @return Danh sách các phim.
     */
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.findAll();
    }

    /**
     * Lấy thông tin phim theo ID.
     * @param id ID của phim.
     * @return Phim nếu tìm thấy, ngược lại trả về null.
     */
    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Integer id) {
        return movieService.findById(id).orElse(null);
    }

    /**
     * Tạo mới một phim.
     * @param movie Thông tin phim mới.
     * @return Phim đã được lưu.
     */
    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.save(movie);
    }

    /**
     * Cập nhật một phim theo ID.
     * @param id ID của phim cần cập nhật.
     * @param movie Thông tin phim mới.
     * @return Phim đã được cập nhật.
     */
    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable Integer id, @RequestBody Movie movie) {
        movie.setId(id);
        return movieService.save(movie);
    }

    /**
     * Xóa một phim theo ID.
     * @param id ID của phim cần xóa.
     */
    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Integer id) {
        movieService.deleteById(id);
    }
}
