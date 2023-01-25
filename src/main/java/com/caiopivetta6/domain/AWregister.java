package com.caiopivetta6.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

public class AWregister implements Serializable{

	
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Instant deliveryDate;
	private Instant carleftDate;
	private String problem;
	private Double price;
	
	private List<Client> clients;
	
	
	public AWregister() {
		
	}


	public AWregister(Integer id, Instant deliveryDate, Instant carleftDate, String problem, Double price) {
		super();
		this.id = id;
		this.deliveryDate = deliveryDate;
		this.carleftDate = carleftDate;
		this.problem = problem;
		this.price = price;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Instant getDeliveryDate() {
		return deliveryDate;
	}


	public void setDeliveryDate(Instant deliveryDate) {
		this.deliveryDate = deliveryDate;
	}


	public Instant getCarleftDate() {
		return carleftDate;
	}


	public void setCarleftDate(Instant carleftDate) {
		this.carleftDate = carleftDate;
	}


	public String getProblem() {
		return problem;
	}


	public void setProblem(String problem) {
		this.problem = problem;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public List<Client> getClients() {
		return clients;
	}


	public void setClients(List<Client> clients) {
		this.clients = clients;
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
		AWregister other = (AWregister) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
