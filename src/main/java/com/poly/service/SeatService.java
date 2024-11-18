package com.poly.service;

import com.poly.model.Seat;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

public interface SeatService {
    // Additional custom methods if needed
	void deleteAll();
	<S extends Seat> List<S> findAll(Example<S> example, Sort sort);
	<S extends Seat> List<S> findAll(Example<S> example);
	void deleteAll(Iterable<? extends Seat> entities);
	Seat getReferenceById(Integer id);
	void deleteAllById(Iterable<? extends Integer> ids);
	void delete(Seat entity);
	Seat getById(Integer id);
	void deleteById(Integer id);
	long count();
	<S extends Seat, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);
	Seat getOne(Integer id);
	void deleteAllInBatch();
	<S extends Seat> boolean exists(Example<S> example);
	void deleteAllByIdInBatch(Iterable<Integer> ids);
	<S extends Seat> long count(Example<S> example);
	boolean existsById(Integer id);
	void deleteAllInBatch(Iterable<Seat> entities);
	Optional<Seat> findById(Integer id);
	<S extends Seat> Page<S> findAll(Example<S> example, Pageable pageable);
	void deleteInBatch(Iterable<Seat> entities);
	List<Seat> findAllById(Iterable<Integer> ids);
	List<Seat> findAll();
	<S extends Seat> List<S> saveAllAndFlush(Iterable<S> entities);
	<S extends Seat> S saveAndFlush(S entity);
	Page<Seat> findAll(Pageable pageable);
	void flush();
	List<Seat> findAll(Sort sort);
	<S extends Seat> Optional<S> findOne(Example<S> example);
	<S extends Seat> List<S> saveAll(Iterable<S> entities);
	<S extends Seat> S save(S entity);
	List<Seat> findByRoomId(int roomId);
	void deleteSeatById(Integer id);
	Seat saveSeat(Seat seat);
	Optional<Seat> getSeatById(Integer id);
	List<Seat> getAllSeats();
	List<Seat> getSeatsByRoomId(int roomId);
	Optional<Seat> findByRoomIdAndRowNumberAndSeatNumber(int roomId, String rowNumber, int seatNumber);
	
}
