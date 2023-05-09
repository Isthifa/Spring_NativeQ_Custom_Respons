package com.example.customer.repository;

import com.example.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer,Long> {

    @Query("select c from Customer c where c.cfname=:n")
    List<Customer> findbyname(@Param("n") String name);

    @Query(value = "select * from Customer ",nativeQuery = true)
    List<Customer> listall();

    @Query(value="select * from Customer where clname=:cl",nativeQuery = true)
    List<Customer> findbylastname(@Param("cl") String cl);

    @Query(value="select * from Customer where address=:address",nativeQuery = true)
    List<Customer> findbyaddress(@Param("address") String address);

    @Modifying
    @Query(value = "update Customer set cfname=:cfirstname,clname=:clastname where cid=:id",nativeQuery = true)
    void updatefl(@Param("id") long id, @Param("cfirstname") String cfirstname, @Param("clastname") String clastname);

    @Query(value = "select count(cid) from Customer ",nativeQuery = true)
    int countallid();

    @Modifying
    @Query(value = "delete from Customer where cfname=:cfirstname",nativeQuery = true)
    void deletebyfirstname(@Param("cfirstname") String cfirstname);

}
