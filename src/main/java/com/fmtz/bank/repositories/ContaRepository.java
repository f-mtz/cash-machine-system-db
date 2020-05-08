package com.fmtz.bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fmtz.bank.entities.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long>{

}
