package com.poly.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.model.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

    List<Schedule> findByMovieId(int movieId);

    @Query(value = "SELECT DISTINCT s.screeningDate FROM Schedule s WHERE s.movie.id = ?1 ORDER BY s.screeningDate DESC")
    List<LocalDate> findDistinctScreeningDates(int movieId);
    
    @Query("SELECT s FROM Schedule s WHERE s.screeningDate = :screeningDate AND s.movie.id = :movieId")
    List<Schedule> findByScreeningDateAndMovieId(@Param("screeningDate") LocalDate screeningDate, @Param("movieId") int movieId);

    @Query("SELECT s.screeningDate, m.name, STRING_AGG(st.startTime, ', ') AS showtime " +
           "FROM Schedule s " +
           "JOIN s.movie m " +
           "JOIN s.showtime st " +
           "WHERE s.screeningDate = :screeningDate AND m.id = :movieId " +
           "GROUP BY s.screeningDate, m.name")
    List<Object[]> findShowtimesByDateAndMovie(@Param("screeningDate") LocalDate screeningDate, @Param("movieId") int movieId);
}
