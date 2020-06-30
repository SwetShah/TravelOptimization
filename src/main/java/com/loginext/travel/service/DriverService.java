package com.loginext.travel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginext.travel.dao.DriverRepository;
import com.loginext.travel.dto.Driver;
import com.loginext.travel.util.Helper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor=@__({@Autowired}))
public class DriverService {

	private DriverRepository driverRepository;
	
	public void saveDrivers(List<Driver> drivers) {
		driverRepository.saveAll(drivers);
	}
	
	public List<Driver> getAllDrivers() {
		return driverRepository.findAll();
	}
	
}
