package com.twu.refactor;

import java.util.List;

/**
 * Created by saylik on 3/20/2015.
 */
public class HtmlStatement {

    public String getHtmlHeader(Billable billable){
        return "<H1>Rentals for <EM>" + billable.getName() + "</EM></H1>";
    }

    public String getHtmlFooter(double totalAmount, int frequentRenterPoints) {
        String statement = "";
        statement += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        statement += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
        return statement;
    }

    public String getHtmlStatement(List<Rental> rentalList,Customer customer){
        String statement = "";
        for(Rental rental :rentalList){
            statement += customer.getRentalSubTotal(rental);
        }
        statement += getHtmlFooter(customer.calculateTotal(),customer.getFrequentRenterPoints());
        return statement;
    }

}
