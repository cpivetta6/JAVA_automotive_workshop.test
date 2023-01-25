package com.caiopivetta6.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caiopivetta6.domain.AWregister;
import com.caiopivetta6.repositories.AWregisterRepository;
import com.caiopivetta6.services.exception.ObjectNotFoundException;

@Service
public class AWregisterService {
	
	@Autowired
	private AWregisterRepository repository;
	
	public AWregister find(Integer id) {
		
		Optional<AWregister> obj = repository.findById(id);
		
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Tipo: " + AWregister.class.getName()));

	}
}
