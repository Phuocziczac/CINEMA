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
import com.poly.model.MovieCategoryId;
import com.poly.repository.MovieCategoryRepository;
import com.poly.service.MovieCategoryService;
import com.poly.service.MovieService;

@Service
public class MovieCategoryServiceimpl implements MovieCategoryService{

@Autowired
MovieCategoryRepository movieCategoryRepository;

@Override
public List<MovieCategory> findByMovieId(int movieId) {
	return movieCategoryRepository.findByMovieId(movieId);
}

@Override
public <S extends MovieCategory> S save(S entity) {
	return movieCategoryRepository.save(entity);
}

@Override
public <S extends MovieCategory> List<S> saveAll(Iterable<S> entities) {
	return movieCategoryRepository.saveAll(entities);
}

@Override
public <S extends MovieCategory> Optional<S> findOne(Example<S> example) {
	return movieCategoryRepository.findOne(example);
}

@Override
public List<MovieCategory> findAll(Sort sort) {
	return movieCategoryRepository.findAll(sort);
}

@Override
public void flush() {
	movieCategoryRepository.flush();
}

@Override
public Page<MovieCategory> findAll(Pageable pageable) {
	return movieCategoryRepository.findAll(pageable);
}

@Override
public <S extends MovieCategory> S saveAndFlush(S entity) {
	return movieCategoryRepository.saveAndFlush(entity);
}

@Override
public <S extends MovieCategory> List<S> saveAllAndFlush(Iterable<S> entities) {
	return movieCategoryRepository.saveAllAndFlush(entities);
}

@Override
public List<MovieCategory> findAll() {
	return movieCategoryRepository.findAll();
}

@Override
public List<MovieCategory> findAllById(Iterable<MovieCategoryId> ids) {
	return movieCategoryRepository.findAllById(ids);
}

@Override
public void deleteInBatch(Iterable<MovieCategory> entities) {
	movieCategoryRepository.deleteInBatch(entities);
}

@Override
public <S extends MovieCategory> Page<S> findAll(Example<S> example, Pageable pageable) {
	return movieCategoryRepository.findAll(example, pageable);
}

@Override
public Optional<MovieCategory> findById(MovieCategoryId id) {
	return movieCategoryRepository.findById(id);
}

@Override
public void deleteAllInBatch(Iterable<MovieCategory> entities) {
	movieCategoryRepository.deleteAllInBatch(entities);
}

@Override
public boolean existsById(MovieCategoryId id) {
	return movieCategoryRepository.existsById(id);
}

@Override
public <S extends MovieCategory> long count(Example<S> example) {
	return movieCategoryRepository.count(example);
}

@Override
public void deleteAllByIdInBatch(Iterable<MovieCategoryId> ids) {
	movieCategoryRepository.deleteAllByIdInBatch(ids);
}

@Override
public <S extends MovieCategory> boolean exists(Example<S> example) {
	return movieCategoryRepository.exists(example);
}

@Override
public void deleteAllInBatch() {
	movieCategoryRepository.deleteAllInBatch();
}

@Override
public MovieCategory getOne(MovieCategoryId id) {
	return movieCategoryRepository.getOne(id);
}

@Override
public <S extends MovieCategory, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
	return movieCategoryRepository.findBy(example, queryFunction);
}

@Override
public long count() {
	return movieCategoryRepository.count();
}

@Override
public void deleteById(MovieCategoryId id) {
	movieCategoryRepository.deleteById(id);
}

@Override
public MovieCategory getById(MovieCategoryId id) {
	return movieCategoryRepository.getById(id);
}

@Override
public void delete(MovieCategory entity) {
	movieCategoryRepository.delete(entity);
}

@Override
public void deleteAllById(Iterable<? extends MovieCategoryId> ids) {
	movieCategoryRepository.deleteAllById(ids);
}

@Override
public MovieCategory getReferenceById(MovieCategoryId id) {
	return movieCategoryRepository.getReferenceById(id);
}

@Override
public void deleteAll(Iterable<? extends MovieCategory> entities) {
	movieCategoryRepository.deleteAll(entities);
}

@Override
public <S extends MovieCategory> List<S> findAll(Example<S> example) {
	return movieCategoryRepository.findAll(example);
}

@Override
public <S extends MovieCategory> List<S> findAll(Example<S> example, Sort sort) {
	return movieCategoryRepository.findAll(example, sort);
}

@Override
public void deleteAll() {
	movieCategoryRepository.deleteAll();
}

	
}
