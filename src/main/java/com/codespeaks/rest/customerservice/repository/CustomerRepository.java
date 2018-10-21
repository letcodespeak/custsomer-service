package com.codespeaks.rest.customerservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.codespeaks.rest.customerservice.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
