package com.poly.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.poly.model.payment_method;

public interface payment_methodService {

	void deleteAll();

	<S extends payment_method> List<S> findAll(Example<S> example, Sort sort);

	<S extends payment_method> List<S> findAll(Example<S> example);

	void deleteAll(Iterable<? extends payment_method> entities);

	payment_method getReferenceById(Integer id);

	void deleteAllById(Iterable<? extends Integer> ids);

	void delete(payment_method entity);

	payment_method getById(Integer id);

	void deleteById(Integer id);

	long count();

	<S extends payment_method, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	payment_method getOne(Integer id);

	void deleteAllInBatch();

	<S extends payment_method> boolean exists(Example<S> example);

	void deleteAllByIdInBatch(Iterable<Integer> ids);

	<S extends payment_method> long count(Example<S> example);

	boolean existsById(Integer id);

	void deleteAllInBatch(Iterable<payment_method> entities);

	Optional<payment_method> findById(Integer id);

	<S extends payment_method> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<payment_method> entities);

	List<payment_method> findAllById(Iterable<Integer> ids);

	List<payment_method> findAll();

	<S extends payment_method> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends payment_method> S saveAndFlush(S entity);

	Page<payment_method> findAll(Pageable pageable);

	void flush();

	List<payment_method> findAll(Sort sort);

	<S extends payment_method> Optional<S> findOne(Example<S> example);

	<S extends payment_method> List<S> saveAll(Iterable<S> entities);

	<S extends payment_method> S save(S entity);

}
