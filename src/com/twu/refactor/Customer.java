package com.twu.refactor;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private ArrayList<Rental> rentalList = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }
    public void addRental(Rental arg) {
        rentalList.add(arg);
    }
    public String getName() {
        return name;
    }


    public double calculateTotal(){
        double totalAmount = 0;
        for(Rental rental : rentalList){
            totalAmount += rental.getAmount();
        }
        return totalAmount;
    }

    public int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentalList) {
            frequentRenterPoints += rental.getfrequentrentalPoints();
        }
        return frequentRenterPoints;
    }

    String getRentalSubTotal(Rental rental) {
        return "\t" + rental.getMovie().getTitle() + "\t"
                + String.valueOf(rental.getAmount()) + "\n";
    }

    public List<Rental> getRentalList(){
        return rentalList;
    }

    public String htmlStatement() {
        String header = "<H1>Rentals for <EM>" + getName() + "</EM></H1>";
        String body = "";
        int frequentRenterPoints = 0;
        double totalAmount = 0.0;
        for(Rental rental : rentalList) {
            double thisAmount = 0;
            thisAmount = rental.getAmount();
            body += rental.getMovie().getTitle()+": " + thisAmount+"<BR>";
            frequentRenterPoints += rental.getfrequentrentalPoints();
            totalAmount += thisAmount;
        }
        String Footer = "<P>You owe <EM>"+totalAmount+
                "</EM><P>On this rental you earned <EM>"+frequentRenterPoints+"</EM> frequent renter points<P>";
        return header+"<P>"+body+Footer;
    }
}