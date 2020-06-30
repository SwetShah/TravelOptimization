package com.loginext.travel.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loginext.travel.dto.Customer;
import com.loginext.travel.dto.Driver;
import com.loginext.travel.service.CustomerService;
import com.loginext.travel.service.DriverService;
import com.loginext.travel.util.Helper;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "*")
@AllArgsConstructor(onConstructor=@__({@Autowired}))
public class CustomerController {
	
	private CustomerService customerService;
	
	@PostMapping("/find/ride")
	public Map<String,Object> findRide(@RequestBody Customer customer) {
		return customerService.findOptimumRide(customer);
	}
}
