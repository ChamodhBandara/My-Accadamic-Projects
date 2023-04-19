package com.company;

import java.util.Scanner;

public class Main {
    public static boolean dataloded = false; // manage for data loading process

    public static Passengerscabin passengers[] = new Passengerscabin[12];// Object for rooms

    private static void initialise( Object person[] ) {
        //Initialise for the passenger array

        for (int i = 0; i < person.length; i++ ){
            //Array for initialise
            person[i] = new Passengerscabin();

        }
    }

    public static void main(String[] args) {

        Cabin cabin = new Cabin();// Object for cabins

        initialise(passengers);// Call for initialise method

        boolean v = true; // break for do while and user need to exit
        do {
            //repeat for menu

            String val = cabin.menu(passengers, dataloded);// get selection from menu

            switch (val) {

                case "a":
                    // Add customer
                    cabin.addCustomerToCabin(passengers);
                    break;
                case "v":
                    //View passengers
                    if (!dataloded) {
                        System.out.println("\nWarning!...\nCan't load the data\n");
                    }
                    System.out.println(" ********************* All Empty Rooms ******************\n");
                    cabin.viewAllCabins(passengers);

                    break;

                case "e" :
                    //Find empty passengers
                    cabin.displayEmptyCabins(passengers, dataloded);
                    break;

                case "d":
                    //Delete customer
                    cabin.deleteCustomer(passengers, dataloded);
                    break;

                case "f":
                    //Find customer from array
                    cabin.findRoomFromName(passengers, dataloded);
                    break;

                case "t":
                    //Find customer from array
                    cabin.findTotalExpence(passengers, dataloded);
                    break;

                case "s":
                    //Store data to txt file
                    dataloded = cabin.storeData(passengers, dataloded);
                    break;


                case "l":
                    //Load data from txt file

                    dataloded = true;// change
                    cabin.loadData(passengers);
                    break;


                case "o":
                    //Sort passengers by name

                    cabin.sort(passengers, dataloded);
                    break;


                case "x" :
                    //For exit
                    System.exit(0);



                    Scanner input = new Scanner(System.in);// get some scanner object

                    System.out.print("You can't store the data, do you want exit (Y/N) :");
                    String val2 = input.next().toLowerCase();//get input

                    if (val2.charAt(0) == 'y'  && val2.length()==1){
                        //check the input
                        System.out.println("End of the progress!");
                        v = false;//stop do while loop. help to exit
                    }else if (!(val2.charAt(0) == 'n' && val2.length()==1)){

                        System.out.println("Not a valid data");//show error
                    }
                    break;

                default:
                    //Invalid data
                    System.out.println("Not a valid data!...\nTry again later.....");
                    break;
            }

        }while (v); //while condition is true

    }
}

