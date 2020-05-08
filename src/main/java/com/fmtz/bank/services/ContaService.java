package com.fmtz.bank.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.fmtz.bank.entities.Conta;
import com.fmtz.bank.repositories.ContaRepository;

public class ContaService {
	
	@Autowired
	private ContaRepository repository;
	
	
	public List <Conta> findAll(){
		/**long id, int numero da conta, Client cliente, double conta.getSaldo(), double limitesaque*/
//		Conta c1 = new Conta(null, 1234, 1000.0, 200.0);
//		Conta c2 = new Conta(null, 2345, 500.0, 200.0);
//		Conta c3 = new Conta(null, 3456, 100.0, 200.0);
		
//		repository.saveAll(Arrays.asList(c1, c2, c3));
		return repository.findAll();
	}
	
	public Conta findById(Long id) {
		Optional<Conta> obj = repository.findById(id);
		return obj.get();
	}
	
	public Conta insert(Conta obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Conta update(Long id, Conta obj) {
		Conta entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
		
	}

	private void updateData(Conta entity, Conta obj) {
	}
	

}
