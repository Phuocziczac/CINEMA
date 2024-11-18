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

import com.poly.model.payment_method;
import com.poly.repository.PayMethodRepository;
import com.poly.service.payment_methodService;
@Service
public class payment_methodServiceImpl implements payment_methodService{
@Autowired
private PayMethodRepository payMethodRepository;

@Override
public <S extends payment_method> S save(S entity) {
	return payMethodRepository.save(entity);
}

@Override
public <S extends payment_method> List<S> saveAll(Iterable<S> entities) {
	return payMethodRepository.saveAll(entities);
}

@Override
public <S extends payment_method> Optional<S> findOne(Example<S> example) {
	return payMethodRepository.findOne(example);
}

@Override
public List<payment_method> findAll(Sort sort) {
	return payMethodRepository.findAll(sort);
}

@Override
public void flush() {
	payMethodRepository.flush();
}

@Override
public Page<payment_method> findAll(Pageable pageable) {
	return payMethodRepository.findAll(pageable);
}

@Override
public <S extends payment_method> S saveAndFlush(S entity) {
	return payMethodRepository.saveAndFlush(entity);
}

@Override
public <S extends payment_method> List<S> saveAllAndFlush(Iterable<S> entities) {
	return payMethodRepository.saveAllAndFlush(entities);
}

@Override
public List<payment_method> findAll() {
	return payMethodRepository.findAll();
}

@Override
public List<payment_method> findAllById(Iterable<Integer> ids) {
	return payMethodRepository.findAllById(ids);
}

@Override
public void deleteInBatch(Iterable<payment_method> entities) {
	payMethodRepository.deleteInBatch(entities);
}

@Override
public <S extends payment_method> Page<S> findAll(Example<S> example, Pageable pageable) {
	return payMethodRepository.findAll(example, pageable);
}

@Override
public Optional<payment_method> findById(Integer id) {
	return payMethodRepository.findById(id);
}

@Override
public void deleteAllInBatch(Iterable<payment_method> entities) {
	payMethodRepository.deleteAllInBatch(entities);
}

@Override
public boolean existsById(Integer id) {
	return payMethodRepository.existsById(id);
}

@Override
public <S extends payment_method> long count(Example<S> example) {
	return payMethodRepository.count(example);
}

@Override
public void deleteAllByIdInBatch(Iterable<Integer> ids) {
	payMethodRepository.deleteAllByIdInBatch(ids);
}

@Override
public <S extends payment_method> boolean exists(Example<S> example) {
	return payMethodRepository.exists(example);
}

@Override
public void deleteAllInBatch() {
	payMethodRepository.deleteAllInBatch();
}

@Override
public payment_method getOne(Integer id) {
	return payMethodRepository.getOne(id);
}

@Override
public <S extends payment_method, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
	return payMethodRepository.findBy(example, queryFunction);
}

@Override
public long count() {
	return payMethodRepository.count();
}

@Override
public void deleteById(Integer id) {
	payMethodRepository.deleteById(id);
}

@Override
public payment_method getById(Integer id) {
	return payMethodRepository.getById(id);
}

@Override
public void delete(payment_method entity) {
	payMethodRepository.delete(entity);
}

@Override
public void deleteAllById(Iterable<? extends Integer> ids) {
	payMethodRepository.deleteAllById(ids);
}

@Override
public payment_method getReferenceById(Integer id) {
	return payMethodRepository.getReferenceById(id);
}

@Override
public void deleteAll(Iterable<? extends payment_method> entities) {
	payMethodRepository.deleteAll(entities);
}

@Override
public <S extends payment_method> List<S> findAll(Example<S> example) {
	return payMethodRepository.findAll(example);
}

@Override
public <S extends payment_method> List<S> findAll(Example<S> example, Sort sort) {
	return payMethodRepository.findAll(example, sort);
}

@Override
public void deleteAll() {
	payMethodRepository.deleteAll();
}
}
