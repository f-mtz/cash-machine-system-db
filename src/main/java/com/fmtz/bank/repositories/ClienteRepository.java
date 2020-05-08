package com.fmtz.bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fmtz.bank.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
