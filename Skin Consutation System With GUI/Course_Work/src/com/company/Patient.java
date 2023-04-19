package com.company;

import java.util.Date;

public class Patient extends Person {
     String Patient_ID;

    public Patient(String name, String sur_name, String date_of_birth, int mobile_number, String Patient_ID) {
        super(name, sur_name, date_of_birth, mobile_number);
        this.Patient_ID=Patient_ID;
    }

    public Patient() {

    }


    public void setPatient_ID(String Patient_ID) {
        this.Patient_ID = Patient_ID;
    }

    public String getPatient_ID() {
        return Patient_ID;
    }


}
