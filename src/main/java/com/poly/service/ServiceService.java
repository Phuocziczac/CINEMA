package com.poly.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.poly.model.Service;

public interface ServiceService {

	void deleteAll();

	<S extends com.poly.model.Service> List<S> findAll(Example<S> example, Sort sort);

	<S extends com.poly.model.Service> List<S> findAll(Example<S> example);

	void deleteAll(Iterable<? extends com.poly.model.Service> entities);

	com.poly.model.Service getReferenceById(Integer id);

	void deleteAllById(Iterable<? extends Integer> ids);

	void delete(com.poly.model.Service entity);

	com.poly.model.Service getById(Integer id);

	void deleteById(Integer id);

	long count();

	<S extends com.poly.model.Service, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	com.poly.model.Service getOne(Integer id);

	void deleteAllInBatch();

	<S extends com.poly.model.Service> boolean exists(Example<S> example);

	void deleteAllByIdInBatch(Iterable<Integer> ids);

	<S extends com.poly.model.Service> long count(Example<S> example);

	boolean existsById(Integer id);

	void deleteAllInBatch(Iterable<com.poly.model.Service> entities);

	Optional<com.poly.model.Service> findById(Integer id);

	<S extends com.poly.model.Service> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<com.poly.model.Service> entities);

	List<com.poly.model.Service> findAllById(Iterable<Integer> ids);

	List<com.poly.model.Service> findAll();

	<S extends com.poly.model.Service> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends com.poly.model.Service> S saveAndFlush(S entity);

	Page<com.poly.model.Service> findAll(Pageable pageable);

	void flush();

	List<com.poly.model.Service> findAll(Sort sort);

	<S extends com.poly.model.Service> Optional<S> findOne(Example<S> example);

	<S extends com.poly.model.Service> List<S> saveAll(Iterable<S> entities);

	<S extends com.poly.model.Service> S save(S entity);
	List<Service> searchByKeyword(String keyword);

	List<Service> searchByKeywordCustomer(String keyword);
	
	Page<Service> findByRoleIdIn(List<Integer> roleIds, Pageable pageable);

	
}
