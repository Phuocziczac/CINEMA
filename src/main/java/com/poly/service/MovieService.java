package com.poly.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.poly.model.Movie;
import com.poly.model.MovieCategory;

public interface MovieService {

	void deleteAll();

	<S extends Movie> List<S> findAll(Example<S> example, Sort sort);

	<S extends Movie> List<S> findAll(Example<S> example);

	void deleteAll(Iterable<? extends Movie> entities);

	Movie getReferenceById(Integer id);

	void deleteAllById(Iterable<? extends Integer> ids);

	void delete(Movie entity);

	Movie getById(Integer id);

	void deleteById(Integer id);

	long count();

	<S extends Movie, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	Movie getOne(Integer id);

	void deleteAllInBatch();

	<S extends Movie> boolean exists(Example<S> example);

	void deleteAllByIdInBatch(Iterable<Integer> ids);

	<S extends Movie> long count(Example<S> example);

	boolean existsById(Integer id);

	void deleteAllInBatch(Iterable<Movie> entities);

	Optional<Movie> findById(Integer id);

	<S extends Movie> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<Movie> entities);

	List<Movie> findAllById(Iterable<Integer> ids);

	List<Movie> findAll();

	<S extends Movie> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends Movie> S saveAndFlush(S entity);

	Page<Movie> findAll(Pageable pageable);

	void flush();

	List<Movie> findAll(Sort sort);

	<S extends Movie> Optional<S> findOne(Example<S> example);

	<S extends Movie> List<S> saveAll(Iterable<S> entities);

	<S extends Movie> S save(S entity);

	List<MovieCategory> findByMovieId(int movieId);

}
