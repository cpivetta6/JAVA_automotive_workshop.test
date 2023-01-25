package com.caiopivetta6;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.caiopivetta6.domain.AWregister;
import com.caiopivetta6.domain.Car;
import com.caiopivetta6.domain.Client;
import com.caiopivetta6.domain.enums.CarType;

public class test {

	public static void main(String[] args) throws ParseException {
		
		// TODO Auto-generated method stub
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Car car1 = new Car(null, "Ferrari", 2020, CarType.Supercar);
		Client client1 = new Client(null, "Roberto Masi", "roberto@gmail.com");
		
		AWregister register1 = new AWregister(null, sdf.parse("20/02/2023").toInstant(),sdf.parse("25/02/2023").toInstant(), "Oil Change", 200.0);
		register1.getClients().add(client1);
		
		client1.setaWregister(register1);
		
		System.out.println(client1.getaWregister().getPrice());
		
		
		
	}

}
