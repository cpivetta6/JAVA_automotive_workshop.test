package com.caiopivetta6;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.caiopivetta6.domain.AWregister;
import com.caiopivetta6.domain.Address;
import com.caiopivetta6.domain.Car;
import com.caiopivetta6.domain.City;
import com.caiopivetta6.domain.Client;
import com.caiopivetta6.domain.State;
import com.caiopivetta6.domain.enums.CarType;
import com.caiopivetta6.repositories.AWregisterRepository;
import com.caiopivetta6.repositories.AddressRepository;
import com.caiopivetta6.repositories.CarRepository;
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
	
	@Autowired
	private CarRepository carRepository;

	@Override
	public void run(String... args) throws Exception, ParseException {
		// TODO Auto-generated method stub
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//City AND State 
		
		State state = new State(null, "Veneto");
		City city = new City(null, "Verona", state);
		
		
		stateRepository.save(state);
		cityRepository.save(city);
		
		//AUTOWORKSHOP 
		
		AWregister register1 = new AWregister(null, sdf.parse("20/02/2023").toInstant(),sdf.parse("25/02/2023").toInstant(), "Oil Change", 200.0);
		aWregisterRepository.save(register1);
		
		
		//CLIENT and ADDRESS
		Client client1 = new Client(null, "Roberto Masi", "roberto@gmail.com");
		Address address1 = new Address(null, "Corso porta nuova","78", "Centro", "123412", city);
		Car car1 = new Car(null, "Ferrari", 2020, CarType.Supercar);
		Car car2 = new Car(null, "Lamborghini", 2021, CarType.Supercar);
		
		
		
		client1.getCars().add(car1);
		client1.getCars().add(car2);
		client1.getPhone().add("3421231412");
		client1.setAddress(address1);
		client1.setaWregister(register1);
		
		register1.getClients().add(client1);
		
		address1.setClient(client1);
		
		car1.setClient(client1);
		car2.setClient(client1);
		
		
		clientRepository.save(client1);
		addressRepository.save(address1);
		carRepository.saveAll(Arrays.asList(car1,car2));
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
