package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
public class Cabin {

    public static String menu(Passengerscabin[] cabin, boolean dataloded){

        Scanner choice = new Scanner(System.in);// create Scanner object
        String value = "";// take the data from user

        do { //if user enter the wrong data this loop help to take new data again;

            try {  //help to catch error


                System.out.println("V: View All Cabins");
                System.out.println("E: View all Empty Cabins");
                System.out.println("A: Add Customer to Cabin");
                System.out.println("F: Find Customer From Cabin");
                System.out.println("D: Delete Customer from Cabin");
                System.out.println("S: Store program data into file");
                System.out.println("L: Load program data from file");
                System.out.println("T: View Total Expences");
                System.out.println("O: View Passengers Ordered alphabetical Order");
                System.out.println("EXIT: Exit the Program");
                System.out.println("Please Enter Your Selection : ");

                value = choice.next();//take data from user


                value = value.toLowerCase();//To lower case

                break; //Input the correct data & "break" brake the do while loop

            }catch (Exception exception){
                //Input the invalid data & run this part

                choice.nextLine();
                // stop showing infinity error messages;

                System.out.println("Not valid data!...\nTry again later!... ");
            }

        }while (true);

        return value;// return user data input to main function

    }

    //Take some user datas
    private static String[] enterUserData(String cabiNum){

        // get  from user
        Scanner cust = new Scanner(System.in);
        String[] insert = new String[9];// create array
        boolean x =true;

        do {
            // manage user's invalid inputs

            try {
                System.out.print("Enter the first name for room " + cabiNum + " :");
                String Fname = cust.next();//Take first name

                System.out.print("Enter the surename for room " + cabiNum + " :");
                String surname = cust.next();//Take the surname

                System.out.print("Enter "+Fname+"'s"+ " Expence :");
                int cost = cust.nextInt();//Take the expence

                insert[0] = Fname;
                insert[1] = surname;
                insert[2] = String.valueOf(cost);

                System.out.print("Enter the first name for room" + cabiNum + " :");
                String Fname1 = cust.next();//Take first name

                System.out.print("Enter the surename for room" + cabiNum + " :");
                String surname1 = cust.next();//Take surname

                System.out.print("Enter "+Fname1+"'s"+ " Expence :");
                int cost1 = cust.nextInt();//Take expence

                insert[3] = Fname1;
                insert[4] = surname1;
                insert[5] = String.valueOf(cost1);

                System.out.print("Enter First name for room" + cabiNum + " :");
                String Fname2 = cust.next();//Take first name

                System.out.print("Enter Surename for room" + cabiNum + " :");
                String surname2 = cust.next();//Take surname

                System.out.print("Enter "+Fname2+"'s"+ " Expence :");
                int cost2 = cust.nextInt();//Take expence

                insert[6] = Fname2;
                insert[7] = surname2;
                insert[8] = String.valueOf(cost2);

                x = false;// stop do while

            }catch (Exception exception){
                // Entered some invalid data & run this part
                cust.nextLine();// help to stop print error massage infinitely
                System.out.println("Not valid data!...\nTry again later!...");//error massage

            }

        }while (x);

        return insert;// return values
    }

    //Add Customer to the Cabin
    public static void addCustomerToCabin(Passengerscabin[] passengers){
        // adding customer to hotel array
        System.out.println(" Add Passenger");


        Scanner insert = new Scanner(System.in);//  scanner object
        boolean x = true; // brake do while loop

        boolean full = true;

        do {
            //if user enter the wrong data this loop help to take new data again;
            try {
                int roomNum; // store room number from passengers
                for (int i = 0; i< passengers.length; i++){
                    if (passengers[i].FirstName.equals("e")){
                        full = false; // check passengers fullfilled or not
                        break;
                    }
                }

                if (full){
                    // if full this one runs
                    // creating waiting room
                    addWaitingRoom();// called waiting room method
                    x = false;// stop do while

                }else {
                    // if not full this part runs
                    // add user to room

                    System.out.print("Enter room number (0-" + (passengers.length - 1) + ") or X to exit : ");
                    String temp= insert.next();// get input from user


                    if (temp.equalsIgnoreCase("x")){
                        //User enterd x this one runs
                        // exit this adding function
                        x = false;//brake do while loop

                    }else {
                        roomNum = Integer.parseInt(temp);// if user enter number get number in value

                        if ((passengers[roomNum].FirstName).equals("e")) {
                            //check room  empty or not
                            // if empty this one happen

                            String[] data = enterUserData(" " + roomNum);// Take data

                            //add data to cabin array
                            passengers[roomNum].addData(data[0], data[1],Integer.parseInt(data[2]),data[3], data[4],Integer.parseInt(data[5]),data[6], data[7],Integer.parseInt(data[8]));
                            x = false;//break do while

                        } else {
                            //room is not empty
                            System.out.println("passenger number " + roomNum + " is not empty");

                        }
                    }
                }

            }catch (Exception exception){
                // Enter the invalid data & this part runs
                insert.nextLine();// help to stop print error massage infinitely
                System.out.println("Not valid data!...\nTry again later!...");//error massage
            }
        }while (x);
    }



    //View All Cabins
    public static void viewAllCabins(Passengerscabin[] passengers){
        for(int i = 0; i< passengers.length; i++){
            if (passengers[i].FirstName.equals("e")) {
                System.out.println("room " + i + " is empty");
            } else {
                System.out.println("cabin " + i + " reserved by " + passengers[i].FirstName + " " + passengers[i].Surname + "\n Expence : " + passengers[i].expence +"Rs.\n");
                System.out.println("cabin " + i + " reserved by " + passengers[i].FirstName1 + " " + passengers[i].Surname1 + "\n Expence : " + passengers[i].expence1 +"Rs.\n");
                System.out.println("cabin " + i + " reserved by " + passengers[i].FirstName2 + " " + passengers[i].Surname2 + "\n Expence : " + passengers[i].expence2 +"Rs.\n");


            }
        }
    }


    //Display Empty Cabins
    public static void displayEmptyCabins(Passengerscabin[] cabin, boolean dataloded){

        //get data from cabin array.
        //find empty passengers
        //show empty passengers

        System.out.println(" All Empty Rooms ");


        for (int i = 0; i < cabin.length; i++){

            //get array indexes

            if (cabin[i].FirstName.equals("e")){//Take some data and find empty passengers

                System.out.println("room "+i +" is empty");//Display empty passengers

            }
        }

        if (!dataloded){
            // if user not load data from file this warning massage show
            System.out.println("\nWarning!....\nData cant be load!...");
        }
    }



    //Delete Customer from Cabin
    public static void deleteCustomer(Passengerscabin[] cabin, boolean dataloded){
        // delete customer
        // manage passengers with waiting room

        if (!dataloded) {
            // show warning

            System.out.println("\nWarning!....\nData can't be load");
        }

        Scanner enter = new Scanner(System.in);

        boolean x = true; // help to stop do while loop

        System.out.println("Delete ");

        do {
            // if user enter the wrong data this loop help to take new data again

            try {
                // manage user's wrong enter datas

                System.out.println("A. Delete by cabin number\nB. Delete by passenger name\nX. back");
                System.out.print("Enter letter : ");
                String val = enter.next().toLowerCase();// entering data

                int index = -1;// help to take deleting cabin room number

                switch (val){
                    case "a":
                        do {
                            // manage to user's wrong entered data

                            try {

                                System.out.print("Enter room number or type X to go back : ");
                                String temp = enter.next();// Take enter data

                                if (temp.substring(0, 1).equalsIgnoreCase("x") && temp.length() == 1) {
                                    // if user want exit this part runs
                                    break;
                                } else {

                                    index = Integer.parseInt(temp);// take index

                                }

                                if (index < cabin.length){
                                    cabin[index].addData("e","e",0,"e","e",0,"e","e",0);// remove user

                                    System.out.println("Passenger deleted ...\n");

                                    x = false;// stop do while

                                }else {

                                    System.out.println("Can't find passenger...\n");

                                }

                                break;

                            }catch(Exception exception){

                                // exception
                                enter.nextLine();// help to stop show unlimited errors
                                System.out.println("Not valid data!...\nTry again later!...");

                            }

                        }while (true);

                        break;

                    case "b":

                        try {

                            while (true) {

                                System.out.print("Enter passenger First name or type X to go back : ");
                                String name = enter.next();// take inputs

                                if (name.substring(0,1).equalsIgnoreCase("x")&& name.length() == 1){
                                    // user want go back to this part runs

                                    break;
                                }

                                for (int i = 0; i < cabin.length; i++) {
                                    // check for name


                                    if (cabin[i].FirstName.equals(name)) {
                                        // if program find user this part runs
                                        System.out.println("Passener deleted ...\n");
                                        index = i;// find room num
                                        x = false;// stop do while
                                        break;// help to get first customer only
                                    }
                                }

                                if (index == -1) {

                                    // if can't find customer this part runs

                                    System.out.println("Can't find Passenger!...");


                                } else {

                                    cabin[index].addData("e","e",0,"e","e",0,"e","e",0);// delete passenger

                                    break;

                                }
                            }
                        }catch(Exception exception){
                            enter.nextLine();
                            System.out.println("Not valid data!...\nTry again later!...");
                        }

                        break;

                    case "x":
                        // i user want exit this part runs
                        x = false;// stop do while
                        break;

                    default:
                        System.out.println("Not valid data!...\nTry again later!...");

                }

                if (Queue.size()!=0){
                    //  waiting room have persons this part runs
                    // add person from waiting room

                    String[] data = Queue.get(0);// Take first passenger

                    cabin[index].addData(data[0], data[1],Integer.parseInt(data[2]),data[0], data[1],Integer.parseInt(data[2]),data[0], data[1],Integer.parseInt(data[2]));// add person

                    Queue.remove(0);// remove passenger

                    System.out.println("Passenger "+data[0]+" added from waiting room");// show message

                }

            }catch (Exception exception){
                enter.nextLine();

                System.out.println("Not valid data!...\nTry again later!...");
            }
        }while (x);
    }


    //Find cabin from Passengername
    public static void findRoomFromName(Passengerscabin[] cabin, boolean dataloded){

        Scanner input = new Scanner(System.in);// create scanner object

        boolean x = true;// help to break do while loop

        System.out.println("  Find passenger ");

        if (!dataloded){// if user didn't load data once this warning show

            System.out.println("\nWarning!....\nData can't be load");

        }

        do {
            //User entered invalid data & this loop help to get data again

            try{

                System.out.print("Enter passenger first name or or type X to exit : ");
                String name = input.next();//get customer first name

                if (name.substring(0,1).equalsIgnoreCase("x")&& name.length() == 1){
                    //if user enter x this part happen
                    // exit from find room function this part runs

                    x = false;// brake do while loop

                }else{

                    boolean val = true;// help to show error if customer name didn't exist

                    for (int i = 0; i < cabin.length; i++) {
                        //get data from cabin array

                        if (cabin[i].FirstName.equals(name)){
                            // find user
                            //if found this one run

                            System.out.println("Cabin "+i+" is reserved by "+name);//show data
                            val = false;//stop show error message
                            x =false;// breake do while loop
                        }
                    }
                    if (val){
                        //if cant find customer this part runs
                        System.out.println("Can't find passenger!....\n Try again later!....");//display error
                    }
                }

            }catch (Exception exception){
                //user input wrong input this part runs

                input.nextLine();//help to stop showing infinity error messages
                System.out.println("Invalid data!... \nTry again later!...");
            }
        }while (x);

    }


    //Store data to text file
    public static boolean storeData(Passengerscabin[] cabin, boolean dataloded) {
        //create data2.txt file
        //store cabin array into data2.txt file

        File file = new File("data2.txt");//create file

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.newLine();
            //create write object for data2.txt file

            for (int i = 0; i< cabin.length; i++) {
                //read data from cabin array

                String contents = cabin[i].FirstName+","+cabin[i].Surname+","+cabin[i].expence+":";
                String contents1 = cabin[i].FirstName1+","+cabin[i].Surname1+","+cabin[i].expence1+":";
                String contents2 = cabin[i].FirstName2+","+cabin[i].Surname2+","+cabin[i].expence2+":";//create content for store

                writer.write(contents);
                writer.write(contents1);
                writer.write(contents2);//write data2.txt file
                writer.newLine();
            }
            System.out.println("Data stored");
        } catch (Exception exception) {
            //if error happen this part happen
            exception.printStackTrace();//display error
        }
        return dataloded;

    }

    //Load Data to text file
    public static void loadData(Passengerscabin[] cabin) {

        //get read data from data2.txt file
        //store data to cabin array
        File file = new File("data2.txt");//create file object
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            //read data from data2.txt file

            String temp;
            temp = reader.readLine();// get all data from data2.txt file and store
            for (int i = 0; i < cabin.length; i++) {
                //get data from temp
                // update  cabin array
                //This is like cabin[i] = reader.nextLine();
                cabin[i].FirstName = temp.split(":")[i].split(",")[1];
                cabin[i].Surname = temp.split(":")[i].split(",")[2];
                cabin[i].expence = Integer.parseInt(temp.split(":")[i].split(",")[3]);
            }
            System.out.println("Data loaded");

        } catch (Exception exception) {
            //if error comes in this part happen.
            //show error message
            //my assumption is data2.txt file always have
            System.out.println("No data for load... "+exception);//display error

        }
    }

    // For the sorting function Comparing first name and second name
    private static boolean comp(String first, String second){

        boolean x = false;
        int length = 0;
        if ((second.substring(0,1).equals( "e") && second.length() ==1)){
            x = true;
        }else {

            if (first.length() < second.length()) {
                length = first.length();
            } else {
                length = second.length();
            }

            for (int i = 0; i < length; i++) {
                int fnsize;
                int snsize;

                fnsize = first.charAt(i);
                snsize = second.charAt(i);

                if (fnsize > snsize) {
                    x = true;
                    break;
                } else if (fnsize < snsize) {
                    x = false;
                    break;
                }else {
                    continue;
                }
            }
        }
        return x;
    }
    //View passenger from Alphabetical order
    public static void sort(Passengerscabin[] cabin, boolean dataloded){

        //get data from cabin
        //sort data
        //show data

        String[][] temp = new String[cabin.length][9];// help to get data


        for (int i =0; i< cabin.length; i++){
            //get first name
            //get surname
            //get room number
            //update temp array

            temp[i][0] = cabin[i].FirstName;//first name
            temp[i][1] = cabin[i].Surname;//surname
            temp[i][2] = String.valueOf(i);//room number

            temp[i][3] = cabin[i].FirstName1;//first name
            temp[i][4] = cabin[i].Surname1;//surname
            temp[i][5] = String.valueOf(i);//room number

            temp[i][6] = cabin[i].FirstName2;//first name
            temp[i][7] = cabin[i].Surname2;//surname
            temp[i][8] = String.valueOf(i);//room number

        }

        if (!dataloded){
            // show warning if user didn't load data once
            System.out.println("\nWarning....\nData isn't load\n \n");//message

        }

        for (int i =0; i< temp.length; i++){
            // get data and compare names
            //get first room and compare with all others and get second room
            // sort with empty passengers because we use "e" to represent empty passengers
            for (int x =1; x< temp.length-i; x++){
                if (comp(temp[x-1][0].toLowerCase(),temp[x][0].toLowerCase())){
                    //compare first letter of name
                    //if first room's name's first letter is grater than second room's first letter this part runs
                    // if compareTo return 1 this part runs

                    String[] t = temp[x-1];//get temp value ange put data
                    //change data
                    temp[x-1] = temp[x];
                    temp[x] = t;

                }

            }

        }

        String[][] temp2 =new String[temp.length][3];// help to remove empty room from sorting
        ArrayList<String> temp3 = new ArrayList<>();// help to get empty room from numbers

        int c =0;// help to count empty passengers. helps to add empty passengers to end of the array

        for(int i =0; i< temp.length; i++) {

            //get data from temp

            if (!(temp[i][0].length() == 1 || temp[i][0].charAt(0) == 'e')){
                // check empty cabins
                // if cabins not empty this one runs

                temp2[c] = temp[i];// add not empty passengers

                c++;// count not empty passengers

            }else {
                //if cabin empty get cabin number and add to temp3 array list
                temp3.add(temp[i][2]);//add data / [i][2] is the room number

            }
        }

        for (int i = 0; i< temp3.size(); i++){
            // add empty passengers to end of the array

            temp2[c][2] = temp3.get(i);// add data
            c++;

        }

        temp = temp2;// change temp2 array reference to temp

        System.out.println(" --------------------Cabins--------------------\n");


        for (int i =0; i< temp.length; i++){
            //show sorted passengers

            if (temp[i][0] == null){
                //if passengers empty this one runs

                System.out.println("passenger " + temp[i][2] + " is empty");


            }else {
                //room not empty this one show names and room number

                System.out.println(temp[i][0]+" "+temp[i][1]+" occupied room "+temp[i][2]);
                System.out.println(temp[i][3]+" "+temp[i][4]+" occupied room "+temp[i][5]);
                System.out.println(temp[i][6]+" "+temp[i][7]+" occupied room "+temp[i][8]);

            }
        }
    }



    private static ArrayList<String []> Queue = new ArrayList<String[]>();// create array list to manage waiting room
    private static void addWaitingRoom(){
        // create waiting room
        Scanner input = new Scanner(System.in);
        boolean y = true;
        System.out.println("All passengers are full");// show message

        try {
            do {

                System.out.println("Do you want add into waiting room (Y/N)");
                String val = input.next().toLowerCase();// get permission

                switch (val){

                    case "y":
                        y = false;
                        String[] data =enterUserData(" ");// get data frm user
                        Queue.add(data);// add to waiting room
                        System.out.println("Successfully added");// show message

                        break;
                    case "n":
                        y = false;
                        break;
                    default:
                        System.out.println("Not valid data!...\nTry again later!...");
                        break;
                }

            }while (y);

        }catch (Exception exception){
            // if user enter wrong input this part runs
            input.nextLine();// help to stop print error massage infinitely
            System.out.println("Not valid data!...\nTry again later!...");//error massage
        }


    }

    //Find Total Expence
    public static void findTotalExpence(Passengerscabin[] passengers, boolean dataloded){

        Scanner input = new Scanner(System.in);// create scanner object

        boolean x = true;// help to break do while loop

        System.out.println(" Total expences \n");

        if (!dataloded){// if user didn't load data once this warning show

            System.out.println("\nWarning!....\nData can't be load");

        }

        do {
            //if user enter wrong input this loop help to get data again

            try{

                System.out.print("Enter passenger first name or type X to exit : ");
                String name = input.next();//get customer first name

                if (name.substring(0,1).equalsIgnoreCase("x")&& name.length() == 1){
                    //if user enter x this part happen
                    // exit from find room function this part runs

                    x = false;// brake do while loop

                }else{

                    boolean val = true;// help to show error if customer name didn't exist
                    int sum=0;
                    for (int i = 0; i < passengers.length; i++) {
                        //get data from hotel array

                        if (passengers[i].FirstName.equals(name)){
                            // find user
                            //if found this one run
                            System.out.println("Expence of "+name + " = "+ passengers[i].expence+"$");//show data
                            val = false;//stop show error message
                            x =false;// breake do while loop

                        }
                        sum = sum+ passengers[i].expence;

                        if (passengers[i].FirstName1.equals(name)){
                            // find user
                            //if found this one run
                            System.out.println("Expence of "+name + " = "+ passengers[i].expence1+"$");//show data
                            val = false;//stop show error message
                            x =false;// breake do while loop

                        }
                        sum = sum+ passengers[i].expence1;

                        if (passengers[i].FirstName2.equals(name)){
                            // find user
                            //if found this one run
                            System.out.println("Expence of "+name + " = "+ passengers[i].expence2+"$");//show data
                            val = false;//stop show error message
                            x =false;// breake do while loop

                        }
                        sum = sum+ passengers[i].expence2;
                    }
                    System.out.println("Total expence is "+sum);
                    if (val){
                        //if cant find customer this part runs
                        System.out.println("Can't find passenger!....\n Try again later!....");//display error
                    }
                }

            }catch (Exception exception){
                //user input wrong input this part runs

                input.nextLine();//help to stop showing infinity error messages
                System.out.println("Not valid data!... \nTry again later!...");
            }
        }while (x);
    }

}


