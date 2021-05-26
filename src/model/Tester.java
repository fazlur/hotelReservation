package model;

public class Tester {
    public static void main(String[] args) {
        Customer customer = new Customer("Fazlur", "Abba", "fazlur@aol.com");
        System.out.println(customer);
        Customer customer1 = new Customer("me","You","email");
        System.out.println(customer1);
    }
}
