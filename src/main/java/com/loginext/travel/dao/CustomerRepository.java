package com.loginext.travel.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.loginext.travel.dto.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

}
