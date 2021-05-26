package model;

import java.util.regex.Pattern;

public class Customer {
    String firstName;
    String lastName;
    String email;

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

        //TODO improve  emailRegex
        String emailRegex = "^(.+)@(.+).(.+)$";

        Pattern emailPattern = Pattern.compile(emailRegex);

        if (!emailPattern.matcher(this.email).matches()){
            throw new IllegalArgumentException("The email format is not correct!");
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + "}";
    }



}
