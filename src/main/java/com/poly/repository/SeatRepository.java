package com.poly.repository;

import com.poly.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
    List<Seat> findByRoomId(int roomId); // Tìm ghế theo mã phòng

	Optional<Seat> findByRoomIdAndRowNumberAndSeatNumber(int roomId, String rowNumber, int seatNumber);

	boolean existsByShowtimeIdAndRoomIdAndAccountId(Integer showtimeId, Integer roomId, int id);

	Seat findByShowtimeIdAndRoomIdAndAccountId(Integer showtimeId, Integer roomId, int id);

	
}
