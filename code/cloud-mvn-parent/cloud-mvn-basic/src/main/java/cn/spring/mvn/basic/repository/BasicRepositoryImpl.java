package cn.spring.mvn.basic.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

public class BasicRepositoryImpl<T, PK extends Serializable> implements
		BasicRepository<T, PK> {

	@Autowired
	private BasicRepository<T, Serializable> basicRepositoryImpl;

	// 从Repository中继承来的
	@Override
	public void deleteAllInBatch() {
		basicRepositoryImpl.deleteAllInBatch();
	}

	@Override
	public void deleteInBatch(Iterable<T> arg0) {
		basicRepositoryImpl.deleteInBatch(arg0);
	}

	@Override
	public List<T> findAll() {
		return basicRepositoryImpl.findAll();
	}

	@Override
	public List<T> findAll(Sort arg0) {
		return basicRepositoryImpl.findAll(arg0);
	}

	@Override
	public T getOne(Serializable arg0) {
		return basicRepositoryImpl.getOne(arg0);
	}

	@Override
	public <S extends T> S saveAndFlush(S arg0) {
		return basicRepositoryImpl.saveAndFlush(arg0);
	}

	@Override
	public Page<T> findAll(Pageable arg0) {
		return basicRepositoryImpl.findAll(arg0);
	}

	@Override
	public void deleteAll() {
		basicRepositoryImpl.deleteAll();
	}

	@Override
	public long count(Specification<T> arg0) {
		return basicRepositoryImpl.count(arg0);
	}

	@Override
	public List<T> findAll(Specification<T> arg0) {
		return basicRepositoryImpl.findAll(arg0);
	}

	@Override
	public Page<T> findAll(Specification<T> arg0, Pageable arg1) {
		return basicRepositoryImpl.findAll(arg0, arg1);
	}

	@Override
	public List<T> findAll(Specification<T> arg0, Sort arg1) {
		return basicRepositoryImpl.findAll(arg0, arg1);
	}

	@Override
	public <S extends T> S save(S arg0) {
		return basicRepositoryImpl.save(arg0);
	}

	@Override
	public void flush() {
		basicRepositoryImpl.flush();

	}

	@Override
	public long count() {
		return basicRepositoryImpl.count();
	}

	@Override
	public void delete(T entity) {
		basicRepositoryImpl.delete(entity);
	}

	@Override
	public List<T> findAllById(Iterable<PK> ids) {
		return null;
	}

	@Override
	public <S extends T> List<S> saveAll(Iterable<S> entities) {
		return basicRepositoryImpl.saveAll(entities);
	}

	@Override
	public <S extends T> List<S> findAll(Example<S> example) {
		return basicRepositoryImpl.findAll(example);
	}

	@Override
	public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
		return basicRepositoryImpl.findAll(example, sort);
	}

	@Override
	public void deleteAll(Iterable<? extends T> arg0) {
		basicRepositoryImpl.deleteAll(arg0);
	}

	@Override
	public void deleteById(PK arg0) {
		basicRepositoryImpl.deleteById(arg0);
	}

	@Override
	public boolean existsById(PK arg0) {
		return basicRepositoryImpl.existsById(arg0);
	}

	@Override
	public Optional<T> findById(PK arg0) {
		return basicRepositoryImpl.findById(arg0);
	}

	@Override
	public <S extends T> long count(Example<S> arg0) {
		return basicRepositoryImpl.count(arg0);
	}

	@Override
	public <S extends T> boolean exists(Example<S> arg0) {
		return basicRepositoryImpl.exists(arg0);
	}

	@Override
	public <S extends T> Page<S> findAll(Example<S> arg0, Pageable arg1) {
		return basicRepositoryImpl.findAll(arg0, arg1);
	}

	@Override
	public <S extends T> Optional<S> findOne(Example<S> arg0) {
		return basicRepositoryImpl.findOne(arg0);
	}

	@Override
	public Optional<T> findOne(Specification<T> spec) {
		return basicRepositoryImpl.findOne(spec);
	}
}
