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

import com.poly.model.Role;
import com.poly.repository.RoleRepository;
import com.poly.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository repository;

	@Override
	public <S extends Role> S save(S entity) {
		return repository.save(entity);
	}

	@Override
	public <S extends Role> List<S> saveAll(Iterable<S> entities) {
		return repository.saveAll(entities);
	}

	@Override
	public <S extends Role> Optional<S> findOne(Example<S> example) {
		return repository.findOne(example);
	}

	@Override
	public List<Role> findAll(Sort sort) {
		return repository.findAll(sort);
	}

	@Override
	public void flush() {
		repository.flush();
	}

	@Override
	public Page<Role> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public <S extends Role> S saveAndFlush(S entity) {
		return repository.saveAndFlush(entity);
	}

	@Override
	public <S extends Role> List<S> saveAllAndFlush(Iterable<S> entities) {
		return repository.saveAllAndFlush(entities);
	}

	@Override
	public List<Role> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Role> findAllById(Iterable<Integer> ids) {
		return repository.findAllById(ids);
	}

	@Override
	public void deleteInBatch(Iterable<Role> entities) {
		repository.deleteInBatch(entities);
	}

	@Override
	public <S extends Role> Page<S> findAll(Example<S> example, Pageable pageable) {
		return repository.findAll(example, pageable);
	}

	@Override
	public Optional<Role> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public void deleteAllInBatch(Iterable<Role> entities) {
		repository.deleteAllInBatch(entities);
	}

	@Override
	public boolean existsById(Integer id) {
		return repository.existsById(id);
	}

	@Override
	public <S extends Role> long count(Example<S> example) {
		return repository.count(example);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		repository.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends Role> boolean exists(Example<S> example) {
		return repository.exists(example);
	}

	@Override
	public void deleteAllInBatch() {
		repository.deleteAllInBatch();
	}

	@Override
	public Role getOne(Integer id) {
		return repository.getOne(id);
	}

	@Override
	public <S extends Role, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return repository.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return repository.count();
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public Role getById(Integer id) {
		return repository.getById(id);
	}

	@Override
	public void delete(Role entity) {
		repository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		repository.deleteAllById(ids);
	}

	@Override
	public Role getReferenceById(Integer id) {
		return repository.getReferenceById(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Role> entities) {
		repository.deleteAll(entities);
	}

	@Override
	public <S extends Role> List<S> findAll(Example<S> example) {
		return repository.findAll(example);
	}

	@Override
	public <S extends Role> List<S> findAll(Example<S> example, Sort sort) {
		return repository.findAll(example, sort);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

}
