package com.poly.service;

import com.poly.model.SeatClass;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

public interface SeatClassService {

	void deleteAll();

	<S extends SeatClass> List<S> findAll(Example<S> example, Sort sort);

	<S extends SeatClass> List<S> findAll(Example<S> example);

	void deleteAll(Iterable<? extends SeatClass> entities);

	SeatClass getReferenceById(Integer id);

	void deleteAllById(Iterable<? extends Integer> ids);

	void delete(SeatClass entity);

	SeatClass getById(Integer id);

	void deleteById(Integer id);

	long count();

	<S extends SeatClass, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	SeatClass getOne(Integer id);

	void deleteAllInBatch();

	<S extends SeatClass> boolean exists(Example<S> example);

	void deleteAllByIdInBatch(Iterable<Integer> ids);

	<S extends SeatClass> long count(Example<S> example);

	boolean existsById(Integer id);

	void deleteAllInBatch(Iterable<SeatClass> entities);

	Optional<SeatClass> findById(Integer id);

	<S extends SeatClass> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<SeatClass> entities);

	List<SeatClass> findAllById(Iterable<Integer> ids);

	List<SeatClass> findAll();

	<S extends SeatClass> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends SeatClass> S saveAndFlush(S entity);

	Page<SeatClass> findAll(Pageable pageable);

	void flush();

	List<SeatClass> findAll(Sort sort);

	<S extends SeatClass> Optional<S> findOne(Example<S> example);

	<S extends SeatClass> List<S> saveAll(Iterable<S> entities);

	<S extends SeatClass> S save(S entity);

	List<SeatClass> getAllSeatClasses();

	Optional<SeatClass> getSeatClassById(int id);

	SeatClass saveSeatClass(SeatClass seatClass);

	void deleteSeatClassById(int id);
	
}
