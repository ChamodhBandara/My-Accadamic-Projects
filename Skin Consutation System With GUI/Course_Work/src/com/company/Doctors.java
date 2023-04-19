package com.company;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static com.company.WestminsterConsultationManager.doctors;

public class Doctors extends JFrame {
    private JButton Btn1;
    private javax.swing.JButton Btn_Back;
    private JLabel Lbl1;
    private JLabel Lbl2;
    private JLabel Lbl3;
    private JLabel Lbl4;
    private JLabel Lbl5;
    private JLabel Lbl6;
    private JLabel Lbl7;
    private JPanel PNL1;
    private JTextField TxtFld1;
    private JTextField TxtFld2;
    private JTextField TxtFld3;
    private JTextField TxtFld4;
    private JTextField TxtFld5;
    private JTextField TxtFld6;


    public Doctors() {





        Btn_Back = new JButton();

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
        Lbl7 = new JLabel();
        TxtFld6 = new JTextField();
        Btn1 = new JButton();
        //Btn2 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(51, 255, 255));
        setResizable(false);

        PNL1.setBackground(new Color(102, 255, 255));

        Lbl1.setHorizontalAlignment(SwingConstants.CENTER);
        Lbl1.setText("DOCTOR INFORMATIONS.");

        Lbl2.setText("DOCTOR NAME :");
        Lbl2.setHorizontalTextPosition(SwingConstants.CENTER);



        Lbl3.setText("DOCTOR SUR NAME:");

        Lbl4.setText("MEDICAL LICENCE NUMBER:");



        Lbl5.setText("DOCTOR CONTACT NUMBER:");

        Lbl6.setText("SPECIALISATION:");

        Lbl7.setText("DOCTOR DATE OF BIRTH :");

        Btn1.setText("ADD");
        Btn1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                String s1=TxtFld1.getText();
                System.out.println(s1);
            }
        });
        Btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ad_doc();
            }
        });
        Btn_Back.setText("Back");
        Btn_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
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
                                .addGroup(PNL1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(PNL1Layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addGroup(PNL1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(Lbl3, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(Lbl2, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(PNL1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(PNL1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(PNL1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(Lbl4, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(Lbl5, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(Lbl6, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(PNL1Layout.createSequentialGroup()
                                                                .addGap(6, 6, 6)
                                                                .addComponent(Lbl7, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PNL1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(TxtFld1, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TxtFld3, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TxtFld4, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TxtFld5, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(PNL1Layout.createSequentialGroup()
                                .addGap(241, 241, 241)
                                .addGroup(PNL1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(TxtFld6, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TxtFld2, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
                                .addComponent(Btn_Back)
                                .addGap(53, 53, 53)
                                .addComponent(Btn1)
                                .addGap(77, 77, 77))
        );
        PNL1Layout.setVerticalGroup(
                PNL1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(PNL1Layout.createSequentialGroup()
                                .addComponent(Lbl1, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PNL1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(Lbl2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TxtFld1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(PNL1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(TxtFld2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Lbl3, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(PNL1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(Lbl4, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TxtFld3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(PNL1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(Lbl5, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TxtFld4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(PNL1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(TxtFld5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Lbl6, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PNL1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(Lbl7, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TxtFld6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addComponent(Btn1)
                                .addContainerGap())
                        .addComponent(Btn_Back)
                        .addGap(53, 53, 53)
        );

       GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(PNL1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(PNL1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
    }







    public void ad_doc(){
       Doctor wcm=new Doctor();
       wcm.setName(TxtFld1.getText());
       wcm.setSur_name(TxtFld2.getText());
       wcm.setMedical_licence_number(TxtFld3.getText());
       wcm.setMobile_number(Integer.parseInt(TxtFld4.getText()));
       wcm.setSpecialisation(TxtFld5.getText());
       wcm.setDate_of_birth(TxtFld6.getText());
       doctors.add(wcm);


    }
}
