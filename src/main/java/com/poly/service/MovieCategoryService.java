package com.poly.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.poly.model.MovieCategory;
import com.poly.model.MovieCategoryId;

public interface  MovieCategoryService {

	void deleteAll();

	<S extends MovieCategory> List<S> findAll(Example<S> example, Sort sort);

	<S extends MovieCategory> List<S> findAll(Example<S> example);

	void deleteAll(Iterable<? extends MovieCategory> entities);

	MovieCategory getReferenceById(MovieCategoryId id);

	void deleteAllById(Iterable<? extends MovieCategoryId> ids);

	void delete(MovieCategory entity);

	MovieCategory getById(MovieCategoryId id);

	void deleteById(MovieCategoryId id);

	long count();

	<S extends MovieCategory, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	MovieCategory getOne(MovieCategoryId id);

	void deleteAllInBatch();

	<S extends MovieCategory> boolean exists(Example<S> example);

	void deleteAllByIdInBatch(Iterable<MovieCategoryId> ids);

	<S extends MovieCategory> long count(Example<S> example);

	boolean existsById(MovieCategoryId id);

	void deleteAllInBatch(Iterable<MovieCategory> entities);

	Optional<MovieCategory> findById(MovieCategoryId id);

	<S extends MovieCategory> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<MovieCategory> entities);

	List<MovieCategory> findAllById(Iterable<MovieCategoryId> ids);

	List<MovieCategory> findAll();

	<S extends MovieCategory> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends MovieCategory> S saveAndFlush(S entity);

	Page<MovieCategory> findAll(Pageable pageable);

	void flush();

	List<MovieCategory> findAll(Sort sort);

	<S extends MovieCategory> Optional<S> findOne(Example<S> example);

	<S extends MovieCategory> List<S> saveAll(Iterable<S> entities);

	<S extends MovieCategory> S save(S entity);

	List<MovieCategory> findByMovieId(int movieId);

}
