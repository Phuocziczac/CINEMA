package com.poly.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.poly.model.BillSeats;
import com.poly.model.BillSeatsId;
import com.poly.repository.BillSeatRepository;
import com.poly.service.BillSeatsService;

@Service
public class Bill_SeatsServiceImpl implements BillSeatsService {
 private BillSeatRepository billSeatRepository;

@Override
public <S extends BillSeats> S save(S entity) {
	return billSeatRepository.save(entity);
}

@Override
public <S extends BillSeats> List<S> saveAll(Iterable<S> entities) {
	return billSeatRepository.saveAll(entities);
}

@Override
public <S extends BillSeats> Optional<S> findOne(Example<S> example) {
	return billSeatRepository.findOne(example);
}

@Override
public List<BillSeats> findAll(Sort sort) {
	return billSeatRepository.findAll(sort);
}

@Override
public void flush() {
	billSeatRepository.flush();
}

@Override
public Page<BillSeats> findAll(Pageable pageable) {
	return billSeatRepository.findAll(pageable);
}

@Override
public <S extends BillSeats> S saveAndFlush(S entity) {
	return billSeatRepository.saveAndFlush(entity);
}

@Override
public <S extends BillSeats> List<S> saveAllAndFlush(Iterable<S> entities) {
	return billSeatRepository.saveAllAndFlush(entities);
}

@Override
public List<BillSeats> findAll() {
	return billSeatRepository.findAll();
}

@Override
public List<BillSeats> findAllById(Iterable<BillSeatsId> ids) {
	return billSeatRepository.findAllById(ids);
}

@Override
public void deleteInBatch(Iterable<BillSeats> entities) {
	billSeatRepository.deleteInBatch(entities);
}

@Override
public <S extends BillSeats> Page<S> findAll(Example<S> example, Pageable pageable) {
	return billSeatRepository.findAll(example, pageable);
}

@Override
public Optional<BillSeats> findById(BillSeatsId id) {
	return billSeatRepository.findById(id);
}

@Override
public void deleteAllInBatch(Iterable<BillSeats> entities) {
	billSeatRepository.deleteAllInBatch(entities);
}

@Override
public boolean existsById(BillSeatsId id) {
	return billSeatRepository.existsById(id);
}

@Override
public <S extends BillSeats> long count(Example<S> example) {
	return billSeatRepository.count(example);
}

@Override
public void deleteAllByIdInBatch(Iterable<BillSeatsId> ids) {
	billSeatRepository.deleteAllByIdInBatch(ids);
}

@Override
public <S extends BillSeats> boolean exists(Example<S> example) {
	return billSeatRepository.exists(example);
}

@Override
public void deleteAllInBatch() {
	billSeatRepository.deleteAllInBatch();
}

@Override
public BillSeats getOne(BillSeatsId id) {
	return billSeatRepository.getOne(id);
}

@Override
public <S extends BillSeats, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
	return billSeatRepository.findBy(example, queryFunction);
}

@Override
public long count() {
	return billSeatRepository.count();
}

@Override
public void deleteById(BillSeatsId id) {
	billSeatRepository.deleteById(id);
}

@Override
public BillSeats getById(BillSeatsId id) {
	return billSeatRepository.getById(id);
}

@Override
public void delete(BillSeats entity) {
	billSeatRepository.delete(entity);
}

@Override
public void deleteAllById(Iterable<? extends BillSeatsId> ids) {
	billSeatRepository.deleteAllById(ids);
}

@Override
public BillSeats getReferenceById(BillSeatsId id) {
	return billSeatRepository.getReferenceById(id);
}

@Override
public void deleteAll(Iterable<? extends BillSeats> entities) {
	billSeatRepository.deleteAll(entities);
}

@Override
public <S extends BillSeats> List<S> findAll(Example<S> example) {
	return billSeatRepository.findAll(example);
}

@Override
public <S extends BillSeats> List<S> findAll(Example<S> example, Sort sort) {
	return billSeatRepository.findAll(example, sort);
}

@Override
public void deleteAll() {
	billSeatRepository.deleteAll();
}
}
