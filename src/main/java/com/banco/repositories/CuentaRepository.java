package com.banco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banco.modelos.Banco;
import com.banco.modelos.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Long>{

}
