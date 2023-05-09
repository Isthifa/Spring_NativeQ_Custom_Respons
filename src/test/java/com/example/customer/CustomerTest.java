package com.example.customer;

import com.example.customer.entity.Customer;
import com.example.customer.repository.CustomerRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class CustomerTest {
	@Autowired
	private CustomerRepo customerRepo;

	@Test
	public void testall() {
		List<Customer> listall = customerRepo.listall();
		listall.forEach(System.out::println);
	}
	@Test
	public void savetest()
	{
		Customer customer=new Customer("user5","test5","bangalore","karnataka");
		customerRepo.save(customer);
		assert 5==customer.getCid();
	}

	@Test
	public void finbyadd()
	{
	}
}
