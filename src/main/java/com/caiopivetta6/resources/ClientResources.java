package com.caiopivetta6.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caiopivetta6.domain.Client;
import com.caiopivetta6.services.ClientService;

@RestController
@RequestMapping(value = "/client")
public class ClientResources {
	
	@Autowired
	private ClientService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Client> findById (@PathVariable Integer id) {
		
		Client obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
}


