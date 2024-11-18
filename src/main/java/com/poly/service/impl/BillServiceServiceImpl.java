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

import com.poly.model.*;

import com.poly.repository.BillServiceRepository;
import com.poly.service.BillServiceService;

@Service
public class BillServiceServiceImpl implements BillServiceService{

	@Autowired
	private BillServiceRepository billServiceRepository;

	@Override
	public <S extends BillService> S save(S entity) {
		return billServiceRepository.save(entity);
	}

	@Override
	public <S extends BillService> List<S> saveAll(Iterable<S> entities) {
		return billServiceRepository.saveAll(entities);
	}

	@Override
	public <S extends BillService> Optional<S> findOne(Example<S> example) {
		return billServiceRepository.findOne(example);
	}

	@Override
	public List<BillService> findAll(Sort sort) {
		return billServiceRepository.findAll(sort);
	}

	@Override
	public void flush() {
		billServiceRepository.flush();
	}

	@Override
	public Page<BillService> findAll(Pageable pageable) {
		return billServiceRepository.findAll(pageable);
	}

	@Override
	public <S extends BillService> S saveAndFlush(S entity) {
		return billServiceRepository.saveAndFlush(entity);
	}

	@Override
	public <S extends BillService> List<S> saveAllAndFlush(Iterable<S> entities) {
		return billServiceRepository.saveAllAndFlush(entities);
	}

	@Override
	public List<BillService> findAll() {
		return billServiceRepository.findAll();
	}

	@Override
	public List<BillService> findAllById(Iterable<BillServicesId> ids) {
		return billServiceRepository.findAllById(ids);
	}

	@Override
	public void deleteInBatch(Iterable<BillService> entities) {
		billServiceRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends BillService> Page<S> findAll(Example<S> example, Pageable pageable) {
		return billServiceRepository.findAll(example, pageable);
	}

	@Override
	public Optional<BillService> findById(BillServicesId id) {
		return billServiceRepository.findById(id);
	}

	@Override
	public void deleteAllInBatch(Iterable<BillService> entities) {
		billServiceRepository.deleteAllInBatch(entities);
	}

	@Override
	public boolean existsById(BillServicesId id) {
		return billServiceRepository.existsById(id);
	}

	@Override
	public <S extends BillService> long count(Example<S> example) {
		return billServiceRepository.count(example);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<BillServicesId> ids) {
		billServiceRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends BillService> boolean exists(Example<S> example) {
		return billServiceRepository.exists(example);
	}

	@Override
	public void deleteAllInBatch() {
		billServiceRepository.deleteAllInBatch();
	}

	@Override
	public BillService getOne(BillServicesId id) {
		return billServiceRepository.getOne(id);
	}

	@Override
	public <S extends BillService, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return billServiceRepository.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return billServiceRepository.count();
	}

	@Override
	public void deleteById(BillServicesId id) {
		billServiceRepository.deleteById(id);
	}

	@Override
	public BillService getById(BillServicesId id) {
		return billServiceRepository.getById(id);
	}

	@Override
	public void delete(BillService entity) {
		billServiceRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends BillServicesId> ids) {
		billServiceRepository.deleteAllById(ids);
	}

	@Override
	public BillService getReferenceById(BillServicesId id) {
		return billServiceRepository.getReferenceById(id);
	}

	@Override
	public void deleteAll(Iterable<? extends BillService> entities) {
		billServiceRepository.deleteAll(entities);
	}

	@Override
	public <S extends BillService> List<S> findAll(Example<S> example) {
		return billServiceRepository.findAll(example);
	}

	@Override
	public <S extends BillService> List<S> findAll(Example<S> example, Sort sort) {
		return billServiceRepository.findAll(example, sort);
	}

	@Override
	public void deleteAll() {
		billServiceRepository.deleteAll();
	}



	
}
