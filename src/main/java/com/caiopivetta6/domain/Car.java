package com.caiopivetta6.domain;

import java.io.Serializable;
import java.util.Objects;

import com.caiopivetta6.domain.enums.CarType;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Car")
public class Car implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Integer car_year;
	private CarType carType;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	public Car() {
		
	}

	public Car(Integer id, String name, Integer car_year ,CarType carType) {
		super();
		this.id = id;
		this.name = name;
		this.car_year = car_year;
		this.carType = carType;
	}
	
	
	

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Integer getCar_year() {
		return car_year;
	}

	public void setCar_year(Integer car_year) {
		this.car_year = car_year;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CarType getCarType() {
		return carType;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
