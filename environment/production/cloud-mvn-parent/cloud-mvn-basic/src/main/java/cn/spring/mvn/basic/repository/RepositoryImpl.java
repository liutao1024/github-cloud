package cn.spring.mvn.basic.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

public class RepositoryImpl<T, PK extends Serializable> implements Repository<T, PK> {

	@Autowired
	private Repository<T, Serializable> repositoryImpl;

	// 从Repository中继承来的
	@Override
	public void deleteAllInBatch() {
		repositoryImpl.deleteAllInBatch();
	}

	@Override
	public void deleteInBatch(Iterable<T> arg0) {
		repositoryImpl.deleteInBatch(arg0);
	}

	@Override
	public List<T> findAll() {
		return repositoryImpl.findAll();
	}

	@Override
	public List<T> findAll(Sort arg0) {
		return repositoryImpl.findAll(arg0);
	}

	@Override
	public T getOne(Serializable arg0) {
		return repositoryImpl.getOne(arg0);
	}

	@Override
	public <S extends T> S saveAndFlush(S arg0) {
		return repositoryImpl.saveAndFlush(arg0);
	}

	@Override
	public Page<T> findAll(Pageable arg0) {
		return repositoryImpl.findAll(arg0);
	}

	@Override
	public void deleteAll() {
		repositoryImpl.deleteAll();
	}

	@Override
	public long count(Specification<T> arg0) {
		return repositoryImpl.count(arg0);
	}

	@Override
	public List<T> findAll(Specification<T> arg0) {
		return repositoryImpl.findAll(arg0);
	}

	@Override
	public Page<T> findAll(Specification<T> arg0, Pageable arg1) {
		return repositoryImpl.findAll(arg0, arg1);
	}

	@Override
	public List<T> findAll(Specification<T> arg0, Sort arg1) {
		return repositoryImpl.findAll(arg0, arg1);
	}

	@Override
	public <S extends T> S save(S arg0) {
		return repositoryImpl.save(arg0);
	}

	@Override
	public void flush() {
		repositoryImpl.flush();

	}

	@Override
	public long count() {
		return repositoryImpl.count();
	}

	@Override
	public void delete(T entity) {
		repositoryImpl.delete(entity);
	}

	@Override
	public <S extends T> List<S> findAll(Example<S> example) {
		return repositoryImpl.findAll(example);
	}

	@Override
	public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
		return repositoryImpl.findAll(example, sort);
	}

	@Override
	public <S extends T> long count(Example<S> arg0) {
		return repositoryImpl.count(arg0);
	}

	@Override
	public <S extends T> boolean exists(Example<S> arg0) {
		return repositoryImpl.exists(arg0);
	}

	@Override
	public <S extends T> Page<S> findAll(Example<S> arg0, Pageable arg1) {
		return repositoryImpl.findAll(arg0, arg1);
	}

	@Override
	public List<T> findAll(Iterable<PK> ids) {
		// TODO Auto-generated method stub
		return repositoryImpl.findAll();
	}

	@Override
	public <S extends T> List<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return repositoryImpl.save(entities);
	}

	@Override
	public void delete(PK arg0) {
		// TODO Auto-generated method stub
		repositoryImpl.delete(arg0);
	}

	@Override
	public void delete(Iterable<? extends T> arg0) {
		// TODO Auto-generated method stub
		repositoryImpl.delete(arg0);
	}

	@Override
	public boolean exists(PK arg0) {
		// TODO Auto-generated method stub
		return repositoryImpl.exists(arg0);
	}

	@Override
	public T findOne(PK arg0) {
		// TODO Auto-generated method stub
		return repositoryImpl.findOne(arg0);
	}

	@Override
	public <S extends T> S findOne(Example<S> arg0) {
		// TODO Auto-generated method stub
		return repositoryImpl.findOne(arg0);
	}

	@Override
	public T findOne(Specification<T> spec) {
		// TODO Auto-generated method stub
		return repositoryImpl.findOne(spec);
	}
}
