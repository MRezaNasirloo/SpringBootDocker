package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by pedramrn@gmail.com on 2016-04-08.
 */
@RestController
public class CustomerController {

    @Autowired
    CustomerRepository repository;

    @RequestMapping(value = "/hello", method = GET)
    public String hello() {
        try {
            return String.format("Hello World from %s", InetAddress.getLocalHost().toString());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "Cannot find the host name.";
    }

    @RequestMapping(value = "/customers", method = GET)
    public List<Customer> index() {
        return repository.findAll();
    }

    @RequestMapping(value = "/customers/create", method = GET)
    public ResponseEntity<Customer> create(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        Customer customer = new Customer(firstName, lastName);
        repository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }
}
