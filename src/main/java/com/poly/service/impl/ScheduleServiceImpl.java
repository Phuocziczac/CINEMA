package com.poly.service.impl;

import java.time.LocalDate;
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

import com.poly.model.Schedule;
import com.poly.repository.ScheduleRepository;
import com.poly.service.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public <S extends Schedule> S save(S entity) {
        return scheduleRepository.save(entity);
    }

    @Override
    public <S extends Schedule> List<S> saveAll(Iterable<S> entities) {
        return scheduleRepository.saveAll(entities);
    }

    @Override
    public <S extends Schedule> Optional<S> findOne(Example<S> example) {
        return scheduleRepository.findOne(example);
    }

    @Override
    public List<Schedule> findAll(Sort sort) {
        return scheduleRepository.findAll(sort);
    }

    @Override
    public void flush() {
        scheduleRepository.flush();
    }

    @Override
    public Page<Schedule> findAll(Pageable pageable) {
        return scheduleRepository.findAll(pageable);
    }

    @Override
    public <S extends Schedule> S saveAndFlush(S entity) {
        return scheduleRepository.saveAndFlush(entity);
    }

    @Override
    public <S extends Schedule> List<S> saveAllAndFlush(Iterable<S> entities) {
        return scheduleRepository.saveAllAndFlush(entities);
    }

    @Override
    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    @Override
    public List<Schedule> findAllById(Iterable<Integer> ids) {
        return scheduleRepository.findAllById(ids);
    }

    @Override
    public void deleteInBatch(Iterable<Schedule> entities) {
        scheduleRepository.deleteInBatch(entities);
    }

    @Override
    public <S extends Schedule> Page<S> findAll(Example<S> example, Pageable pageable) {
        return scheduleRepository.findAll(example, pageable);
    }

    @Override
    public Optional<Schedule> findById(Integer id) {
        return scheduleRepository.findById(id);
    }

    @Override
    public void deleteAllInBatch(Iterable<Schedule> entities) {
        scheduleRepository.deleteAllInBatch(entities);
    }

    @Override
    public boolean existsById(Integer id) {
        return scheduleRepository.existsById(id);
    }

    @Override
    public <S extends Schedule> long count(Example<S> example) {
        return scheduleRepository.count(example);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> ids) {
        scheduleRepository.deleteAllByIdInBatch(ids);
    }

    @Override
    public <S extends Schedule> boolean exists(Example<S> example) {
        return scheduleRepository.exists(example);
    }

    @Override
    public void deleteAllInBatch() {
        scheduleRepository.deleteAllInBatch();
    }

    @Override
    public Schedule getOne(Integer id) {
        return scheduleRepository.getOne(id);
    }

    @Override
    public <S extends Schedule, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
        return scheduleRepository.findBy(example, queryFunction);
    }

    @Override
    public long count() {
        return scheduleRepository.count();
    }

    @Override
    public void deleteById(Integer id) {
        scheduleRepository.deleteById(id);
    }

    @Override
    public Schedule getById(Integer id) {
        return scheduleRepository.getById(id);
    }

    @Override
    public void delete(Schedule entity) {
        scheduleRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> ids) {
        scheduleRepository.deleteAllById(ids);
    }

    @Override
    public Schedule getReferenceById(Integer id) {
        return scheduleRepository.getReferenceById(id);
    }

    @Override
    public void deleteAll(Iterable<? extends Schedule> entities) {
        scheduleRepository.deleteAll(entities);
    }

    @Override
    public <S extends Schedule> List<S> findAll(Example<S> example) {
        return scheduleRepository.findAll(example);
    }

    @Override
    public <S extends Schedule> List<S> findAll(Example<S> example, Sort sort) {
        return scheduleRepository.findAll(example, sort);
    }

    @Override
    public void deleteAll() {
        scheduleRepository.deleteAll();
    }

    @Override
    public List<Schedule> findByMovieId(int movieId) {
        return scheduleRepository.findByMovieId(movieId);
    }

    @Override
    public List<LocalDate> findDistinctScreeningDates(int movieId) {
        return scheduleRepository.findDistinctScreeningDates(movieId);
    }

    @Override
    public List<Schedule> findByScreeningDateAndMovieId(LocalDate screeningDate, int movieId) {
        return scheduleRepository.findByScreeningDateAndMovieId(screeningDate, movieId);
    }

    @Override
    public List<Object[]> findShowtimesByDateAndMovie(LocalDate screeningDate, int movieId) {
        return scheduleRepository.findShowtimesByDateAndMovie(screeningDate, movieId);
    }
    
}
