package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.company.WestminsterConsultationManager.doctors;
import static com.company.WestminsterConsultationManager.patient;

public class Patient_Details extends JFrame {
    private JLabel Lbl1;
    private JButton Btn_Back;
    private JPanel PNL1;
    private JScrollPane ScrlPne;
    private JTable Tbl1;

    public Patient_Details() {





        PNL1 = new JPanel();
        Lbl1 = new JLabel();
        ScrlPne = new JScrollPane();
        Tbl1 = new JTable();
        Btn_Back = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Lbl1.setBackground(new Color(51, 204, 255));
        Lbl1.setForeground(new Color(0, 0, 0));
        Lbl1.setHorizontalAlignment(SwingConstants.CENTER);
        Lbl1.setText("ADDED PATIENT DETAILS");
        Lbl1.setOpaque(true);

        Tbl1.setModel(new DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "P_Name", "P_S_Name", "P_D_O_B", "P_ID", "P_Con_Number"
                }
        ));
        ScrlPne.setViewportView(Tbl1);

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
                        .addComponent(Lbl1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PNL1Layout.createSequentialGroup()
                                .addComponent(ScrlPne, GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Btn_Back))
        );
        PNL1Layout.setVerticalGroup(
                PNL1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(PNL1Layout.createSequentialGroup()
                                .addComponent(Lbl1, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(PNL1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, PNL1Layout.createSequentialGroup()
                                                .addComponent(ScrlPne, GroupLayout.PREFERRED_SIZE, 427, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())
                                        .addGroup(GroupLayout.Alignment.TRAILING, PNL1Layout.createSequentialGroup()
                                                .addComponent(Btn_Back)
                                                .addGap(44, 44, 44))))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(PNL1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(PNL1, GroupLayout.PREFERRED_SIZE, 463, GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }




    public void add_pat_details(){
        DefaultTableModel a_p_d=(DefaultTableModel) Tbl1.getModel();
        Object arp[]=new Object[6];
        for(Patient ad:patient){
            arp[0]=ad.getName();
            arp[1]=ad.getSur_name();
            arp[2]=ad.getDate_of_birth();
            arp[3]=ad.getPatient_ID();
            arp[4]=ad.getMobile_number();
            arp[5]=ad.getMobile_number();
            a_p_d.addRow(arp);

        }
    }
}
