package com.company;

import java.time.LocalTime;

public class Time_Slot {

    private String patient_ID;
    private String Start_Time;
    private String End_Time;
    private int time_slot_id;
    private boolean result;





    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }


    public Time_Slot(String patient_ID,String Start_Time,String End_Time,int time_slot_id){

        this.patient_ID=patient_ID;
        this.Start_Time=Start_Time;
        this.End_Time=End_Time;
        this.time_slot_id=time_slot_id;

    }
    public Time_Slot(String patient_ID,int number){

        this.patient_ID=patient_ID;
        this.time_slot_id=number;
    }
    public Time_Slot(){

    }
    public Time_Slot(int time_slot_id,String patient_ID){
        this.time_slot_id=time_slot_id;
        this.patient_ID=patient_ID;
        this.result=true;
        switch (time_slot_id)
        {
            case 1 -> {
                this.Start_Time = String.valueOf(LocalTime.of(8, 0));
                this.End_Time = String.valueOf(LocalTime.of(9,0));
            }
            case 2 -> {
                this.Start_Time = String.valueOf(LocalTime.of(9, 0));
                this.End_Time = String.valueOf(LocalTime.of(10,0));
            }
            case 3 -> {
                this.Start_Time = String.valueOf(LocalTime.of(10, 0));
                this.End_Time = String.valueOf(LocalTime.of(11,0));
            }
            case 4 -> {
                this.Start_Time = String.valueOf(LocalTime.of(13, 0));
                this.End_Time = String.valueOf(LocalTime.of(14,0));
            }
            case 5 -> {
                this.Start_Time = String.valueOf(LocalTime.of(14, 0));
                this.End_Time = String.valueOf(LocalTime.of(15,0));
            }
            case 6 -> {
                this.Start_Time = String.valueOf(LocalTime.of(15, 0));
                this.End_Time = String.valueOf(LocalTime.of(16,0));
            }
            case 7 -> {
                this.Start_Time = String.valueOf(LocalTime.of(16, 0));
                this.End_Time = String.valueOf(LocalTime.of(17,0));
            }
            case 8 -> {
                this.Start_Time = String.valueOf(LocalTime.of(18, 0));
                this.End_Time = String.valueOf(LocalTime.of(19,0));
            }
            case 9 -> {
                this.Start_Time = String.valueOf(LocalTime.of(19, 0));
                this.End_Time = String.valueOf(LocalTime.of(20,0));
            }
            case 10 -> {
                this.Start_Time = String.valueOf(LocalTime.of(20, 0));
                this.End_Time = String.valueOf(LocalTime.of(21,0));
            }
        }
    }



    public void setPatient_ID(String patient_ID) {
        this.patient_ID = patient_ID;
    }

    public String getPatient_ID() {
        return patient_ID;
    }

    public void setStart_Time(String start_Time) {
        this.Start_Time = Start_Time;
    }

    public String getStart_Time() {
        return Start_Time;
    }
    public void setEnd_Time(String end_Time){
        this.End_Time=End_Time;
    }
    public String getEnd_Time(){
        return End_Time;
    }
    public int getTime_slot_id(){return time_slot_id;}

    public void setTime_slot_id(int time_slot_id) {
        this.time_slot_id = time_slot_id;
    }
}
