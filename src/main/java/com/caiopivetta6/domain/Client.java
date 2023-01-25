package com.caiopivetta6.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.caiopivetta6.domain.enums.CarType;

public class Client implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String email;
	private CarType carType;
	
	private List<String> phone;
	
	
	public Client() {
		
	}


	public Client(Integer id, String name, String email, CarType carType) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.carType = carType;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public CarType getCarType() {
		return carType;
	}


	public void setCarType(CarType carType) {
		this.carType = carType;
	}


	public List<String> getPhone() {
		return phone;
	}


	public void setPhone(List<String> phone) {
		this.phone = phone;
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
		Client other = (Client) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
}
