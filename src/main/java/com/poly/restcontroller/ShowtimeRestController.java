package com.poly.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import com.poly.model.Showtime;
import com.poly.service.ShowtimeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/showtime")
public class ShowtimeRestController {

    @Autowired
    private ShowtimeService showtimeService;

    @GetMapping
    public List<Showtime> getAllShowtimes() {
        return showtimeService.findAll();
    }

    @GetMapping("/{id}")
    public Showtime getShowtimeById(@PathVariable Integer id) {
        return showtimeService.findById(id).orElse(null);
    }

    @PostMapping
    public Showtime createShowtime(@RequestBody Showtime showtime) {
        return showtimeService.save(showtime);
    }

    @PutMapping("/{id}")
    public Showtime updateShowtime(@PathVariable Integer id, @RequestBody Showtime showtime) {
        showtime.setId(id);
        return showtimeService.save(showtime);
    }

    @DeleteMapping("/{id}")
    public void deleteShowtime(@PathVariable Integer id) {
        showtimeService.deleteById(id);
    }
}
