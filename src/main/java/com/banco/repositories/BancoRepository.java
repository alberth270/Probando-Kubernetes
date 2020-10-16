package com.banco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banco.modelos.Banco;

@Repository
public interface BancoRepository extends JpaRepository<Banco, Long> {

}
