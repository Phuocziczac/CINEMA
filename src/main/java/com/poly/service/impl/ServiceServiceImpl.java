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

import com.poly.repository.ServiceRepository;
import com.poly.service.ServiceService;

@Service
public class ServiceServiceImpl implements ServiceService {
	@Autowired
	private ServiceRepository serviceRepository;

	@Override
	public <S extends com.poly.model.Service> S save(S entity) {
		return serviceRepository.save(entity);
	}

	@Override
	public <S extends com.poly.model.Service> List<S> saveAll(Iterable<S> entities) {
		return serviceRepository.saveAll(entities);
	}

	@Override
	public <S extends com.poly.model.Service> Optional<S> findOne(Example<S> example) {
		return serviceRepository.findOne(example);
	}

	@Override
	public List<com.poly.model.Service> findAll(Sort sort) {
		return serviceRepository.findAll(sort);
	}

	@Override
	public void flush() {
		serviceRepository.flush();
	}

	@Override
	public Page<com.poly.model.Service> findAll(Pageable pageable) {
		return serviceRepository.findAll(pageable);
	}

	@Override
	public <S extends com.poly.model.Service> S saveAndFlush(S entity) {
		return serviceRepository.saveAndFlush(entity);
	}

	@Override
	public <S extends com.poly.model.Service> List<S> saveAllAndFlush(Iterable<S> entities) {
		return serviceRepository.saveAllAndFlush(entities);
	}

	@Override
	public List<com.poly.model.Service> findAll() {
		return serviceRepository.findAll();
	}

	@Override
	public List<com.poly.model.Service> findAllById(Iterable<Integer> ids) {
		return serviceRepository.findAllById(ids);
	}

	@Override
	public void deleteInBatch(Iterable<com.poly.model.Service> entities) {
		serviceRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends com.poly.model.Service> Page<S> findAll(Example<S> example, Pageable pageable) {
		return serviceRepository.findAll(example, pageable);
	}

	@Override
	public Optional<com.poly.model.Service> findById(Integer id) {
		return serviceRepository.findById(id);
	}

	@Override
	public void deleteAllInBatch(Iterable<com.poly.model.Service> entities) {
		serviceRepository.deleteAllInBatch(entities);
	}

	@Override
	public boolean existsById(Integer id) {
		return serviceRepository.existsById(id);
	}

	@Override
	public <S extends com.poly.model.Service> long count(Example<S> example) {
		return serviceRepository.count(example);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		serviceRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends com.poly.model.Service> boolean exists(Example<S> example) {
		return serviceRepository.exists(example);
	}

	@Override
	public void deleteAllInBatch() {
		serviceRepository.deleteAllInBatch();
	}

	@Override
	public com.poly.model.Service getOne(Integer id) {
		return serviceRepository.getOne(id);
	}

	@Override
	public <S extends com.poly.model.Service, R> R findBy(Example<S> example,
			Function<FetchableFluentQuery<S>, R> queryFunction) {
		return serviceRepository.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return serviceRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		serviceRepository.deleteById(id);
	}

	@Override
	public com.poly.model.Service getById(Integer id) {
		return serviceRepository.getById(id);
	}

	@Override
	public void delete(com.poly.model.Service entity) {
		serviceRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		serviceRepository.deleteAllById(ids);
	}

	@Override
	public com.poly.model.Service getReferenceById(Integer id) {
		return serviceRepository.getReferenceById(id);
	}

	@Override
	public void deleteAll(Iterable<? extends com.poly.model.Service> entities) {
		serviceRepository.deleteAll(entities);
	}

	@Override
	public <S extends com.poly.model.Service> List<S> findAll(Example<S> example) {
		return serviceRepository.findAll(example);
	}

	@Override
	public <S extends com.poly.model.Service> List<S> findAll(Example<S> example, Sort sort) {
		return serviceRepository.findAll(example, sort);
	}

	@Override
	public void deleteAll() {
		serviceRepository.deleteAll();
	}
	@Override
	public List<com.poly.model.Service> searchByKeyword(String keyword) {
		// TODO Auto-generated method stub
		// throw new UnsupportedOperationException("Unimplemented method 'searchByKeyword'");
		return serviceRepository.findByNameContainingIgnoreCase(keyword);
	}

	@Override
	public Page<com.poly.model.Service> findByRoleIdIn(List<Integer> roleIds, Pageable pageable) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findByRoleIdIn'");
	}

	@Override
	public List<com.poly.model.Service> searchByKeywordCustomer(String keyword) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'searchByKeywordCustomer'");
	}

	
}
