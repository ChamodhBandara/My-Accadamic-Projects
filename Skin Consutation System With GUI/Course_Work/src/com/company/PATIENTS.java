package com.company;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.company.WestminsterConsultationManager.patient;

public class PATIENTS extends JFrame {
    private JButton Btn_Add;
    private JButton Btn_Back;
    private JLabel Lbl1;
    private JLabel Lbl2;
    private JLabel Lbl3;
    private JLabel Lbl4;
    private JLabel Lbl5;
    private JLabel Lbl6;
    private JPanel PNL1;
    private JTextField TxtFld1;
    private JTextField TxtFld2;
    private JTextField TxtFld3;
    private JTextField TxtFld4;
    private JTextField TxtFld5;


    public PATIENTS() {







        PNL1 = new JPanel();
        Lbl1 = new JLabel();
        Lbl2 = new JLabel();
        TxtFld1 = new JTextField();
        Lbl3 = new JLabel();
        TxtFld2 = new JTextField();
        Lbl4 = new JLabel();
        TxtFld3 = new JTextField();
        Lbl5 = new JLabel();
        TxtFld4 = new JTextField();
        Lbl6 = new JLabel();
        TxtFld5 = new JTextField();
        Btn_Add = new JButton();
        Btn_Back = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        PNL1.setBackground(new Color(51, 255, 51));

        Lbl1.setBackground(new Color(0, 255, 255));
        Lbl1.setForeground(new Color(0, 0, 0));
        Lbl1.setHorizontalAlignment(SwingConstants.CENTER);
        Lbl1.setText("PATIENT ");
        Lbl1.setOpaque(true);

        Lbl2.setText("PATIENT NAME:");

        Lbl3.setText("PATIENT SUR NAME:");

        Lbl4.setText("PATIENT DATE OF BIRTH:");

        Lbl5.setText("PATIENT ID:");

        Lbl6.setText("MOBILE NUMBER:");

        Btn_Add.setText("ADD");
        Btn_Add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ad_patient();
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
                        .addComponent(Lbl1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PNL1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(PNL1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(Lbl6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Lbl5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Lbl4, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                        .addComponent(Lbl3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Lbl2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PNL1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(TxtFld1)
                                        .addComponent(TxtFld2)
                                        .addComponent(TxtFld3)
                                        .addComponent(TxtFld4)
                                        .addComponent(TxtFld5, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
                                .addContainerGap(326, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, PNL1Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Btn_Back)
                                .addGap(53, 53, 53)
                                .addComponent(Btn_Add)
                                .addGap(71, 71, 71))
        );
        PNL1Layout.setVerticalGroup(
                PNL1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(PNL1Layout.createSequentialGroup()
                                .addComponent(Lbl1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(PNL1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(Lbl2, GroupLayout.PREFERRED_SIZE, 31,GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TxtFld1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(PNL1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(Lbl3, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TxtFld2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(PNL1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(Lbl4, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TxtFld3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(PNL1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(Lbl5, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TxtFld4, GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(PNL1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(Lbl6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TxtFld5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                                .addComponent(Btn_Add)
                                .addGap(19, 19, 19))
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





    public void ad_patient(){
        Patient a_p=new Patient();
        a_p.setName(TxtFld1.getText());
        a_p.setSur_name(TxtFld2.getText());
        a_p.setDate_of_birth(TxtFld3.getText());
        a_p.setPatient_ID(TxtFld4.getText());
        a_p.setMobile_number(Integer.parseInt(TxtFld5.getText()));
        patient.add(a_p);
    }
}