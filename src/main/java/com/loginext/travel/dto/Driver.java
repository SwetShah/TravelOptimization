package com.loginext.travel.dto;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Driver {
	
	@Id
	private String driverId;
	private String name;
	private double latitude;
	private double longitude;
	private Set<String> customersServed = new HashSet<>();
	private String currentCustomerId="";
	private String currentCustomerName="";
	private Status status;
	
	public enum Status{
		BUSY, AVAILABLE;
	}
	
}
