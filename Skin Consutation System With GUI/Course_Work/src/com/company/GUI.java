package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class GUI extends JFrame {


    public GUI() {


        PNL_background = new JPanel();
        Lbl1 = new JLabel();
        Lbl2 = new JLabel();
        Lbl3 = new JLabel();
        Lbl4 = new JLabel();
        Lbl5 = new JLabel();
        Doctor_Details = new JButton();
        Patient_Details = new JButton();
        Consultation_Details = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        PNL_background.setBackground(new Color(102, 255, 255));
        PNL_background.setLayout(null);

        Lbl1.setBackground(new Color(255, 102, 102));
        Lbl1.setForeground(new Color(51, 51, 51));
        Lbl1.setHorizontalAlignment(SwingConstants.CENTER);
        Lbl1.setText("WESTMINSTER  SKIN CONSULTTATION MANAGER");
        Lbl1.setOpaque(true);
        PNL_background.add(Lbl1);
        Lbl1.setBounds(0, 0, 790, 50);

        Lbl2.setBackground(new Color(0, 51, 255));
        Lbl2.setForeground(new Color(102, 255, 204));
        Lbl2.setHorizontalAlignment(SwingConstants.CENTER);
        Lbl2.setText("DOCTOR");
        Lbl2.setHorizontalTextPosition(SwingConstants.CENTER);
        Lbl2.setOpaque(true);
        Lbl2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                Doctors d = new Doctors();
                d.setVisible(true);
                dispose();
            }
        });
        PNL_background.add(Lbl2);
        Lbl2.setBounds(20, 190, 120, 80);

        Lbl3.setBackground(new Color(0, 51, 255));
        Lbl3.setForeground(new Color(102, 255, 204));
        Lbl3.setHorizontalAlignment(SwingConstants.CENTER);
        Lbl3.setText("PATIENT");
        Lbl3.setOpaque(true);
        Lbl3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                PATIENTS p = new PATIENTS();
                p.setVisible(true);
                dispose();
            }
        });
        PNL_background.add(Lbl3);
        Lbl3.setBounds(300, 190, 120, 80);

        Lbl4.setBackground(new Color(0, 51, 255));
        Lbl4.setForeground(new Color(102, 255, 204));
        Lbl4.setHorizontalAlignment(SwingConstants.CENTER);
        Lbl4.setText("CONSULTATION");
        Lbl4.setOpaque(true);
        Lbl4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                Consultations c = new Consultations();
                c.setVisible(true);
                dispose();
            }
        });
        PNL_background.add(Lbl4);
        Lbl4.setBounds(650, 190, 120, 80);

        Lbl5.setBackground(new Color(255, 51, 51));
        Lbl5.setForeground(new Color(51, 51, 51));
        Lbl5.setHorizontalAlignment(SwingConstants.CENTER);
        Lbl5.setText("EXIT");
        Lbl5.setOpaque(true);
        Lbl5.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                System.exit(0);
            }
        });
        PNL_background.add(Lbl5);
        Lbl5.setBounds(667, 336, 90, 60);

        Doctor_Details.setText("Doctor Details");
        Doctor_Details.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Doctor_Details dd = new Doctor_Details();
                dd.show();
                dd.add_doc_details();
                dispose();
            }
        });
        PNL_background.add(Doctor_Details);
        Doctor_Details.setBounds(40, 360, 120, 23);

        Patient_Details.setText("Patient Details");
        Patient_Details.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Patient_Details pd = new Patient_Details();
                pd.show();
                pd.add_pat_details();
                dispose();
            }
        });
        PNL_background.add(Patient_Details);
        Patient_Details.setBounds(270, 360, 110, 23);

        Consultation_Details.setText("Consultation_Details");
        Consultation_Details.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
              Consultation_Details cd=new Consultation_Details();
              cd.Cons_Details();
              cd.show();
              dispose();

            }
        });
        PNL_background.add(Consultation_Details);
        Consultation_Details.setBounds(470, 360, 150, 23);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(PNL_background, GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(PNL_background, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }







    private JButton Doctor_Details;
    private JButton Patient_Details;
    private JButton Consultation_Details;
    private JLabel Lbl1;
    private JLabel Lbl2;
    private JLabel Lbl3;
    private JLabel Lbl4;
    private JLabel Lbl5;
    private JPanel PNL_background;

}
