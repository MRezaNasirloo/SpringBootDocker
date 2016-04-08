package com.example;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByFirstName(String firstName);
    List<Customer> findByLastName(String lastName);

}
