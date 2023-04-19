package com.company;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.company.WestminsterConsultationManager.doctors;

public  class Doctor_Details extends JFrame {
    private JLabel Lbl1;
    private JPanel PNL1;
    private JScrollPane ScrlPne1;
    private JTable Tbl;
    private javax.swing.JButton Btn_Back;


        public Doctor_Details() {



            Btn_Back = new JButton();
            PNL1 = new JPanel();
            Lbl1 = new JLabel();
            ScrlPne1 = new JScrollPane();
            Tbl = new JTable();

            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setResizable(false);

            PNL1.setBackground(new Color(255, 255, 255));

            Lbl1.setBackground(new Color(255, 102, 255));
            Lbl1.setForeground(new Color(0, 0, 0));
            Lbl1.setHorizontalAlignment(SwingConstants.CENTER);
            Lbl1.setText("ADDED DOCTOR DETAILS");
            Lbl1.setOpaque(true);

            Tbl.setModel(new DefaultTableModel(
                    new Object [][] {
                            },
                    new String [] {
                            "D_Name", "D_S_Name", "D_DOB", "D_M_L_Number", "D_Con_Number", "D_Specialisation"
                    }
            ));
            ScrlPne1.setViewportView(Tbl);
            Btn_Back.setText("Back");
            Btn_Back.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    GUI gui = new GUI();
                    gui.show();

                    dispose();
                }
            });

           GroupLayout jPanel1Layout = new GroupLayout(PNL1);
            PNL1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(Lbl1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ScrlPne1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
                            .addComponent(Btn_Back)

            );
            jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(Lbl1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ScrlPne1,GroupLayout.PREFERRED_SIZE, 436, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Btn_Back)
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
                            .addComponent(PNL1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            pack();
        }




        public void add_doc_details(){
            DefaultTableModel a_d_d=(DefaultTableModel) Tbl.getModel();
            Object ard[]=new Object[6];
            for(Doctor ad:doctors){
                ard[0]=ad.getName();
                ard[1]=ad.getSur_name();
                ard[2]=ad.getDate_of_birth();
                ard[3]=ad.getMedical_licence_number();
                ard[4]=ad.getMobile_number();
                ard[5]=ad.getSpecialisation();
                a_d_d.addRow(ard);

            }
        }
}
