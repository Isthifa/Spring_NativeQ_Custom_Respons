package com.example.customer.controller;

import com.example.customer.entity.Customer;
import com.example.customer.response.ApiResponse;
import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerRest {
    private CustomerService customerService;

    @Autowired
    public CustomerRest(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/save")
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @GetMapping("/list")
    public ResponseEntity<Object> listall() {
        List<Customer> allc = customerService.listall();
        if (allc.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Empty List, No value found"));
        } else {
            return ResponseEntity.ok(allc);
        }
    }

    @GetMapping("/firstname/{name}")
    public ResponseEntity<Object> findbyname(@PathVariable String name) {
        List<Customer> customers = customerService.findbyfirstname(name);
        if(customers.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Value Not Found "+name));
        }
        else
        {
            return ResponseEntity.ok(customers);
        }
    }

    @GetMapping("/lastname/{cl}")
    public ResponseEntity<Object> findbyadd(@PathVariable String cl) {
        List<Customer> customers = customerService.findbylastname(cl);
        if(customers.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Last name not found "+cl);
        }
        return new ResponseEntity<>(customers,HttpStatus.FOUND);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> findbyid(@PathVariable int id) {
        Optional<Customer> result = customerService.findbyid(id);
        return result.<ResponseEntity<Object>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT FOUND " + id));
    }

    @GetMapping("/byaddres/{address}")
    public ResponseEntity<Object> findbyaddress(@PathVariable String address) {
        List<Customer> customers = customerService.findbyaddress(address);
        if(customers.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Address Not Found "+address);
        }
        return new ResponseEntity<>(customers, HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}/{cfname}/{clast}")
    public ResponseEntity<?> update(@PathVariable long id, @PathVariable String cfname, @PathVariable String clast) {
        boolean result = customerService.updatecl(id, cfname, clast);
        if (result) {
            return ResponseEntity.ok(new ApiResponse(result, "updated successfully"));
        } else {
            return ResponseEntity.badRequest().body(new ApiResponse(result, "failed to update"));
        }

    }
    @GetMapping("/count")
    public ResponseEntity<Object> count() {
        int nums = customerService.countids();
        if (nums <= 0) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No value found");
        } else {
            return ResponseEntity.ok(nums);
        }
    }
    @DeleteMapping("/byfirstname/{cfirstname}")
    public String delete(@PathVariable String cfirstname)
    {
        customerService.deleteByfirstname(cfirstname);
        return "deleted "+cfirstname;
    }
}
