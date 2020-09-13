package ru.gb.lesson8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    private final JTextField inputField;

    private String strAll = "";
    private String strAdd;
    private double result;
    private double num;
    private int act;
    //    private final StringBuilder sb = new StringBuilder();

    public ButtonListener(JTextField inputField) {
        this.inputField = inputField;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        strAdd = jButton.getText();
        if (strAdd.charAt(0) >= '0' && strAdd.charAt(0) <= '9' ) {
            strAll += strAdd;
            inputField.setText(strAll);
        }else if (strAdd.charAt(0) == '+') {
            plus(strAll);
        }else if (strAdd.endsWith("mit")) {
            calculation();
            strAll = "";
        }else if (strAdd.charAt(0) == '-') {
            minus(strAll);
        }else if (strAdd.charAt(0) == '*') {
            multiple(strAll);
        }else
            division(strAll);
    }

    public void calculation() {
        switch (act) {
            case 1:
                result = num + Double.parseDouble(strAll);
                inputField.setText(String.valueOf(result));
                break;
            case 2:
                result = num - Double.parseDouble(strAll);
                inputField.setText(String.valueOf(result));
                break;
            case 3:
                result = num * Double.parseDouble(strAll);
                inputField.setText(String.valueOf(result));
                break;
            case 4:
                result = num / Double.parseDouble(strAll);
                inputField.setText(String.valueOf(result));
                break;
        }
    }

    public void plus(String all) {
        num = Double.parseDouble(all);
        act = 1;
        inputField.setText("");
        strAll = "";
    }

    public void minus(String all) {
        num = Double.parseDouble(strAll);
        act = 2;
        inputField.setText("");
        strAll = "";
    }

    public void multiple(String all) {
        num = Double.parseDouble(strAll);
        act = 3;
        inputField.setText("");
        strAll = "";
    }

    public void division(String all) {
        num = Double.parseDouble(strAll);
        act = 4;
        inputField.setText("");
        strAll = "";
    }
}
