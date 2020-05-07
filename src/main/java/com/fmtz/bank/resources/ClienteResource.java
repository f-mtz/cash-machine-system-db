package com.fmtz.bank.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmtz.bank.entities.Cliente;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	
	@GetMapping
	public ResponseEntity<Cliente> findAll(){
	
		Cliente cliente = new Cliente(null, "Julius", "julius@gmail.com");
		return ResponseEntity.ok().body(cliente);
	}
	
	

}
