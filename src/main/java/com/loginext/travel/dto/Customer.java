package com.loginext.travel.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Customer {
	@Id
	private String customerId;
	private String customerName;
	private double latitude;
	private double longitude;
}
