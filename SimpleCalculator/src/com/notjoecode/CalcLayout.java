package com.notjoecode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalcLayout implements ActionListener {


    private ButtonDo b = new ButtonDo();

    private String result;
    private JLabel resultText;

    public JPanel panelMain;

    private JButton zeroButton;
    private JButton oneButton;
    private JButton twoButton;
    private JButton threeButton;
    private JButton fourButton;
    private JButton fiveButton;
    private JButton sixButton;
    private JButton sevenButton;
    private JButton eightButton;
    private JButton nineButton;

    private JButton decimalButton;
    private JButton divideButton;
    private JButton timesButton;
    private JButton minusButton;
    private JButton plusButton;
    private JButton equalsButton;
    private JButton negativePositiveButton;

    private JButton saveButton;
    private JButton lastButton;
    private JButton clearButton;
    private JPanel jpanel;



    public CalcLayout() {

        resultText.setHorizontalAlignment(SwingConstants.RIGHT);
        resultText.setFont(new FontGetter().newFont());
        resultText.setForeground(Color.BLACK);

        zeroButton.setActionCommand("0Button");
        zeroButton.addActionListener(this);
        oneButton.setActionCommand("1Button");
        oneButton.addActionListener(this);
        twoButton.setActionCommand("2Button");
        twoButton.addActionListener(this);
        threeButton.setActionCommand("3Button");
        threeButton.addActionListener(this);
        fourButton.setActionCommand("4Button");
        fourButton.addActionListener(this);
        fiveButton.setActionCommand("5Button");
        fiveButton.addActionListener(this);
        sixButton.setActionCommand("6Button");
        sixButton.addActionListener(this);
        sevenButton.setActionCommand("7Button");
        sevenButton.addActionListener(this);
        eightButton.setActionCommand("8Button");
        eightButton.addActionListener(this);
        nineButton.setActionCommand("9Button");
        nineButton.addActionListener(this);

        decimalButton.setActionCommand("decimalButton");
        decimalButton.addActionListener(this);
        divideButton.setActionCommand("divideButton");
        divideButton.addActionListener(this);
        timesButton.setActionCommand("timesButton");
        timesButton.addActionListener(this);
        minusButton.setActionCommand("minusButton");
        minusButton.addActionListener(this);
        plusButton.setActionCommand("plusButton");
        plusButton.addActionListener(this);
        equalsButton.setActionCommand("equalsButton");
        equalsButton.addActionListener(this);
        negativePositiveButton.setActionCommand("negativePositiveButton");
        negativePositiveButton.addActionListener(this);

        saveButton.setActionCommand("saveButton");
        saveButton.addActionListener(this);
        lastButton.setActionCommand("lastButton");
        lastButton.addActionListener(this);
        clearButton.setActionCommand("clearButton");
        clearButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "1Button":
            case "2Button":
            case "3Button":
            case "4Button":
            case "5Button":
            case "6Button":
            case "7Button":
            case "8Button":
            case "9Button":
            case "0Button":
                result = b.numberButton(e.getActionCommand());
                break;

            case "negativePositiveButton":
                result = b.negButton();
                break;

            case "plusButton":
            case "minusButton":
            case "timesButton":
            case "divideButton":
            case "equalsButton":
                result = b.mathsButton(e.getActionCommand());
                break;

//            case "saveButton":
//                result = b.saveButton();
//                break;
//
//            case "lastButton":
//                result = b.lastButton();
//                break;

            case "clearButton":
                result = b.clearButton();
                break;

            case "decimalButton":
                result = b.decimalButton();
                break;
            default:
                break;
        }

        resultText.setText(result);

    }
}

