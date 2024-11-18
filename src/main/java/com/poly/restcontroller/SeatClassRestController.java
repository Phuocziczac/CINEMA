package com.poly.restcontroller;

import com.poly.model.SeatClass;
import com.poly.service.SeatClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/seatclass")
public class SeatClassRestController {

    @Autowired
    private SeatClassService seatClassService;

    // Lấy tất cả các loại ghế
    @GetMapping
    public List<SeatClass> getSeatClasses() {
        return seatClassService.getAllSeatClasses();
    }
    @GetMapping("/{id}")
    public Optional<SeatClass> getId(@PathVariable("id") int id) {
        return seatClassService.findById(id);
    }

    // Cập nhật loại ghế
    @PutMapping("/{id}")
    public ResponseEntity<SeatClass> updateSeatClass(@PathVariable("id") int id, @RequestBody SeatClass seatClass) {
        Optional<SeatClass> existingClass = seatClassService.getSeatClassById(id);
        if (!existingClass.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        SeatClass updatedClass = seatClassService.saveSeatClass(seatClass);
        return ResponseEntity.ok(updatedClass);
    }

    // Thêm loại ghế mới
    @PostMapping
    public ResponseEntity<SeatClass> createSeatClass(@RequestBody SeatClass seatClass) {
        SeatClass createdClass = seatClassService.saveSeatClass(seatClass);
        return ResponseEntity.status(201).body(createdClass);
    }

    // Xóa loại ghế theo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeatClass(@PathVariable("id") int id) {
        if (!seatClassService.getSeatClassById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        seatClassService.deleteSeatClassById(id);
        return ResponseEntity.noContent().build();
    }
}
