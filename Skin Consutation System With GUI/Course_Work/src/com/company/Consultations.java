package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.company.WestminsterConsultationManager.*;

public class Consultations extends JFrame {
    private javax.swing.JButton Btn_Back;
    private JButton BTN1;
    private JLabel LBL1;
    private JLabel LBL2;
    private JLabel LBL3;
    private JLabel LBL4;
    private JLabel LBL5;
    private JLabel LBL6;
    private JLabel LBL7;
    private JLabel LBL8;
    private JPanel PNL1;
    private JTextField TxtFld1;
    private JTextField TxtFld2;
    private JTextField TxtFld3;
    private JTextField TxtFld4;
    private JTextField TxtFld5;
    private JTextField TxtFld6;
    private JTextField TxtFld7;


    public Consultations() {



        Btn_Back = new JButton();
        PNL1 = new JPanel();
        TxtFld4 = new JTextField();
        LBL1 = new JLabel();
        TxtFld1 = new JTextField();
        LBL5 = new JLabel();
        LBL4 = new JLabel();
        TxtFld3 = new JTextField();
        LBL3 = new JLabel();
        LBL6 = new JLabel();
        LBL2 = new JLabel();
        TxtFld2 = new JTextField();
        TxtFld5 = new JTextField();
        LBL7 = new JLabel();
        TxtFld6 = new JTextField();
        LBL8 = new JLabel();
        TxtFld7 = new JTextField();
        BTN1 = new JButton();


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(51, 204, 255));
        setResizable(false);

        PNL1.setBackground(new Color(51, 255, 255));



        LBL1.setBackground(new Color(255, 102, 102));
        LBL1.setForeground(new Color(0, 0, 0));
        LBL1.setHorizontalAlignment(SwingConstants.CENTER);
        LBL1.setText("CONSULTATION");
        LBL1.setOpaque(true);



        LBL5.setForeground(new Color(0, 0, 0));
        LBL5.setText("CONSULTATION_DATE: ");

        LBL4.setForeground(new Color(0, 0, 0));
        LBL4.setText("CONSULTATION_ID:");

        LBL3.setForeground(new Color(0, 0, 0));
        LBL3.setText("PATIENT NAME:");

        LBL6.setForeground(new Color(0, 0, 0));
        LBL6.setText("TIME SLOT");

        LBL2.setForeground(new Color(0, 0, 0));
        LBL2.setText("DOCTOR NAME :");




        LBL7.setForeground(new Color(0, 0, 0));
        LBL7.setText("COST");

        LBL8.setForeground(new Color(0, 0, 0));
        LBL8.setText("NOTES");



        BTN1.setText("ADD");
        BTN1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addConsultation();
            }
        });
        Btn_Back.setText("Back");
        Btn_Back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                GUI gui = new GUI();
                gui.show();

                dispose();
            }
        });

        GroupLayout PNL1Layout = new GroupLayout(PNL1);
        PNL1.setLayout(PNL1Layout);
        PNL1Layout.setHorizontalGroup(
                PNL1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, PNL1Layout.createSequentialGroup()
                                .addContainerGap(558, Short.MAX_VALUE)
                                .addComponent(Btn_Back)
                                .addComponent(BTN1)
                                .addGap(409, 409, 409))
                        .addGroup(PNL1Layout.createSequentialGroup()
                                .addGroup(PNL1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(PNL1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(PNL1Layout.createSequentialGroup()
                                                        .addGap(224, 224, 224)
                                                        .addComponent(TxtFld2, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(PNL1Layout.createSequentialGroup()
                                                        .addGap(203, 203, 203)
                                                        .addComponent(TxtFld5, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(PNL1Layout.createSequentialGroup()
                                                        .addGap(195, 195, 195)
                                                        .addGroup(PNL1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(TxtFld6, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(PNL1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(TxtFld4, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(TxtFld3, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(TxtFld7, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(GroupLayout.Alignment.LEADING, PNL1Layout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addGroup(PNL1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(PNL1Layout.createSequentialGroup()
                                                                .addComponent(LBL2, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(TxtFld1, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(PNL1Layout.createSequentialGroup()
                                                                .addGroup(PNL1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(LBL3, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(LBL4, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(LBL5)
                                                                        .addGroup(PNL1Layout.createSequentialGroup()
                                                                                .addGap(6, 6, 6)
                                                                                .addGroup(PNL1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(LBL6)
                                                                                        .addGroup(PNL1Layout.createSequentialGroup()
                                                                                                .addGap(6, 6, 6)
                                                                                                .addGroup(PNL1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                                                        .addComponent(LBL8)
                                                                                                        .addComponent(LBL7, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))))))
                                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(PNL1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(LBL1, GroupLayout.DEFAULT_SIZE, 1039, Short.MAX_VALUE))
        );
        PNL1Layout.setVerticalGroup(
                PNL1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, PNL1Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addGroup(PNL1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(PNL1Layout.createSequentialGroup()
                                                .addGroup(PNL1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(PNL1Layout.createSequentialGroup()
                                                                .addGroup(PNL1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(PNL1Layout.createSequentialGroup()
                                                                                .addGroup(PNL1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(TxtFld1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(LBL2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                                                                                .addGap(34, 34, 34)
                                                                                .addComponent(TxtFld2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(LBL3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(PNL1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(TxtFld3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(LBL4, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(PNL1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(TxtFld4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(LBL5, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(TxtFld5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(LBL6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(PNL1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(TxtFld6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(LBL7, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
                                                .addGap(27, 27, 27)
                                                .addComponent(TxtFld7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(LBL8, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                                .addComponent(BTN1)
                                .addGap(14, 14, 14))
                        .addComponent(Btn_Back)
                        .addGroup(PNL1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(PNL1Layout.createSequentialGroup()
                                        .addComponent(LBL1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(476, Short.MAX_VALUE)))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(PNL1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(PNL1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }









    public void addConsultation() {

        String Date = TxtFld4.getText();
        String DLic = TxtFld1.getText();
        String PId = TxtFld2.getText();
        String ConId = TxtFld3.getText();
        int timeSlotNumber = Integer.parseInt(TxtFld5.getText());
        String Note =TxtFld7.getText();
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
        TxtFld6.setText("Your Cost "+cost);
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
                consultation.add(new Consultation(ConId, PId,Note, Date,availableDoctor.get(index).getMedical_licence_number(), timeSlotNumber,cost));
                System.out.println("Successfully added the Consultation");
            } else {
                System.out.println("There are no available doctors for the given time slot on the given date.");
            }
        } else {
            // If the chosen doctor is available, add the consultation with the chosen doctor
            consultation.add(new Consultation(ConId, PId,Note, Date,DLic, timeSlotNumber,cost));
            System.out.println("Successfully added the Consultation");
        }
    }

}

