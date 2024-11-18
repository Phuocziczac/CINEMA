package com.poly.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.poly.model.Showtime;

public interface ShowtimeService {

	void deleteAll();

	<S extends Showtime> List<S> findAll(Example<S> example, Sort sort);

	<S extends Showtime> List<S> findAll(Example<S> example);

	void deleteAll(Iterable<? extends Showtime> entities);

	Showtime getReferenceById(Integer id);

	void deleteAllById(Iterable<? extends Integer> ids);

	void delete(Showtime entity);

	Showtime getById(Integer id);

	void deleteById(Integer id);

	long count();

	<S extends Showtime, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	Showtime getOne(Integer id);

	void deleteAllInBatch();

	<S extends Showtime> boolean exists(Example<S> example);

	void deleteAllByIdInBatch(Iterable<Integer> ids);

	<S extends Showtime> long count(Example<S> example);

	boolean existsById(Integer id);

	void deleteAllInBatch(Iterable<Showtime> entities);

	Optional<Showtime> findById(Integer id);

	<S extends Showtime> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<Showtime> entities);

	List<Showtime> findAllById(Iterable<Integer> ids);

	List<Showtime> findAll();

	<S extends Showtime> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends Showtime> S saveAndFlush(S entity);

	Page<Showtime> findAll(Pageable pageable);

	void flush();

	List<Showtime> findAll(Sort sort);

	<S extends Showtime> Optional<S> findOne(Example<S> example);

	<S extends Showtime> List<S> saveAll(Iterable<S> entities);

	<S extends Showtime> S save(S entity);

}
