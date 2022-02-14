package dev.nano.springbootjib.controller;

import dev.nano.springbootjib.mockData.MockData;
import dev.nano.springbootjib.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1/customers")
public class CustomerController {

    @GetMapping("all")
    public List<Customer> getAllCustomers() throws Exception {

        List<Customer> customerList = MockData.getCustomers();
        return customerList;
    }

    @GetMapping("maleCustomers")
    public List<Customer> getMaleCustomers() throws Exception {

        List<Customer> customerList = MockData.getCustomers();

        Predicate<Customer> customerPredicate = customer -> customer.getGender().equals("Male");

        List<Customer> maleCustomers = customerList.stream()
                .filter(customerPredicate)
                .collect(Collectors.toList());

        return maleCustomers;
    }
}
