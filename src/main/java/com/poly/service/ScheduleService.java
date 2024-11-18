package com.poly.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.poly.model.Schedule;

public interface ScheduleService {

    void deleteAll();

    <S extends Schedule> List<S> findAll(Example<S> example, Sort sort);

    <S extends Schedule> List<S> findAll(Example<S> example);

    void deleteAll(Iterable<? extends Schedule> entities);

    Schedule getReferenceById(Integer id);

    void deleteAllById(Iterable<? extends Integer> ids);

    void delete(Schedule entity);

    Schedule getById(Integer id);

    void deleteById(Integer id);

    long count();

    <S extends Schedule, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

    Schedule getOne(Integer id);

    void deleteAllInBatch();

    <S extends Schedule> boolean exists(Example<S> example);

    void deleteAllByIdInBatch(Iterable<Integer> ids);

    <S extends Schedule> long count(Example<S> example);

    boolean existsById(Integer id);

    void deleteAllInBatch(Iterable<Schedule> entities);

    Optional<Schedule> findById(Integer id);

    <S extends Schedule> Page<S> findAll(Example<S> example, Pageable pageable);

    void deleteInBatch(Iterable<Schedule> entities);

    List<Schedule> findAllById(Iterable<Integer> ids);

    List<Schedule> findAll();

    <S extends Schedule> List<S> saveAllAndFlush(Iterable<S> entities);

    <S extends Schedule> S saveAndFlush(S entity);

    Page<Schedule> findAll(Pageable pageable);

    void flush();

    List<Schedule> findAll(Sort sort);

    <S extends Schedule> Optional<S> findOne(Example<S> example);

    <S extends Schedule> List<S> saveAll(Iterable<S> entities);

    <S extends Schedule> S save(S entity);

    List<Schedule> findByMovieId(int movieId);

    List<LocalDate> findDistinctScreeningDates(int movieId);

    List<Schedule> findByScreeningDateAndMovieId(LocalDate screeningDate, int movieId);

    List<Object[]> findShowtimesByDateAndMovie(LocalDate screeningDate, int movieId);
    
}
