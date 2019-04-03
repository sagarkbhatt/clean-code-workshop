package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
  private String name;
  private List<Rental> rentals = new ArrayList<>();

  public Customer(String name) {
    this.name = name;
  }

  public void addRental(Rental arg) {
    rentals.add(arg);
  }

  public String getName() {
    return name;
  }

  public String statement() {

    int frequentRenterPoints = 0;
    String result = "Rental Record for " + getName() + "\n";

    for (Rental each : rentals) {
      frequentRenterPoints += each.getFrequentRenterPoints();

      //show figures for this rental
      result += "\t" + each.getMovie().getTitle() + "\t" +
          String.valueOf(each.amount()) + "\n";
    }

    //add footer lines result
    result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
    result += "You earned " + String.valueOf(frequentRenterPoints)
        + " frequent renter points";
    return result;
  }

  private double getTotalAmount() {
    double totalAmount = 0;
    for (Rental each : rentals) {

      totalAmount += each.amount();
    }
    return totalAmount;
  }
}

