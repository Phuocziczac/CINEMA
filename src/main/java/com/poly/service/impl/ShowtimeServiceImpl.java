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

import com.poly.model.Showtime;
import com.poly.repository.ShowtimeRepository;
import com.poly.service.ShowtimeService;

@Service
public class ShowtimeServiceImpl implements ShowtimeService {
	@Autowired
	private ShowtimeRepository showtimeRepository;

	@Override
	public <S extends Showtime> S save(S entity) {
		return showtimeRepository.save(entity);
	}

	@Override
	public <S extends Showtime> List<S> saveAll(Iterable<S> entities) {
		return showtimeRepository.saveAll(entities);
	}

	@Override
	public <S extends Showtime> Optional<S> findOne(Example<S> example) {
		return showtimeRepository.findOne(example);
	}

	@Override
	public List<Showtime> findAll(Sort sort) {
		return showtimeRepository.findAll(sort);
	}

	@Override
	public void flush() {
		showtimeRepository.flush();
	}

	@Override
	public Page<Showtime> findAll(Pageable pageable) {
		return showtimeRepository.findAll(pageable);
	}

	@Override
	public <S extends Showtime> S saveAndFlush(S entity) {
		return showtimeRepository.saveAndFlush(entity);
	}

	@Override
	public <S extends Showtime> List<S> saveAllAndFlush(Iterable<S> entities) {
		return showtimeRepository.saveAllAndFlush(entities);
	}

	@Override
	public List<Showtime> findAll() {
		return showtimeRepository.findAll();
	}

	@Override
	public List<Showtime> findAllById(Iterable<Integer> ids) {
		return showtimeRepository.findAllById(ids);
	}

	@Override
	public void deleteInBatch(Iterable<Showtime> entities) {
		showtimeRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Showtime> Page<S> findAll(Example<S> example, Pageable pageable) {
		return showtimeRepository.findAll(example, pageable);
	}

	@Override
	public Optional<Showtime> findById(Integer id) {
		return showtimeRepository.findById(id);
	}

	@Override
	public void deleteAllInBatch(Iterable<Showtime> entities) {
		showtimeRepository.deleteAllInBatch(entities);
	}

	@Override
	public boolean existsById(Integer id) {
		return showtimeRepository.existsById(id);
	}

	@Override
	public <S extends Showtime> long count(Example<S> example) {
		return showtimeRepository.count(example);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		showtimeRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends Showtime> boolean exists(Example<S> example) {
		return showtimeRepository.exists(example);
	}

	@Override
	public void deleteAllInBatch() {
		showtimeRepository.deleteAllInBatch();
	}

	@Override
	public Showtime getOne(Integer id) {
		return showtimeRepository.getOne(id);
	}

	@Override
	public <S extends Showtime, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return showtimeRepository.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return showtimeRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		showtimeRepository.deleteById(id);
	}

	@Override
	public Showtime getById(Integer id) {
		return showtimeRepository.getById(id);
	}

	@Override
	public void delete(Showtime entity) {
		showtimeRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		showtimeRepository.deleteAllById(ids);
	}

	@Override
	public Showtime getReferenceById(Integer id) {
		return showtimeRepository.getReferenceById(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Showtime> entities) {
		showtimeRepository.deleteAll(entities);
	}

	@Override
	public <S extends Showtime> List<S> findAll(Example<S> example) {
		return showtimeRepository.findAll(example);
	}

	@Override
	public <S extends Showtime> List<S> findAll(Example<S> example, Sort sort) {
		return showtimeRepository.findAll(example, sort);
	}

	@Override
	public void deleteAll() {
		showtimeRepository.deleteAll();
	}

}
