package com.poly.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.poly.model.BillSeats;
import com.poly.model.BillSeatsId;

public interface BillSeatsService {

	void deleteAll();

	<S extends BillSeats> List<S> findAll(Example<S> example, Sort sort);

	<S extends BillSeats> List<S> findAll(Example<S> example);

	void deleteAll(Iterable<? extends BillSeats> entities);

	BillSeats getReferenceById(BillSeatsId id);

	void deleteAllById(Iterable<? extends BillSeatsId> ids);

	void delete(BillSeats entity);

	BillSeats getById(BillSeatsId id);

	void deleteById(BillSeatsId id);

	long count();

	<S extends BillSeats, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	BillSeats getOne(BillSeatsId id);

	void deleteAllInBatch();

	<S extends BillSeats> boolean exists(Example<S> example);

	void deleteAllByIdInBatch(Iterable<BillSeatsId> ids);

	<S extends BillSeats> long count(Example<S> example);

	boolean existsById(BillSeatsId id);

	void deleteAllInBatch(Iterable<BillSeats> entities);

	Optional<BillSeats> findById(BillSeatsId id);

	<S extends BillSeats> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<BillSeats> entities);

	List<BillSeats> findAllById(Iterable<BillSeatsId> ids);

	List<BillSeats> findAll();

	<S extends BillSeats> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends BillSeats> S saveAndFlush(S entity);

	Page<BillSeats> findAll(Pageable pageable);

	void flush();

	List<BillSeats> findAll(Sort sort);

	<S extends BillSeats> Optional<S> findOne(Example<S> example);

	<S extends BillSeats> List<S> saveAll(Iterable<S> entities);

	<S extends BillSeats> S save(S entity);

}
