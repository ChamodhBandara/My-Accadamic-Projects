package com.company;

public class Consultation extends Time_Slot {
    private String Date;
    private String Time;
    private String Notes;
    private double Cost;
    private String Consultation_ID;
    private String patient;
    private String doctorM_L_Number;
     Time_Slot time_slot;

    public String getDoctorM_L_Number() {
        return doctorM_L_Number;
    }

    public void setDoctorM_L_Number(String doctorM_L_Number) {
        this.doctorM_L_Number = doctorM_L_Number;
    }



    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public Time_Slot getTime_slot() {
        return time_slot;
    }

    public void setTime_slot(Time_Slot time_slot) {
        this.time_slot = time_slot;
    }


//    public Consultation(String Consultation_ID, Patient patient, String Notes, String Time, String Date, String d_id){
//        this.Consultation_ID=Consultation_ID;
//        this.patient=patient;
//        this.Cost=Cost;
//        this.Notes=Notes;
//        this.Time=Time;
//        this.Date=Date;
//    }
    public Consultation(String doctorM_L_Number,int time_slot_number){
        this.doctorM_L_Number=doctorM_L_Number;

        this.time_slot=new Time_Slot(time_slot_number,patient);

    }
    // this code duplicate of the real constructor when something gone wrong i will remove this.
    public Consultation(String Consultation_ID, String patientID, String Notes, String Date,String d_id,int time_slot_number,double Cost){
        this.Consultation_ID=Consultation_ID;
        this.patient = patientID;
        this.Notes=Notes;
        this.Date=Date;
        this.doctorM_L_Number=d_id;
        this.time_slot=new Time_Slot(time_slot_number,patient);
        this.Cost=Cost;
    }




    public void setDate(String Date) {
        this.Date=Date;
    }

    public String getDate() {
        return Date;
    }

    public void setTime(String time) {
        this.Time=Time;
    }

    public String getTime() {
        return Time;
    }

    public void setNotes(String Notes) {

        this.Notes = Notes;
    }

    public String getNotes() {

        return Notes;
    }

    public void setCost(double Cost) {

        this.Cost = Cost;
    }

    public double getCost() {

        return Cost;
    }

    public void setConsultation_ID(String consultation_ID) {
        this.Consultation_ID=Consultation_ID;
    }

    public String getConsultation_ID() {
        return Consultation_ID;
    }


}
