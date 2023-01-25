package com.caiopivetta6.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.caiopivetta6.domain.Client;
import com.caiopivetta6.repositories.ClientRepository;
import com.caiopivetta6.services.exception.DatabaseException;
import com.caiopivetta6.services.exception.ObjectNotFoundException;
import com.caiopivetta6.services.exception.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	public Client find(Integer id) {
		
		Optional<Client> obj = repository.findById(id);
		
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Tipo: " + Client.class.getName()));

	}
	
	public Client insert(Client obj) {
		repository.save(obj);
		return obj;
	}
	
	
	public void delete(Integer id) {
		try {
		repository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Client update(Integer id, Client obj) {
		try {
		Client entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}
	
	private void updateData(Client entity, Client obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
	
}
