package com.notjoecode;

public class MathsButton {

    private boolean newNum, tempInUse, plus, minus, times, divide, dec;
    private double temp, x, last, zerosPressed;
    private String checkDec;

    public MathsButton(String s){


    }

    public double mathsButton(String s){

        if(!newNum) {
            if (temp == 0) {
                //TODO double check this case...might need to be !tempInUse
                temp = x;
                tempInUse = true;
                x = 0;
            } else if (plus) {
                temp += x;
                plus = false;
            } else if (minus) {
                temp -= x;
                minus = false;
            } else if (times) {
                temp *= x;
                times = false;
            } else if (divide) {
                temp /= x;
                divide = false;
            } else {
                temp = x;
            }
        }
        getMaths(s);
        //x=0;
        x = temp;
        last = temp;

        newNum = true;

        return temp;
    }


    private void getMaths(String s){
        dec = false;
        plus = false;
        minus = false;
        times = false;
        divide = false;
        switch (s) {
            case "plusButton":
                plus = true;
                break;
            case "minusButton":
                minus = true;
                break;
            case "timesButton":
                times = true;
                break;
            case "divideButton":
                divide = true;
                break;
            case "equalsButton":
                tempInUse = false;
                newNum = true;
                zerosPressed = 0;
                break;
            default: break;
        }
    }


}
