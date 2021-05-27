package service;

import model.Customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomerService {

    ArrayList<Customer> customerArrayList = new ArrayList<>();
    Map<String, Customer> mapOfCustomers = new HashMap<>();
    private static CustomerService customerService;

    private CustomerService(){
    }
    /*
        Making customerService a singleton
        Note that the variable customerService is made static so it can
        only be instantiated from this class
     */
    public static CustomerService getInstance(){
        if(customerService == null){
            customerService = new CustomerService();
        }
        return customerService;
    }

    public void addCustomer(String email, String firstName, String lastName){
        Customer customer = new Customer(firstName, lastName, email);
        customerArrayList.add(customer);
    }

    public Customer getCustomer(String customerEmail){
        for (Customer c : customerArrayList  ) {
            mapOfCustomers.put(c.getEmail(), c);
        }
        return mapOfCustomers.get(customerEmail);
    }

    public Collection<Customer> getAllCustomers(){
        return customerArrayList;
    }
}
