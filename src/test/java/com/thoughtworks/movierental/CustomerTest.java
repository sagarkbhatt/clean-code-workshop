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

        mov = new Movie( "3 Idiots", 0 ); // regular
        rent = new Rental( mov , 4 );
        sagar.addRental( rent );

        mov = new Movie( "ABCD", 2 ); // children
        rent = new Rental( mov, 1 );
        sagar.addRental( rent );

        mov = new Movie( "Gully Boy", 1 ); // new release
        rent = new Rental( mov, 4 );
        sagar.addRental( rent );

        String expected = "Rental Record for Sagar\n";
        expected += "\t3 Idiots\t5.0\n";
        expected += "\tABCD\t1.5\n";
        expected += "\tGully Boy\t12.0\n";
        expected += "Amount owed is 18.5\n";
        expected += "You earned 4 frequent renter points";

        dummyStatement =  expected;
        dummyData = sagar;
    }
}