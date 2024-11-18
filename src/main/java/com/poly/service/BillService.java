package com.poly.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.poly.model.Bill;

public interface BillService {

	void deleteAll();

	<S extends Bill> List<S> findAll(Example<S> example, Sort sort);

	<S extends Bill> List<S> findAll(Example<S> example);

	void deleteAll(Iterable<? extends Bill> entities);

	Bill getReferenceById(Integer id);

	void deleteAllById(Iterable<? extends Integer> ids);

	void delete(Bill entity);

	Bill getById(Integer id);

	void deleteById(Integer id);

	long count();

	<S extends Bill, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	Bill getOne(Integer id);

	void deleteAllInBatch();

	<S extends Bill> boolean exists(Example<S> example);

	void deleteAllByIdInBatch(Iterable<Integer> ids);

	<S extends Bill> long count(Example<S> example);

	boolean existsById(Integer id);

	void deleteAllInBatch(Iterable<Bill> entities);

	Optional<Bill> findById(Integer id);

	<S extends Bill> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<Bill> entities);

	List<Bill> findAllById(Iterable<Integer> ids);

	List<Bill> findAll();

	<S extends Bill> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends Bill> S saveAndFlush(S entity);

	Page<Bill> findAll(Pageable pageable);

	void flush();

	List<Bill> findAll(Sort sort);

	<S extends Bill> Optional<S> findOne(Example<S> example);

	<S extends Bill> List<S> saveAll(Iterable<S> entities);

	<S extends Bill> S save(S entity);

}
