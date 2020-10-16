package com.banco.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.modelos.Banco;
import com.banco.repositories.BancoRepository;

import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;


@Service
public class BancoService implements BaseService<Banco>{
	@Autowired
	private BancoRepository bancoRepository;

	
	@Override
	@Transactional
	public Observable<List<Banco>> findAll() throws Exception {
		return Observable.just(bancoRepository.findAll());
	}

	@Override
	@Transactional
	public Observable<Optional<Banco>> findById(Long id) throws Exception {	
		
		return  Observable.just(bancoRepository.findById(id));
				

	}

	@Override
	@Transactional
	public Banco save(Banco entity) throws Exception {
		entity = bancoRepository.save(entity);
		return entity;

	}

	@Override
	@Transactional
	public Banco update(Long id, Banco entity) throws Exception {
		Optional<Banco> entityOptional = bancoRepository.findById(id);
		
		Banco banco = entityOptional.get();
		banco = bancoRepository.save(entity);

		return banco;
	}

	@Override
	@Transactional
	public boolean delete(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional
	public Observable<Banco> findByCodigo(Integer codigo) throws Exception {
		return Observable.just(bancoRepository.findAll())
				.flatMapIterable(banco -> banco)
				.filter(banco-> banco.getCodigoBanco().equals(codigo))
				.doOnSubscribe(log -> System.out.println("Encontrado"))
				.doOnError(error -> System.out.println("Error. No encontrado"));
	}

	@Override
	@Transactional
	public Observable<Banco> findByNombre(String nombre) throws Exception {
		return Observable.just(bancoRepository.findAll())
				.flatMapIterable(banco -> banco)
				.filter(banco-> banco.getNombreBanco().equals(nombre))
				.doOnSubscribe(log -> System.out.println("Encontrado"))
				.doOnError(error -> System.out.println("Error. No encontrado"));
	}


	
}
