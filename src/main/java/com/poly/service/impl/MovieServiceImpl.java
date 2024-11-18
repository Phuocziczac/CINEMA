package com.poly.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.poly.model.Movie;
import com.poly.model.MovieCategory;
import com.poly.repository.MovieRepository;
import com.poly.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieRepository movieRepository;

	@Override
	public <S extends Movie> S save(S entity) {
		return movieRepository.save(entity);
	}

	@Override
	public <S extends Movie> List<S> saveAll(Iterable<S> entities) {
		return movieRepository.saveAll(entities);
	}

	@Override
	public <S extends Movie> Optional<S> findOne(Example<S> example) {
		return movieRepository.findOne(example);
	}

	@Override
	public List<Movie> findAll(Sort sort) {
		return movieRepository.findAll(sort);
	}

	@Override
	public void flush() {
		movieRepository.flush();
	}

	@Override
	public Page<Movie> findAll(Pageable pageable) {
		return movieRepository.findAll(pageable);
	}

	@Override
	public <S extends Movie> S saveAndFlush(S entity) {
		return movieRepository.saveAndFlush(entity);
	}

	@Override
	public <S extends Movie> List<S> saveAllAndFlush(Iterable<S> entities) {
		return movieRepository.saveAllAndFlush(entities);
	}

	@Override
	public List<Movie> findAll() {
		return movieRepository.findAll();
	}

	@Override
	public List<Movie> findAllById(Iterable<Integer> ids) {
		return movieRepository.findAllById(ids);
	}

	@Override
	public void deleteInBatch(Iterable<Movie> entities) {
		movieRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Movie> Page<S> findAll(Example<S> example, Pageable pageable) {
		return movieRepository.findAll(example, pageable);
	}

	@Override
	public Optional<Movie> findById(Integer id) {
		return movieRepository.findById(id);
	}

	@Override
	public void deleteAllInBatch(Iterable<Movie> entities) {
		movieRepository.deleteAllInBatch(entities);
	}

	@Override
	public boolean existsById(Integer id) {
		return movieRepository.existsById(id);
	}

	@Override
	public <S extends Movie> long count(Example<S> example) {
		return movieRepository.count(example);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		movieRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends Movie> boolean exists(Example<S> example) {
		return movieRepository.exists(example);
	}

	@Override
	public void deleteAllInBatch() {
		movieRepository.deleteAllInBatch();
	}

	@Override
	public Movie getOne(Integer id) {
		return movieRepository.getOne(id);
	}

	@Override
	public <S extends Movie, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return movieRepository.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return movieRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		movieRepository.deleteById(id);
	}

	@Override
	public Movie getById(Integer id) {
		return movieRepository.getById(id);
	}

	@Override
	public void delete(Movie entity) {
		movieRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		movieRepository.deleteAllById(ids);
	}

	@Override
	public Movie getReferenceById(Integer id) {
		return movieRepository.getReferenceById(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Movie> entities) {
		movieRepository.deleteAll(entities);
	}

	@Override
	public <S extends Movie> List<S> findAll(Example<S> example) {
		return movieRepository.findAll(example);
	}

	@Override
	public <S extends Movie> List<S> findAll(Example<S> example, Sort sort) {
		return movieRepository.findAll(example, sort);
	}

	@Override
	public void deleteAll() {
		movieRepository.deleteAll();
	}

	@Override
	public List<MovieCategory> findByMovieId(int movieId) {
		// TODO Auto-generated method stub
		return null;
	}

}
