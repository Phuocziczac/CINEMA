package com.poly.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.poly.model.*;
import com.poly.model.BillService;

public interface BillServiceService {

	void deleteAll();

	<S extends BillService> List<S> findAll(Example<S> example, Sort sort);

	<S extends BillService> List<S> findAll(Example<S> example);

	void deleteAll(Iterable<? extends BillService> entities);

	BillService getReferenceById(BillServicesId id);

	void deleteAllById(Iterable<? extends BillServicesId> ids);

	void delete(BillService entity);

	BillService getById(BillServicesId id);

	void deleteById(BillServicesId id);

	long count();

	<S extends BillService, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	BillService getOne(BillServicesId id);

	void deleteAllInBatch();

	<S extends BillService> boolean exists(Example<S> example);

	void deleteAllByIdInBatch(Iterable<BillServicesId> ids);

	<S extends BillService> long count(Example<S> example);

	boolean existsById(BillServicesId id);

	void deleteAllInBatch(Iterable<BillService> entities);

	Optional<BillService> findById(BillServicesId id);

	<S extends BillService> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<BillService> entities);

	List<BillService> findAllById(Iterable<BillServicesId> ids);

	List<BillService> findAll();

	<S extends BillService> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends BillService> S saveAndFlush(S entity);

	Page<BillService> findAll(Pageable pageable);

	void flush();

	List<BillService> findAll(Sort sort);

	<S extends BillService> Optional<S> findOne(Example<S> example);

	<S extends BillService> List<S> saveAll(Iterable<S> entities);

	<S extends BillService> S save(S entity);



}
