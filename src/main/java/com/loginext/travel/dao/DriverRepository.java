package com.loginext.travel.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.loginext.travel.dto.Driver;

@Repository
public interface DriverRepository extends  MongoRepository<Driver, String>{
	public List<Driver> findByStatus(String status);
}
