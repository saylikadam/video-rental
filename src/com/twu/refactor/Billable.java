package com.twu.refactor;

import java.util.List;

/**
 * Created by saylik on 3/19/2015.
 */
public interface Billable {
    void addRental(Rental arg);

    String getName();

    int getFrequentRenterPoints();

    List<Rental> getRentalList();
}
