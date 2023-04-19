package com.company;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
public class taskOne {
    public static String[] ship = new String[13]; //Array that holds Names of Passengers in all 12 cabins
    public static int CabinNum = 0;

    public static void main(String[] args) {
        for (int i = 1; i < 13; i++)
            ship[i] = "z";
        mainMenue();
    }

    public static void mainMenue() { // Print Menu method
        Scanner name = new Scanner(System.in);

        Boolean cabinchecker = true;
        while (cabinchecker) {
            System.out.println("V: View All Cabins");
            System.out.println("E: View all Empty Cabins");
            System.out.println("A: Add Customer to Cabin");
            System.out.println("F: Find Customer From Cabin");
            System.out.println("D: Delete Customer from Cabin");
            System.out.println("S: Store program data into file");
            System.out.println("L: Load program data from file");
            System.out.println("O: Vies Passengers Ordered alphabetical Oorder");
            System.out.println("EXIT: Exit the Program");

            System.out.println("Select the option : ");
            String userInput = name.nextLine();
            if (userInput.equalsIgnoreCase("V")) {
                System.out.println("Selected view all cabins ");
                showAllcabins();
            } else if (userInput.equalsIgnoreCase("E")) {
                System.out.println("Selected view empty cabins ");
                showEmptycabins();
            } else if (userInput.equalsIgnoreCase("A")) {
                System.out.println("Selected add customer ");
                addNewcustomer(name);
            } else if (userInput.equalsIgnoreCase("D")) {
                System.out.println("Selected delete customer ");
                deleteCustomer(name);
            } else if (userInput.equalsIgnoreCase("F")) {
                System.out.println("Selected find a customer");
                searchThepassenger(name);

            } else if (userInput.equalsIgnoreCase("O")) {
                System.out.println("Selected the sorting option");
                sortPassengers();
            } else if (userInput.equalsIgnoreCase("S")) {
                System.out.println("Selected the save data option");
                storeData();
            } else if (userInput.equalsIgnoreCase("L")) {
                System.out.println("Selected the load  data option");
                loadData();


            } else if (userInput.equalsIgnoreCase("EXIT")) {
                System.out.println("Thank you for join with us..Have a good day sir! ");
                cabinchecker = false;
            } else {
                System.out.println("ENTER THE VALID OPTION..!");
            }
        }
    }

    // show all Cabins
    public static void showAllcabins() {
        System.out.print("Show all Cabins:");
        for (int i = 1; i < 13; i++) {
            if (ship[i].equals("z")) {
                System.out.println("Cabin " + i + " is Free");
            } else {
                System.out.println("Cabin " + i + " is occupied by: " + ship[i]);
            }
        }
    }

    // Show Empty Cabins
    public static void showEmptycabins() {
        System.out.println("Show all Empty Cabins:");
        for (int i = 1; i < 13; i++) {
            if (ship[i].equals("z"))
                System.out.println("Cabin " + i + " is Free");
        }
    }

    //Add new customer to Cabin
    public static void addNewcustomer(Scanner name) {
        int CustomerCount = 0; //How many cabins are all most full
        for (int i = 1; i < 13; i++) {

            if (!ship[i].equals("z")) {
                CustomerCount += 1;
            }
        }
        if (CustomerCount == 12) { // This condition says all cabins are all most full
            System.out.println("SORRY..! ALL CABINS ARE ALL MOST FULL...TRY AGAIN LATER...");
            return;
        }
        System.out.println("Enter the passenger Name : ");
        String Passenger = name.nextLine();
        Boolean cabinchecker = true;
        while (cabinchecker) {
            System.out.println("Show all Empty Cabins: ");
            for (int i = 1; i < 13; i++) {
                if (ship[i].equals("z"))
                    System.out.println("You can enter the " + i + " cabin ");
            }
            System.out.println("WHAT CABIN DO YOU NEED? " + Passenger + " to : ");
            int CabinOrder = Integer.parseInt(name.nextLine());
            if (CabinOrder >= ship.length) {
                System.out.println("CANNOT ACCESS...! LIMIT IS OVER");
                continue;
            } else {
                if (ship[CabinOrder].equals("z")) {
                    ship[CabinOrder] = Passenger;
                    cabinchecker = false;
                    System.out.println(Passenger + " Passenger is added this cabin " + CabinOrder + "!");
                } else {
                    System.out.println("This cabin is all most full...Try again!  ");
                    continue;
                }
            }
        }

    }
    public static void searchThepassenger(Scanner name) {
        Scanner find = new Scanner(System.in);
        System.out.println("Pleace enter the name to find the custommer: ");
        String select = find.next();
        for (int i = 1; i < 13; i++) {
            if (ship[i].contains(select)) {
                System.out.println( select + " Passenger in the cabin"+i);
            }

        }
    }

   // Delete custommer
    public static void deleteCustomer(Scanner name) {
        System.out.println("Show all full fill cabins");
        for (int i = 1; i < 13; i++) {
            if (!ship[i].equals("z")) {
                System.out.println("Room " + i + " is received by: " + ship[i]);
            }
        }
        Boolean cabinchecker = true;
        while (cabinchecker) {
            System.out.println("Who do you want to remove? ");
            int RoomNo = Integer.parseInt(name.nextLine());
            if (RoomNo >= ship.length) {
                System.out.println("This cabin is all most full...Try again!");
                continue;
            } else {
                System.out.println("Passenger " + ship[RoomNo] + " was deleted passenger from cabin " + RoomNo +"\n");
                ship[RoomNo] = "z";
                cabinchecker = false;
            }
        }
    }

    public static void sortPassengers() {
        String[] OrderofCabin = new String[13]; // orderofcabin array as a backup to ensure no sorted change is permanant
        for (int i = 1; i < 13; i++) {
            OrderofCabin[i] = ship[i];
        }
        for (int i = 1; i < 12; i++) { //Bubble sort
            for (int j = 1; j < 12 - i; j++) {
                if (OrderofCabin[j].toLowerCase().compareTo(OrderofCabin[j + 1].toLowerCase()) > 0) {

                    String Custommers = OrderofCabin[j];
                    OrderofCabin[j] = OrderofCabin[j + 1];
                    OrderofCabin[j + 1] = Custommers;
                }
            }
        }
        System.out.println("Passengers order are sorted with the alphabatical order");
        for (int i = 1; i < 13; i++) {
            if (!OrderofCabin[i].equals("z")) {
                System.out.println(OrderofCabin[i]);
            }
        }
    }

    // Store Program Data into file method
    public static void storeData() {

        try (BufferedWriter bkp = new BufferedWriter(new FileWriter("passenger.txt"))) { // taken from here : https://www.codejava.net/java-se/file-io/how-to-readand-write-text-file-in-java
            bkp.newLine();
            for (int i = 1; i < 13; i++) {
                bkp.write(ship[i]);
                bkp.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Sucessfully Dumped all data to passenger.txt!");
    }


    // Load Program Data from file method
    public static void loadData() {
        try {
            Scanner Loader = new Scanner(new FileInputStream("passenger.txt")); // taken from here : https://www.codejava.net/java-se/file-io/how-to-read-and-writetext-file-in-java
            for (int i = 1; i < 13; i++) {
                ship[i] = Loader.nextLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Sucessfully Loaded all data from Passenger.txt!");
    }
}