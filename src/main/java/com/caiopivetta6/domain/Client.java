package com.caiopivetta6.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.caiopivetta6.domain.enums.CarType;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Client_tb")
public class Client implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String email;
	private CarType carType;
	
	@ManyToOne
	private AWregister aWregister;
	
	@Embedded
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

	
	

	public AWregister getaWregister() {
		return aWregister;
	}


	public void setaWregister(AWregister aWregister) {
		this.aWregister = aWregister;
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
