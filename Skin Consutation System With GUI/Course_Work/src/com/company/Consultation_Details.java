package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.company.WestminsterConsultationManager.consultation;
import static com.company.WestminsterConsultationManager.doctors;

public class Consultation_Details extends JFrame {
    private JLabel Lbl1;
    private JPanel PNL1;
    private JScrollPane ScrlPne;
    private JTable Tbl1;
    private JButton Btn_Back;


    public Consultation_Details() {


        PNL1 = new JPanel();
        Lbl1 = new JLabel();
        ScrlPne = new JScrollPane();
        Tbl1 = new JTable();
        Btn_Back = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Lbl1.setBackground(new Color(255, 51, 255));
        Lbl1.setForeground(new Color(0, 0, 0));
        Lbl1.setHorizontalAlignment(SwingConstants.CENTER);
        Lbl1.setText("CONSULTATION_DETAILS");
        Lbl1.setOpaque(true);

        Tbl1.setModel(new DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "D_L_C_Number", "P_ID", "Consultation_ID", "Time_Slot", "Cost", "Notes"
                }
        ));
        Btn_Back.setText("Back");
        Btn_Back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                GUI gui = new GUI();
                gui.show();

                dispose();
            }
        });
        ScrlPne.setViewportView(Tbl1);

        GroupLayout PNL1Layout = new GroupLayout(PNL1);
        PNL1.setLayout(PNL1Layout);
        PNL1Layout.setHorizontalGroup(
                PNL1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(Lbl1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ScrlPne, GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                        .addComponent(Btn_Back)
                        .addGap(53, 53, 53)
        );
        PNL1Layout.setVerticalGroup(
                PNL1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(PNL1Layout.createSequentialGroup()
                                .addComponent(Lbl1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ScrlPne, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)).addComponent(Btn_Back)
                        .addGap(53, 53, 53)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(PNL1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(PNL1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
    public void Cons_Details(){
        DefaultTableModel a_d_c_d=(DefaultTableModel) Tbl1.getModel();
        Object acd[]=new Object[6];
        for(Consultation cons:consultation){
            acd[0]=cons.getDoctorM_L_Number();
            acd[1]=cons.time_slot.getPatient_ID();
            acd[2]=cons.getConsultation_ID();
            acd[3]=cons.time_slot.getTime_slot_id();
            acd[4]=cons.getCost();
            acd[5]=cons.getNotes();
            a_d_c_d.addRow(acd);

        }
    }
}

