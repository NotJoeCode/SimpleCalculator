package com.notjoecode;

public class NumberButton {

    private boolean newNum, dec;
    private double x, decPlace, zerosPressed;
    private String checkDec;

    public NumberButton (String s){
        numberButton(s);
    }

    public double numberButton(String s) {
        double num = Double.parseDouble(s.replaceAll("\\D+", ""));
        if (newNum) {
            x = num;
            newNum = false;
        } else {
            if (!dec) {
                x = (x * 10) + num;
            } else if (num != 0) {
                setDecPlace();
                x += (num / decPlace);
            } else {
                checkDec = checkDec + "0";
                zerosPressed++;
                //TODO
            }

        }
        return x;
    }

    private void setDecPlace() {

        String s = checkDec;
        if (s.contains(".")) {
            String[] result = s.split("\\.");
            if (result[1].equals(" ")) {
                decPlace = 10;
            } else {

                decPlace = Math.pow(10, result[1].length() + zerosPressed + 1);
            }
        }
        else{
            decPlace = 10;
        }
    }
}
