package com.example.customer.service;

import com.example.customer.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService{
    List<Customer> listall();
    Customer save(Customer customer);
    List<Customer> findbyfirstname(String name);
    Optional<Customer> findbyid(long id);
    List<Customer> findbyaddress(String address);
    List<Customer> findbylastname(String cl);
    boolean updatecl(long id, String cfirstname, String clastname);
    int countids();
}
