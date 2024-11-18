package com.poly.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.poly.model.Room;

public interface RoomService {

	void deleteAll();

	<S extends Room> List<S> findAll(Example<S> example, Sort sort);

	<S extends Room> List<S> findAll(Example<S> example);

	void deleteAll(Iterable<? extends Room> entities);

	Room getReferenceById(Integer id);

	void deleteAllById(Iterable<? extends Integer> ids);

	void delete(Room entity);

	Room getById(Integer id);

	void deleteById(Integer id);

	long count();

	<S extends Room, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	Room getOne(Integer id);

	void deleteAllInBatch();

	<S extends Room> boolean exists(Example<S> example);

	void deleteAllByIdInBatch(Iterable<Integer> ids);

	<S extends Room> long count(Example<S> example);

	boolean existsById(Integer id);

	void deleteAllInBatch(Iterable<Room> entities);

	Optional<Room> findById(Integer id);

	<S extends Room> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<Room> entities);

	List<Room> findAllById(Iterable<Integer> ids);

	List<Room> findAll();

	<S extends Room> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends Room> S saveAndFlush(S entity);

	Page<Room> findAll(Pageable pageable);

	void flush();

	List<Room> findAll(Sort sort);

	<S extends Room> Optional<S> findOne(Example<S> example);

	<S extends Room> List<S> saveAll(Iterable<S> entities);

	<S extends Room> S save(S entity);

	List<Room> searchByKeyword(String keyword);

}
