package com.poly.service.impl;

import com.poly.model.SeatClass;
import com.poly.repository.SeatClassRepository;
import com.poly.service.SeatClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class SeatClassServiceImpl implements SeatClassService {
    @Autowired
    private SeatClassRepository seatClassRepository;

    @Override
    public List<SeatClass> getAllSeatClasses() {
        return seatClassRepository.findAll();
    }

    @Override
    public Optional<SeatClass> getSeatClassById(int id) {
        return seatClassRepository.findById(id);
    }

    @Override
    public SeatClass saveSeatClass(SeatClass seatClass) {
        return seatClassRepository.save(seatClass);
    }

    @Override
    public void deleteSeatClassById(int id) {
        seatClassRepository.deleteById(id);
    }

	@Override
	public <S extends SeatClass> S save(S entity) {
		return seatClassRepository.save(entity);
	}

	@Override
	public <S extends SeatClass> List<S> saveAll(Iterable<S> entities) {
		return seatClassRepository.saveAll(entities);
	}

	@Override
	public <S extends SeatClass> Optional<S> findOne(Example<S> example) {
		return seatClassRepository.findOne(example);
	}

	@Override
	public List<SeatClass> findAll(Sort sort) {
		return seatClassRepository.findAll(sort);
	}

	@Override
	public void flush() {
		seatClassRepository.flush();
	}

	@Override
	public Page<SeatClass> findAll(Pageable pageable) {
		return seatClassRepository.findAll(pageable);
	}

	@Override
	public <S extends SeatClass> S saveAndFlush(S entity) {
		return seatClassRepository.saveAndFlush(entity);
	}

	@Override
	public <S extends SeatClass> List<S> saveAllAndFlush(Iterable<S> entities) {
		return seatClassRepository.saveAllAndFlush(entities);
	}

	@Override
	public List<SeatClass> findAll() {
		return seatClassRepository.findAll();
	}

	@Override
	public List<SeatClass> findAllById(Iterable<Integer> ids) {
		return seatClassRepository.findAllById(ids);
	}

	@Override
	public void deleteInBatch(Iterable<SeatClass> entities) {
		seatClassRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends SeatClass> Page<S> findAll(Example<S> example, Pageable pageable) {
		return seatClassRepository.findAll(example, pageable);
	}

	@Override
	public Optional<SeatClass> findById(Integer id) {
		return seatClassRepository.findById(id);
	}

	@Override
	public void deleteAllInBatch(Iterable<SeatClass> entities) {
		seatClassRepository.deleteAllInBatch(entities);
	}

	@Override
	public boolean existsById(Integer id) {
		return seatClassRepository.existsById(id);
	}

	@Override
	public <S extends SeatClass> long count(Example<S> example) {
		return seatClassRepository.count(example);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		seatClassRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends SeatClass> boolean exists(Example<S> example) {
		return seatClassRepository.exists(example);
	}

	@Override
	public void deleteAllInBatch() {
		seatClassRepository.deleteAllInBatch();
	}

	@Override
	public SeatClass getOne(Integer id) {
		return seatClassRepository.getOne(id);
	}

	@Override
	public <S extends SeatClass, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return seatClassRepository.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return seatClassRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		seatClassRepository.deleteById(id);
	}

	@Override
	public SeatClass getById(Integer id) {
		return seatClassRepository.getById(id);
	}

	@Override
	public void delete(SeatClass entity) {
		seatClassRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		seatClassRepository.deleteAllById(ids);
	}

	@Override
	public SeatClass getReferenceById(Integer id) {
		return seatClassRepository.getReferenceById(id);
	}

	@Override
	public void deleteAll(Iterable<? extends SeatClass> entities) {
		seatClassRepository.deleteAll(entities);
	}

	@Override
	public <S extends SeatClass> List<S> findAll(Example<S> example) {
		return seatClassRepository.findAll(example);
	}

	@Override
	public <S extends SeatClass> List<S> findAll(Example<S> example, Sort sort) {
		return seatClassRepository.findAll(example, sort);
	}

	@Override
	public void deleteAll() {
		seatClassRepository.deleteAll();
	}
}
