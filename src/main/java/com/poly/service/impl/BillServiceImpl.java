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

import com.poly.model.Bill;
import com.poly.repository.BillRepository;
import com.poly.service.BillService;

@Service
public class BillServiceImpl implements BillService {
	@Autowired
	private BillRepository billRepository;

	@Override
	public <S extends Bill> S save(S entity) {
		return billRepository.save(entity);
	}

	@Override
	public <S extends Bill> List<S> saveAll(Iterable<S> entities) {
		return billRepository.saveAll(entities);
	}

	@Override
	public <S extends Bill> Optional<S> findOne(Example<S> example) {
		return billRepository.findOne(example);
	}

	@Override
	public List<Bill> findAll(Sort sort) {
		return billRepository.findAll(sort);
	}

	@Override
	public void flush() {
		billRepository.flush();
	}

	@Override
	public Page<Bill> findAll(Pageable pageable) {
		return billRepository.findAll(pageable);
	}

	@Override
	public <S extends Bill> S saveAndFlush(S entity) {
		return billRepository.saveAndFlush(entity);
	}

	@Override
	public <S extends Bill> List<S> saveAllAndFlush(Iterable<S> entities) {
		return billRepository.saveAllAndFlush(entities);
	}

	@Override
	public List<Bill> findAll() {
		return billRepository.findAll();
	}

	@Override
	public List<Bill> findAllById(Iterable<Integer> ids) {
		return billRepository.findAllById(ids);
	}

	@Override
	public void deleteInBatch(Iterable<Bill> entities) {
		billRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Bill> Page<S> findAll(Example<S> example, Pageable pageable) {
		return billRepository.findAll(example, pageable);
	}

	@Override
	public Optional<Bill> findById(Integer id) {
		return billRepository.findById(id);
	}

	@Override
	public void deleteAllInBatch(Iterable<Bill> entities) {
		billRepository.deleteAllInBatch(entities);
	}

	@Override
	public boolean existsById(Integer id) {
		return billRepository.existsById(id);
	}

	@Override
	public <S extends Bill> long count(Example<S> example) {
		return billRepository.count(example);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		billRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends Bill> boolean exists(Example<S> example) {
		return billRepository.exists(example);
	}

	@Override
	public void deleteAllInBatch() {
		billRepository.deleteAllInBatch();
	}

	@Override
	public Bill getOne(Integer id) {
		return billRepository.getOne(id);
	}

	@Override
	public <S extends Bill, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return billRepository.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return billRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		billRepository.deleteById(id);
	}

	@Override
	public Bill getById(Integer id) {
		return billRepository.getById(id);
	}

	@Override
	public void delete(Bill entity) {
		billRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		billRepository.deleteAllById(ids);
	}

	@Override
	public Bill getReferenceById(Integer id) {
		return billRepository.getReferenceById(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Bill> entities) {
		billRepository.deleteAll(entities);
	}

	@Override
	public <S extends Bill> List<S> findAll(Example<S> example) {
		return billRepository.findAll(example);
	}

	@Override
	public <S extends Bill> List<S> findAll(Example<S> example, Sort sort) {
		return billRepository.findAll(example, sort);
	}

	@Override
	public void deleteAll() {
		billRepository.deleteAll();
	}
	
}
