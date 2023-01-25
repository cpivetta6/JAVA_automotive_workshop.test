package com.caiopivetta6.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caiopivetta6.domain.AWregister;
import com.caiopivetta6.services.AWregisterService;

@RestController
@RequestMapping(value = "/autoregister")
public class AWregisterResource {
	
	@Autowired
	private AWregisterService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AWregister> findById (@PathVariable Integer id) {
		
		AWregister obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
}


