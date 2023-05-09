package com.example.customer.service;

import com.example.customer.entity.Customer;
import com.example.customer.repository.CustomerRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerImpl implements CustomerService{
    private CustomerRepo customerRepo;
    @Autowired
    public CustomerImpl(CustomerRepo customerRepo)
    {
        this.customerRepo=customerRepo;
    }
    @Override
    public List<Customer> listall() {
        return customerRepo.listall();
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public List<Customer> findbyfirstname(String name) {
        return customerRepo.findbyname(name);
    }

    @Override
    public Optional<Customer> findbyid(long id) {
        return customerRepo.findById(id);
    }

    @Override
    public List<Customer> findbyaddress(String address) {
        return customerRepo.findbyaddress(address);
    }


    @Override
    public List<Customer> findbylastname(String cl) {
        List<Customer> customers=customerRepo.findbylastname(cl);
        System.out.println(customers);
        return customers;
    }

    @Override
    @Transactional
    public boolean updatecl(long id, String cfirstname, String clastname) {
         customerRepo.updatefl(id,cfirstname,clastname);
        return false;
    }
}
