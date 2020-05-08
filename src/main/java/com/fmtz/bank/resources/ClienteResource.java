package com.fmtz.bank.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmtz.bank.entities.Cliente;
import com.fmtz.bank.repositories.ClienteRepository;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@GetMapping("/clientes")
	public List<Cliente> listaCliente(){
		return clienteRepository.findAll();
	}
	
	@GetMapping("/cliente/{id}")
	public Optional<Cliente> clientUnico(@PathVariable(value="id") long id){
		return clienteRepository.findById(id);
	}
	
	@PostMapping("/cliente")
	public Cliente salvaContato(@RequestBody Cliente client) {
		return clienteRepository.save(client);
	}
	
	@DeleteMapping("/cliente")
	public void deletaContato(@RequestBody Cliente client) {
		clienteRepository.delete(client);
	}
	
	@PutMapping("/cliente")
	public Cliente atualizaContato(@RequestBody Cliente client) {
		return clienteRepository.save(client);
	}

}
