package service;

import model.Customer;

public class CustomerService {


    public void addCustomer(String email, String firstName, String lastName){
        Customer customer = new Customer(firstName, lastName, email);
    }

}
