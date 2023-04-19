package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.sql.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class WestminsterConsultationManager implements SkinConsultationManager {

    static ArrayList<Doctor> doctors = new ArrayList<>();
    static ArrayList<Consultation> consultation = new ArrayList<>();
    static ArrayList<Patient> patient = new ArrayList<>();


    public static void main(String[] args) {
        WestminsterConsultationManager w = new WestminsterConsultationManager();
        w.Load_Data();
        w.printMenue();


    }

    public void printMenue() {
        while (true) {
            System.out.println("A : Add a new doctor");
            System.out.println("B : Delete a doctor");
            System.out.println("C : Print list of doctors");
            System.out.println("D : Save as a file ");
            System.out.println("F : Add Consultation :");
            System.out.println("P : Add patient details");
            System.out.println("T : Show Consultation details :");
            System.out.println("R : Remove Consultation :");
            System.out.println("G : My GUI :");
            System.out.println("E : Exit the programme :");
            Scanner x = new Scanner(System.in);
            System.out.println("Pleace Enter Your Option : ");
            String menu = x.nextLine();

            switch (menu) {

                case "A":
                    System.out.println("Add a new doctor :");
                    Add_New_Doctor();
                    break;
                case "B":
                    System.out.println("Delete a doctor :");
                    Delete_Doctor();
                    break;
                case "C":
                    System.out.println("Print list of doctor :");
                    Print_the_list_of_the_doctors();
                    break;
                case "D":
                    System.out.println("Save as a file :");
                    Save_as_a_file();
                    break;
                case "F":
                    System.out.println("Add Consultation :");
                    Add_Consultation();
                    break;
                case "E":
                    System.out.println("Exit the programme :");
                    Exit();
                    break;
                case "G":
                    System.out.println("GUI");
                    GUI G = new GUI();
                    G.setVisible(true);
                    break;
                case "T":
                    System.out.println("Consultation Details :");
                    show_Consultation_details();
                    break;
                case "P":
                    System.out.println("Add Patient :");
                    Add_Patient();
                case "R":
                    System.out.println("Remove Consultation");

                default:
                    System.out.println("Invalid Input");


            }


        }


    }

    public void Add_New_Doctor() {
        if (this.doctors.size() >= 10) {
            System.out.println("The centre cannot add more than Ten doctors.If you want add a new doctor,Pleace remove doctor first!");
            return;
        }
        Scanner myScanner = new Scanner(System.in);


        System.out.println("Enter Doctor's Medical licence number :");
        String d_LC_Num = myScanner.nextLine();
        System.out.println("Enter Doctor's Name :");
        String d_Name = myScanner.nextLine();
        System.out.println("Enter Doctor's Sur Name:");
        String d_S_Name = myScanner.nextLine();
        System.out.println("Enter Doctor's Date Of birth :");
        String d_D_O_B = myScanner.nextLine();
        System.out.println("Enter Doctor's Contact Number :");
        Integer d_Con_Num = myScanner.nextInt();
        System.out.println("Enter the Doctor Specialize for :");
        String d_Spez = myScanner.next();
        for (Doctor d : doctors) {
            if (d_LC_Num.equals(d.getMedical_licence_number())) {
                System.out.println("Previously Added This Licence Number");
                return;
            }
        }
        doctors.add(new Doctor(d_LC_Num, d_Spez, d_Name, d_S_Name, d_D_O_B, d_Con_Num));


    }


    public void Delete_Doctor() {
        Scanner myScaner = new Scanner(System.in);
        System.out.println("Enter the licence number :");
        String l = myScaner.next();

        Iterator<Doctor> iterator = doctors.iterator();
        while (iterator.hasNext()) {
            Doctor doctor = iterator.next();
            if (l.equalsIgnoreCase(doctor.getMedical_licence_number())) {
                iterator.remove();
                System.out.println("Sucsesfuly removed");
            }
        }
    }


    public void Print_the_list_of_the_doctors() {
        Sort_Doctors();
        for (int i = 0; i < doctors.size(); i++) {
            Doctor doctor = doctors.get(i);
            System.out.println("Doctor Name : " + doctor.getName());
            System.out.println("Doctor Sur Name : " + doctor.getSur_name());
            System.out.println("Doctor Medical Licence Number : " + doctor.getMedical_licence_number());
            System.out.println("Doctor Date Of Birth : " + doctor.getDate_of_birth());
            System.out.println("Doctor Specialisation : " + doctor.getSpecialisation());
            System.out.println("Doctor Contact Number :" + doctor.getMobile_number());
        }


    }

    public void Save_as_a_file() {

        JSONArray employeeList = new JSONArray();
        for (Doctor doctor : doctors) {
            JSONObject docOb = new JSONObject();
            docOb.put("Name", doctor.getName());
            docOb.put("SurName", doctor.getSur_name());
            docOb.put("Medical_Licence_Number", doctor.getMedical_licence_number());
            docOb.put("Date_Of_Birth", doctor.getDate_of_birth());
            docOb.put("Mobile_Number", doctor.getMobile_number());
            docOb.put("Specialisation", doctor.getSpecialisation());
            JSONObject employeeObject = new JSONObject();
            employeeObject.put("employee", docOb);
            employeeList.add(employeeObject);
        }


        //Write JSON file
        try (FileWriter file = new FileWriter("Doctors.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(employeeList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Load_Data() {

        {
            //JSON parser object to parse read file
            JSONParser jsonParser = new JSONParser();

            try (FileReader reader = new FileReader("Doctors.json")) {
                //Read JSON file
                Object obj = jsonParser.parse(reader);


                JSONArray employeeList = (JSONArray) obj;
                System.out.println(employeeList);


                //Iterate over employee array
                employeeList.forEach(emp -> parseEmployeeObject((JSONObject) emp));


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (org.json.simple.parser.ParseException e) {
                e.printStackTrace();
            }
        }
    }


    public void parseEmployeeObject(JSONObject employee) {
        //Get employee object within list
        JSONObject employeeObject = (JSONObject) employee.get("employee");

        //Get employee first name
        String getName = (String) employeeObject.get("Name");
        System.out.println(getName);


        //Get employee last name
        String getSur_Name = (String) employeeObject.get("SurName");
        System.out.println(getSur_Name);

        //Get employee website name
        String getMedical_licence_number = (String) employeeObject.get("Medical_Licence_Number");
        System.out.println(getMedical_licence_number);

        String getDate_of_birth = (String) employeeObject.get("Date_Of_Birth");
        System.out.println(getDate_of_birth);

        Long getMobile_number = (Long) employeeObject.get("Mobile_Number");
        System.out.println(getMobile_number);

        String getSpecialisation = (String) employeeObject.get("Specialisation");
        System.out.println(getSpecialisation);

        doctors.add(new Doctor(getMedical_licence_number, getSpecialisation, getName, getSur_Name, getDate_of_birth, getMobile_number.intValue()));
    }


    public void Sort_Doctors() {
        doctors.sort(Comparator.comparing(Doctor::getSur_name));
    }

    public void Add_Consultation() {
        Scanner myScanner=new Scanner(System.in);
        System.out.println("Enter your Date for Consultation :");
        String Date = myScanner.next();
        System.out.println("Enter the Doctor Licence :");
        String DLic = myScanner.next();
        System.out.println("Enter the Patient ID :");
        String PId = myScanner.next();
        System.out.println("Enter the Consultation ID :");
        String ConId = myScanner.next();
        System.out.println("Enter the notes :");
        String Note = myScanner.next();
        System.out.println(
                "\nPLEACE ENTER YOUR TIME SLOT WHAT DO YOU NEED\n" +
                "\nTIMESLOT 1 : 08.00 AM - 09.00 AM : " +  "\n" +
                "TIMESLOT 2 : 09.00 AM - 10.00 AM : " +  "\n" +
                "TIMESLOT 3 : 10.00 AM - 11.00 AM : " + "\n" +
                "TIMESLOT 4 : 13.00 AM - 14.00 AM : " +  "\n" +
                "TIMESLOT 5 : 14.00 AM - 15.00 AM : " +  "\n" +
                "TIMESLOT 6 : 15.00 AM - 16.00 AM : " +  "\n" +
                "TIMESLOT 7 : 16.00 AM - 17.00 AM : " +  "\n" +
                "TIMESLOT 8 : 17.00 AM - 18.00 AM : " +  "\n" +
                "TIMESLOT 9 : 18.00 AM - 19.00 AM : "  + "\n" +
                "TIMESLOT 10 : 19.00 AM - 20.00 AM : " +  "\n");
        int timeSlotNumber = myScanner.nextInt();

        boolean isDoctorAvailable = true;
        int cost;
        boolean hasPreviousConsultations = false;
        for (int i = 0; i < consultation.size(); i++) {
            Consultation consultation1 = consultation.get(i);
            if (consultation1.getPatient_ID().equals(PId)) {
                hasPreviousConsultations = true;
                break;
            }
        }
        if (hasPreviousConsultations) {
            cost = 25;
        } else {
            cost = 15;
        }

        for (int i = 0; i < consultation.size(); i++) {
            Consultation consultation = WestminsterConsultationManager.consultation.get(i);
            if (consultation.getDate().equals(Date) && consultation.getDoctorM_L_Number().equals(DLic) && consultation.time_slot.getTime_slot_id() == timeSlotNumber) {
                isDoctorAvailable = false;
                break;
            }
        }

        // If the chosen doctor is not available, assign a different doctor
        if (!isDoctorAvailable) {
            // Create a list of available doctors
            List<Doctor> availableDoctor = new ArrayList<>();
            for (int i = 0; i < doctors.size(); i++) {
                Doctor doc = doctors.get(i);
                if (!doc.getMedical_licence_number().equals(DLic)) {
                    boolean isDoctorBooked = false;
                    for (int j = 0; j < consultation.size(); j++) {
                        Consultation consultation = WestminsterConsultationManager.consultation.get(j);
                        if (consultation.getDate().equals(Date) && consultation.getDoctorM_L_Number().equals(doc.getMedical_licence_number()) && consultation.time_slot.getTime_slot_id() == timeSlotNumber) {
                            isDoctorBooked = true;
                            break;
                        }
                    }
                    if (!isDoctorBooked) {
                        availableDoctor.add(doc);
                    }
                }
            }

            // If there are available doctors, assign a random one
            if (!availableDoctor.isEmpty()) {
                Random random = new Random();
                int index = random.nextInt(availableDoctor.size());
                consultation.add(new Consultation(ConId, PId, Note, Date, availableDoctor.get(index).getMedical_licence_number(), timeSlotNumber,cost));
                //System.out.println("Successfully added the Consultation");
            } else {
                System.out.println("There are no available doctors for the given time slot on the given date.");
            }
        } else {
            // If the chosen doctor is available, add the consultation with the chosen doctor
            consultation.add(new Consultation(ConId, PId, Note, Date, DLic, timeSlotNumber,cost));
           // System.out.println("Successfully added the Consultation");
        }






    }

    public void Add_Patient() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter the patient name :");
        String P_n = myScanner.nextLine();
        System.out.println("Enter the patient Sur name:");
        String P_sn = myScanner.nextLine();
        System.out.println("Eneter the patient date of birth :");
        String P_dob = myScanner.nextLine();
        System.out.println("Enetr the patient mobile number :");
        Integer P_mn = myScanner.nextInt();
        System.out.println("Enter the patient ID:");
        String P_ID = myScanner.next();

        Patient pt = new Patient(P_n, P_sn, P_dob, P_mn, P_ID);

        System.out.println("Successfully Added Patient Details");
        System.out.println("Consultation is Successfull.");

        patient.add(pt);


        //PrintAvailableTime_Slot(id, P_ID, note, d, d_id);

    }

    public void Exit() {

        System.exit(0);
    }

   /* public void PrintAvailableTime_Slot(String Consultation_ID, String patientID, String Notes, String Date, String d_id) {

        ////////////////////////////////////////////////AVAILABILITY OF TIME SLOTS/////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String[] slots = new String[10];  // if true available     // if false already reserved
        for (int i = 0; i < 10; i++) {
            slots[i] = "AVAILABLE";
        }

        if (!WestminsterConsultationManager.consultation.isEmpty()) {
            for (Consultation consult : WestminsterConsultationManager.consultation) {
                if (consult.isResult() == false && consult.getDate().equals(Date) && consult.getDoctorM_L_Number() == d_id) {
                    slots[consult.getTime_slot().getTime_slot_id() - 1] = "AVAILABLE";
                } else {
                    slots[consult.getTime_slot().getTime_slot_id() - 1] = "NON AVAILABLE";
                }
            }
        }
        System.out.println("\nCHOOSE YOUR TIMESLOT BY ENTERING THE TIMESLOT ID(E.g. 1)\n" +
                "\nTIMESLOT 1 : 08.00 AM - 09.00 AM : " + slots[0] + "\n" +
                "TIMESLOT 2 : 09.00 AM - 10.00 AM : " + slots[1] + "\n" +
                "TIMESLOT 3 : 10.00 AM - 11.00 AM : " + slots[2] + "\n" +
                "TIMESLOT 4 : 13.00 AM - 14.00 AM : " + slots[3] + "\n" +
                "TIMESLOT 5 : 14.00 AM - 15.00 AM : " + slots[4] + "\n" +
                "TIMESLOT 6 : 15.00 AM - 16.00 AM : " + slots[5] + "\n" +
                "TIMESLOT 7 : 16.00 AM - 17.00 AM : " + slots[6] + "\n" +
                "TIMESLOT 8 : 17.00 AM - 18.00 AM : " + slots[7] + "\n" +
                "TIMESLOT 9 : 18.00 AM - 19.00 AM : " + slots[8] + "\n" +
                "TIMESLOT 10 : 19.00 AM - 20.00 AM : " + slots[9] + "\n");

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        Scanner user_choice = new Scanner(System.in);
        System.out.println("What is the timeslot you need :");
        int number = user_choice.nextInt();
        Consultation ts = new Consultation(Consultation_ID, patientID, Notes, Date, d_id, number);
        switch (number) {
            case 1:
                System.out.println("Patient" + " " + patientID + " " + "Is allocated for 8.00(a.m)-9.00(a.m) To Doctor License " + " " + ts.getDoctorM_L_Number());
                break;
            case 2:
                System.out.println("Patient" + " " + patientID + " " + "Is allocated for 9.00(a.m)-10.00(a.m) To Doctor License " + " " + ts.getDoctorM_L_Number());
                break;
            case 3:
                System.out.println("Patient" + " " + patientID + " " + "Is allocated for 10.00(a.m)-11.00(a.m) To Doctor License " + " " + ts.getDoctorM_L_Number());
                break;
            case 4:
                System.out.println("Patient" + " " + patientID + " " + "Is allocated for 13.00(a.m)-14.00(a.m) To Doctor License " + " " + ts.getDoctorM_L_Number());
                break;
            case 5:
                System.out.println("Patient" + " " + patientID + " " + "Is allocated for 14.00(p.m)-15.00(p.m) To Doctor License " + " " + ts.getDoctorM_L_Number());
                break;
            case 6:
                System.out.println("Patient" + " " + patientID + " " + "Is allocated for 15.00(p.m)-16.00(p.m) To Doctor License " + " " + ts.getDoctorM_L_Number());
                break;
            case 7:
                System.out.println("Patient" + " " + patientID + " " + "Is allocated for 16.00(p.m)-17.00(p.m) To Doctor License " + " " + ts.getDoctorM_L_Number());
                break;
            case 8:
                System.out.println("Patient" + " " + patientID + " " + "Is allocated for 17.00(p.m)-18.00(p.m) To Doctor License " + " " + ts.getDoctorM_L_Number());
                break;
            case 9:
                System.out.println("Patient" + " " + patientID + " " + "Is allocated for 18.00(p.m)-19.00(p.m) To Doctor License " + " " + ts.getDoctorM_L_Number());
                break;
            case 10:
                System.out.println("Patient" + " " + patientID + " " + "Is allocated for 19.00(p.m)-20.00(p.m) To Doctor License " + " " + ts.getDoctorM_L_Number());
                break;
            default:
                System.out.println("Invalid Time Slot");


        }
        consultation.add(ts);


    }*/

    public void show_Consultation_details() {
        for (Consultation con : consultation) {
            System.out.println("Date-" + " " + con.getDate());
            System.out.println("Notes-" + " " + con.getNotes());
            System.out.println("Consultation ID-" + " " + con.getConsultation_ID());
            System.out.println("Doctor ID-" + " " + con.getDoctorM_L_Number());
            System.out.println("Patient ID-" + " " + con.time_slot.getPatient_ID());
            System.out.println("Time Slot-" + " " + con.time_slot.getTime_slot_id());
            System.out.println("Cost-"+" "+con.getCost());

        }
    }
    public void deleteConsultation() { //cancel consultation

            Scanner userInput=new Scanner(System.in);
            System.out.print("Enter the consultation ID to delete :\n> ");
            String conID = userInput.next();
            Iterator<Consultation> iterator = consultation.iterator();
            while (iterator.hasNext()) {
                Consultation consultation = iterator.next();
                if (conID.equalsIgnoreCase(consultation.getConsultation_ID())) {
                    iterator.remove();
                    System.out.println(conID + " Consultation is canceled");
                }
            }
        }
    }


