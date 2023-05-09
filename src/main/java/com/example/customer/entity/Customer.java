package com.example.customer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cid;
    private String cfname;
    private String clname;
    private String city;
    private String address;

    public Customer(String cfname, String clname, String city, String address) {
        this.cfname=cfname;
        this.clname=clname;
        this.city=city;
        this.address=address;
    }
}
