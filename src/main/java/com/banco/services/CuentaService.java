package com.banco.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.modelos.Cuenta;
import com.banco.repositories.CuentaRepository;
import io.reactivex.Observable;
@Service
public class CuentaService implements BaseService<Cuenta> {
	@Autowired
	private CuentaRepository cuentaRepository;

	@Override
	@Transactional
	public Observable<List<Cuenta>> findAll() throws Exception {
		return Observable.just(cuentaRepository.findAll());
	}

	@Override
	@Transactional
	public Observable<Cuenta> findByCodigo(Integer codigo) throws Exception {
		return Observable.just(cuentaRepository.findAll())
				.flatMapIterable(cuenta -> cuenta)
				.filter(cuenta-> cuenta.getCodigoCuenta().equals(codigo))
				.doOnSubscribe(log -> System.out.println("Encontrado"))
				.doOnError(error -> System.out.println("Error. No encontrado"));
	}

	@Override
	@Transactional
	public Observable<Cuenta> findByNombre(String nombre) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Observable<Optional<Cuenta>> findById(Long id) throws Exception {
		return  Observable.just(cuentaRepository.findById(id));
	}

	@Override
	@Transactional
	public Cuenta save(Cuenta entity) throws Exception {
		entity = cuentaRepository.save(entity);
		return entity;
	}

	@Override
	@Transactional
	public Cuenta update(Long id, Cuenta entity) throws Exception {
			Optional<Cuenta> entityOptional = cuentaRepository.findById(id);
		
			Cuenta cuentaepository = entityOptional.get();
			cuentaRepository = (CuentaRepository) cuentaRepository.save(entity);

		return cuentaepository;
	}

	@Override
	public boolean delete(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	
}
