package com.fmtz.bank.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmtz.bank.entities.Conta;
import com.fmtz.bank.repositories.ContaRepository;

@RestController
@RequestMapping(value = "/contas")
public class ContaResource {
	
	@Autowired
	private ContaRepository service;
	
	@GetMapping //
	public ResponseEntity<List<Conta>> findall(){ //resposta da entidade usuário, encontre todos
		List<Conta> list = service.findAll();
		return ResponseEntity.ok().body(list); //resposta da entidade 
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Conta>> findById(@PathVariable Long id){

		Optional<Conta> obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}

}
