package com.twu.refactor;

import java.util.ArrayList;
import java.util.List;

public class Customer implements Billable {

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
            totalAmount += rental.getTotalAmount();
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
                + String.valueOf(rental.getTotalAmount()) + "\n";
    }

    public List<Rental> getRentalList(){
        return rentalList;
    }

}