package ru.gb.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form extends JFrame {
    int a;
    public Form(String title) {
        setTitle(title);
        setBounds(50, 30, 300, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(100, 232,214));

        setLayout(new GridLayout(2, 1));

        JTextField inputField = new JTextField();
        inputField.setEditable(false);

        ButtonListener buttonListener = new ButtonListener(inputField);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 3));

        Font bigFontTR = new Font("TimesRoman", Font.BOLD, 30);

        for (int i = 0; i <= 9; i++) {
            JButton digit = new JButton(String.valueOf(i));
            digit.addActionListener(buttonListener);
            digit.setBackground(Color.CYAN);

            //digit.setBackground(Color.blue);
            digit.setFont(bigFontTR);
            buttonPanel.add(digit);

        }

        JButton plus = new JButton("+");
        plus.setFont(bigFontTR);
        plus.setBackground(Color.CYAN);
        plus.addActionListener(buttonListener);
        JButton minus = new JButton("-");
        minus.setFont(bigFontTR);
        minus.setBackground(Color.CYAN);
        minus.addActionListener(buttonListener);
        JButton multiple = new JButton("*");
        multiple.setFont(bigFontTR);
        multiple.setBackground(Color.CYAN);
        multiple.addActionListener(buttonListener);
        JButton division = new JButton("/");
        division.setFont(bigFontTR);
        division.setBackground(Color.CYAN);
        division.addActionListener(buttonListener);
        JButton clear = new JButton("C");
        clear.setFont(bigFontTR);
        clear.setBackground(Color.CYAN);
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputField.setText("");
            }
        });
        buttonPanel.setForeground(Color.blue);
        buttonPanel.add(plus);
        buttonPanel.add(minus);
        buttonPanel.add(multiple);
        buttonPanel.add(clear);
        buttonPanel.add(division);

        add(buttonPanel);

        JPanel inputPanel = new JPanel(new BorderLayout());
        JButton submit = new JButton("Submit");
        submit.setBackground(Color.CYAN);
        submit.addActionListener(buttonListener);

        inputPanel.add(inputField, BorderLayout.CENTER);
        inputField.setBackground(Color.WHITE);
        inputField.setFont(bigFontTR);
        inputPanel.add(submit, BorderLayout.EAST);

        add(inputPanel);

        setVisible(true);
    }
}
