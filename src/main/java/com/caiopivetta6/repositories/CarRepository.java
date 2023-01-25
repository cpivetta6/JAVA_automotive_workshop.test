package com.caiopivetta6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caiopivetta6.domain.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {

	
	
}
