package com.loginext.travel.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.loginext.travel.dto.Driver;
import com.loginext.travel.dto.Driver.Status;

@Component
public class Helper {
	
	public static List<Driver> getAllDrivers(){
		
		List<Driver> drivers = new ArrayList<Driver>();
		Driver driver1 = new Driver();
		driver1.setDriverId("D_1");
		driver1.setName("Driver_1");
		driver1.setLatitude(19.206213);
		driver1.setLongitude(72.873309);
		driver1.setStatus(Status.AVAILABLE);
		
		Driver driver2 = new Driver();
		driver2.setDriverId("D_2");
		driver2.setName("Driver_2");
		driver2.setLatitude(19.179412);
		driver2.setLongitude(72.856704);
		driver2.setStatus(Status.AVAILABLE);
		
		Driver driver3 = new Driver();
		driver3.setDriverId("D_3");
		driver3.setName("Driver_3");
		driver3.setLatitude(19.197569);
		driver3.setLongitude(72.796830);
		driver3.setStatus(Status.AVAILABLE);
		
		Driver driver4 = new Driver();
		driver4.setDriverId("D_4");
		driver4.setName("Driver_4");
		driver4.setLatitude(19.128710);
		driver4.setLongitude(72.878372);
		driver4.setStatus(Status.AVAILABLE);
		
		Driver driver5 = new Driver();
		driver5.setDriverId("D_5");
		driver5.setName("Driver_5");
		driver5.setLatitude(19.222280);
		driver5.setLongitude(72.838774);
		driver5.setStatus(Status.AVAILABLE);
		
		drivers.add(driver1);
		drivers.add(driver2);
		drivers.add(driver3);
		drivers.add(driver4);
		drivers.add(driver5);
		
		return drivers;
	}
	

}
