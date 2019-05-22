package com.notjoecode;

import java.text.DecimalFormat;

public class OtherButton {
    boolean tempInUse, newNum,plus,minus,times,divide,dec;
    double temp,last,x, zerosPressed, save;
    String checkDec;

    private DecimalFormat df = new DecimalFormat("#.###########");


    public String saveButton(){
        if(!tempInUse){
            save = Double.parseDouble(checkDec);
            return checkDec;
        }
        else{
            return fmt(save);
        }
    }

    public String lastButton() {
        clearButton();
        newNum = false;
        temp = last;
        x = last;
        return  fmt(last);
    }


    public String clearButton(){
        x = 0;
        plus = false;
        minus = false;
        times = false;
        divide = false;
        dec = false;
        tempInUse = false;
        temp = 0;
        zerosPressed = 0;


        checkDec = fmt(x);
        return checkDec;
    }
    private String fmt(double d){
        String s;
        double tempD = zerosPressed;

        if(checkDec.contains(".")) {
            while (tempD != 0) {
                //s = checkDec + "0";
                tempD--;
            }
            //s = String.format("%f", d);
        }

        s = df.format(d);

        return s;
    }

}
