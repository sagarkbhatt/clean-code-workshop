package com.thoughtworks.movierental;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CustomerTest {

    private Customer dummyData;

    private String dummyStatement;

    @Test
    public void test(){}

    @Test
    public void testStatement() {

        setCustomerDummyData();
        assertEquals( dummyStatement, dummyData.statement() );
    }

    public void setCustomerDummyData() {

        Customer sagar = new Customer( "Sagar" );

        Rental rent;
        Movie mov;

        mov = new Movie( "MI4", 0 ); // REGULAR
        rent = new Rental( mov , 2 );
        sagar.addRental( rent );

        mov = new Movie( "3 Idiots", 0 ); // REGULAR
        rent = new Rental( mov , 4 );
        sagar.addRental( rent );

        mov = new Movie( "ABCD", 2 ); // CHILDRENS
        rent = new Rental( mov, 1 );
        sagar.addRental( rent );

        mov = new Movie( "Gully Boy", 1 ); // NEW_RELEASE
        rent = new Rental( mov, 4 );
        sagar.addRental( rent );

        String expected = "Rental Record for Sagar\n";
        expected += "\tMI4\t2.0\n";
        expected += "\t3 Idiots\t5.0\n";
        expected += "\tABCD\t1.5\n";
        expected += "\tGully Boy\t12.0\n";
        expected += "Amount owed is 20.5\n";
        expected += "You earned 5 frequent renter points";

        dummyStatement =  expected;
        dummyData = sagar;
    }
}