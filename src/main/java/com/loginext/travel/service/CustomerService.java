package com.loginext.travel.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.loginext.travel.dao.CustomerRepository;
import com.loginext.travel.dao.DriverRepository;
import com.loginext.travel.dto.Customer;
import com.loginext.travel.dto.Driver;
import com.loginext.travel.dto.Driver.Status;
import com.loginext.travel.util.Helper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor=@__({@Autowired}))
public class CustomerService {
	
	private CustomerRepository customerRepository;
	private Helper helper;
	private DriverRepository driverRepository;
	
	@Transactional
	public Map<String,Object> findOptimumRide(Customer customer) {
		Map<String,Object> response = new HashMap<>();
		final Double[] minimumDistance= new Double[] {Double.MAX_VALUE};
		List<Driver> drivers = driverRepository.findByStatus(Status.AVAILABLE.toString());
		
		if(!CollectionUtils.isEmpty(drivers)) {
			List<Driver> optimumDistanceDriver = drivers.stream().filter(driver -> calculateDistance(driver.getLatitude(), driver.getLongitude()) < minimumDistance[0]).collect(Collectors.toList());
			Driver driverNearby = optimumDistanceDriver.get(0);
			driverNearby.setCurrentCustomerId(customer.getCustomerId());
			driverNearby.setCurrentCustomerName(customer.getCustomerName());
			driverNearby.getCustomersServed().add(customer.getCustomerId());
			driverNearby.setStatus(Status.BUSY);
		
			double hashcode = customer.getCustomerName().hashCode() + customer.getLatitude() + customer.getLongitude();
			customer.setCustomerId(String.valueOf(hashcode).replace(".", "_"));
			
			driverRepository.save(driverNearby);
			customerRepository.save(customer);
			
			response.put("Success", driverNearby);
		}else {
			response.put("Failure", "No drivers are currently available. Please try again after sometime");
		}
		
		return response;
	}
	
	private double calculateDistance(double latitude1, double longitude1) {
		double latitude2 = 19.197064;
		double longitude2 = 72.857541;
		
		double latitude = getValueInRadians(latitude1) - getValueInRadians(latitude2);
		double longitude = getValueInRadians(longitude1) - getValueInRadians(longitude2);;
		
		double a = Math.pow(Math.sin(latitude / 2), 2)
		+ Math.cos(latitude1) * Math.cos(latitude2)
		* Math.pow(Math.sin(longitude / 2),2);
		
		double c = 2 * Math.asin(Math.sqrt(a)); 
		double r = 6371; 
		return(c * r);
	}
	
	private double getValueInRadians(double value){
		return Math.toRadians(value);
	}
	
}
