package com.loginext.travel.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loginext.travel.dto.Driver;
import com.loginext.travel.dto.Driver.Status;
import com.loginext.travel.service.DriverService;
import com.loginext.travel.util.Helper;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/driver")
@CrossOrigin(origins = "*")
@AllArgsConstructor(onConstructor=@__({@Autowired}))
public class DriverController {
	private DriverService driverService;
	private Helper helper;
	
	@GetMapping("/save")
	public void saveAllDriver() {
		List<Driver> drivers = helper.getAllDrivers(); 
		driverService.saveDrivers(drivers);
	}
	
	@GetMapping("/get")
	public List<Driver> currentStatusOfDrivers() {
		return driverService.getAllDrivers();
	}
}
