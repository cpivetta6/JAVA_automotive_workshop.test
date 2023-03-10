package com.caiopivetta6.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
	
	@JsonManagedReference
	@OneToMany(mappedBy = "client")
	private List<Car> cars = new ArrayList<>();
	
	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;
	
	@JsonBackReference
	@ManyToOne
	private AWregister aWregister;
	
	@ElementCollection
	@CollectionTable(name = "phone")
	private List<String> phone = new ArrayList<>();
	
	
	public Client() {
		
	}


	public Client(Integer id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		
	}
	
	
	
	

	public List<Car> getCars() {
		return cars;
	}


	public void setCars(List<Car> cars) {
		this.cars = cars;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
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
