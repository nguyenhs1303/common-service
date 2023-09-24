package com.mbal.saleportal.spring_template.repository.impl;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class RepositoryImpl<T, ID> implements JpaRepository<T, ID> {
    private JpaRepository secondaryRepository;
    private JpaRepository primaryRepository;


    public RepositoryImpl(JpaRepository secondaryRepository, JpaRepository primaryRepository) {
        this.secondaryRepository = secondaryRepository;
        this.primaryRepository = primaryRepository;
    }

    public RepositoryImpl(JpaRepository secondaryRepository) {
        this.secondaryRepository = secondaryRepository;
    }

    // Replication (Read)
    @Override
    public Optional<T> findById(ID id) {
        return this.secondaryRepository.findById(id);
    }

    @Override
    public boolean existsById(ID id) {
        return this.secondaryRepository.existsById(id);
    }

    @Override
    public T getOne(ID id) {
        return (T) this.secondaryRepository.getById(id);
    }

    @Override
    public T getById(ID id) {
        return (T) this.secondaryRepository.getById(id);
    }


    @Override
    public List<T> findAll() {
        return this.secondaryRepository.findAll();
    }

    @Override
    public List<T> findAll(Sort sort) {
        return this.secondaryRepository.findAll(sort);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return this.secondaryRepository.findAll(pageable);
    }

    @Override
    public List<T> findAllById(Iterable<ID> id) {
        return this.secondaryRepository.findAllById(id);
    }

    @Override
    public long count() {
        return this.secondaryRepository.count();
    }

    // Primary (Write)
    @Override
    public <S extends T> S save(S s) {
        return (S) this.primaryRepository.save(s);
    }

    @Override
    public <S extends T> List<S> saveAll(Iterable<S> s) {
        return this.primaryRepository.saveAll(s);
    }

    @Override
    public void flush() {
//
    }

    @Override
    public <S extends T> S saveAndFlush(S s) {
        return (S) this.primaryRepository.saveAndFlush(s);
    }

    @Override
    public <S extends T> List<S> saveAllAndFlush(Iterable<S> s) {
        return this.primaryRepository.saveAllAndFlush(s);
    }

    @Override
    public void delete(T t) {
        this.primaryRepository.delete(t);
    }

    @Override
    public void deleteById(ID id) {
        this.primaryRepository.deleteById(id);
    }

    public void deleteAllById(Iterable<? extends ID> id) {
        this.primaryRepository.deleteAllById(id);
    }

    public void deleteAll(Iterable<? extends T> t) {
        this.primaryRepository.deleteAllById(t);
    }

    public void deleteAll() {
        this.primaryRepository.deleteAll();
    }

    @Override
    public void deleteAllInBatch(Iterable<T> t) {
        this.primaryRepository.deleteAllInBatch(t);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<ID> id) {
        this.primaryRepository.deleteAllByIdInBatch(id);
    }

    @Override
    public void deleteAllInBatch() {
        this.primaryRepository.deleteAllInBatch();
    }

    // Demo from Base
    @Override
    public <S extends T> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> example) {
        return secondaryRepository.findAll(example);
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
        return Collections.emptyList();
    }

    @Override
    public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends T> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends T> boolean exists(Example<S> example) {
        return false;
    }
}
