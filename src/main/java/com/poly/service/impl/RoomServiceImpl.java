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

import com.poly.model.Room;
import com.poly.repository.RoomRepository;
import com.poly.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {
	@Autowired
	private RoomRepository roomRepository;

	@Override
	public <S extends Room> S save(S entity) {
		return roomRepository.save(entity);
	}

	@Override
	public <S extends Room> List<S> saveAll(Iterable<S> entities) {
		return roomRepository.saveAll(entities);
	}

	@Override
	public <S extends Room> Optional<S> findOne(Example<S> example) {
		return roomRepository.findOne(example);
	}

	@Override
	public List<Room> findAll(Sort sort) {
		return roomRepository.findAll(sort);
	}

	@Override
	public void flush() {
		roomRepository.flush();
	}

	@Override
	public Page<Room> findAll(Pageable pageable) {
		return roomRepository.findAll(pageable);
	}

	@Override
	public <S extends Room> S saveAndFlush(S entity) {
		return roomRepository.saveAndFlush(entity);
	}

	@Override
	public <S extends Room> List<S> saveAllAndFlush(Iterable<S> entities) {
		return roomRepository.saveAllAndFlush(entities);
	}

	@Override
	public List<Room> findAll() {
		return roomRepository.findAll();
	}

	@Override
	public List<Room> findAllById(Iterable<Integer> ids) {
		return roomRepository.findAllById(ids);
	}

	@Override
	public List<Room> searchByKeyword(String keyword) {
		return roomRepository.searchByKeyword(keyword);
	}

	@Override
	public void deleteInBatch(Iterable<Room> entities) {
		roomRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Room> Page<S> findAll(Example<S> example, Pageable pageable) {
		return roomRepository.findAll(example, pageable);
	}

	@Override
	public Optional<Room> findById(Integer id) {
		return roomRepository.findById(id);
	}

	@Override
	public void deleteAllInBatch(Iterable<Room> entities) {
		roomRepository.deleteAllInBatch(entities);
	}

	@Override
	public boolean existsById(Integer id) {
		return roomRepository.existsById(id);
	}

	@Override
	public <S extends Room> long count(Example<S> example) {
		return roomRepository.count(example);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		roomRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends Room> boolean exists(Example<S> example) {
		return roomRepository.exists(example);
	}

	@Override
	public void deleteAllInBatch() {
		roomRepository.deleteAllInBatch();
	}

	@Override
	public Room getOne(Integer id) {
		return roomRepository.getOne(id);
	}

	@Override
	public <S extends Room, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return roomRepository.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return roomRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		roomRepository.deleteById(id);
	}

	@Override
	public Room getById(Integer id) {
		return roomRepository.getById(id);
	}

	@Override
	public void delete(Room entity) {
		roomRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		roomRepository.deleteAllById(ids);
	}

	@Override
	public Room getReferenceById(Integer id) {
		return roomRepository.getReferenceById(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Room> entities) {
		roomRepository.deleteAll(entities);
	}

	@Override
	public <S extends Room> List<S> findAll(Example<S> example) {
		return roomRepository.findAll(example);
	}

	@Override
	public <S extends Room> List<S> findAll(Example<S> example, Sort sort) {
		return roomRepository.findAll(example, sort);
	}

	@Override
	public void deleteAll() {
		roomRepository.deleteAll();
	}

}
