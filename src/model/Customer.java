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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + "\n" +
                ", lastName='" + lastName + "\n" +
                ", email='" + email + "\n" + "}";
    }



}
