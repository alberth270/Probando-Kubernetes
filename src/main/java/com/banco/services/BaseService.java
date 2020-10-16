package com.banco.services;

import java.util.List;
import java.util.Optional;

import io.reactivex.Observable;



public interface BaseService<E> {
	public Observable<List<E>> findAll() throws Exception;
	public Observable<E> findByCodigo(Integer codigo) throws Exception;
	public Observable<E> findByNombre(String nombre) throws Exception;
	public Observable<Optional<E>> findById(Long id) throws Exception;
	public E save(E entity) throws Exception;
	public E update(Long id, E entity) throws Exception;
	public boolean delete (Long id) throws Exception;

}
