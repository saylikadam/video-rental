package com.twu.refactor;

import java.util.List;

/**
 * Created by saylik on 3/18/2015.
 */
public class Statement {

    public String statement(List<Rental> rentalList,Customer customer) {
        String statement = getHeader(customer);
        for(Rental rental : rentalList){
            statement +=customer.getRentalSubTotal(rental);
        }
        statement += getFooter(customer.calculateTotal(), customer.getFrequentRenterPoints());
        return statement;
    }

    private String getHeader(Customer customer) {
        return "Rental Record for " + customer.getName() + "\n";
    }

    private String getFooter(double totalAmount, int frequentRenterPoints) {
        String statement = "";
        statement += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        statement += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
        return statement;
    }

