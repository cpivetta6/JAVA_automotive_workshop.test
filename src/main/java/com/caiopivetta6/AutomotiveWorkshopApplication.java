package com.caiopivetta6;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.caiopivetta6.domain.Address;
import com.caiopivetta6.domain.City;
import com.caiopivetta6.domain.State;
import com.caiopivetta6.repositories.AWregisterRepository;
import com.caiopivetta6.repositories.AddressRepository;
import com.caiopivetta6.repositories.CityRepository;
import com.caiopivetta6.repositories.ClientRepository;
import com.caiopivetta6.repositories.StateRepository;

@SpringBootApplication
public class AutomotiveWorkshopApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(AutomotiveWorkshopApplication.class, args);
	}
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private AWregisterRepository aWregisterRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public void run(String... args) throws Exception, ParseException {
		// TODO Auto-generated method stub
		
		SimpleDateFormat sdf = new SimpleDateFormat();
		
		//City State and Address
		
		State state = new State(null, "Veneto");
		City city = new City(null, "Verona", state);
		Address address1 = new Address(null, "Corso porta nuova","78", "Centro", "123412", city);
		
		stateRepository.save(state);
		cityRepository.save(city);
		addressRepository.save(address1);
		
		
	}

}
