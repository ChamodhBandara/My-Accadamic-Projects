package com.company;

public class Passengerscabin {
    // create a room
    // have  customer firstname, surname, expences
    //initialise variables
    String FirstName;
    String Surname;
    int expence;

    String FirstName1;
    String Surname1;
    int expence1;

    String FirstName2;
    String Surname2;
    int expence2;


    public Passengerscabin() {

        //add default value using constructor
        FirstName = "e";
        Surname = "e";
        expence = 0;

        FirstName1 = "e";
        Surname1 = "e";
        expence1 = 0;

        FirstName2 = "e";
        Surname2 = "e";
        expence2 = 0;

    }

    public void addData( String f, String s, int c,String f1, String s1, int c1,String f2, String s2, int c2) {
        // add data to class

        FirstName = f;
        Surname = s;
        expence = c;

        FirstName1 = f1;
        Surname1 = s1;
        expence1 = c1;

        FirstName2 = f2;
        Surname2 = s2;
        expence2 = c2;


    }


}

