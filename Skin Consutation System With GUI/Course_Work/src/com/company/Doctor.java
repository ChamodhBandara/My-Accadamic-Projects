package com.company;

public class Doctor extends Person{
    private String  medical_licence_number;
    private String Specialisation;

    public Doctor(String medical_licence_number, String specialisation, String name, String sur_name, String date_of_birth, int mobile_number) {
        super(name, sur_name, date_of_birth, mobile_number);
        this.medical_licence_number = medical_licence_number;
        Specialisation = specialisation;

    }
    public Doctor(){}


    public void setMedical_licence_number(String medical_licence_number) {
        this.medical_licence_number = medical_licence_number;
    }

    public String getMedical_licence_number() {
        return medical_licence_number;
    }

    public void setSpecialisation(String Specialisation) {
        this.Specialisation = Specialisation;
    }

    public String getSpecialisation() {
        return Specialisation;
    }
}
