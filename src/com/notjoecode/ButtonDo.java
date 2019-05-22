package com.notjoecode;

import java.text.DecimalFormat;

public class ButtonDo {

    /*

      x is going to be the user entered input.
            this should only be set by the numberButton function
      temp is the saved value that is being math upon
            this should only be set by the mathButtons function
      save is a user saved value
            this should only be handled by the saveButton function
      last is for the a user to reset if a button is mistakenly pressed.
            it is set everywhere but calling this number is reserved for the lastButton function
      plus, minus, times, and divide are all set to allow proper flow for doing math in the mathButton function
      dec sets whether or not our value already contains a decimal point as to not create 2 decimals in a number
      tempInUse lets us know if there is already a saved number to be math with.
      newNum checks if we are adding additional decimal places to an existing number or creating a new one to math with
      checkDec is used to find out how many decimal places are currently being used

    */


    //TODO saveButton
    //TODO set Max Value to display
    //TODO (negButton) case if equals pressed post math buttons not working


    //private double save, last;
    private double x, temp, decPlace, zerosPressed;
    private boolean plus, minus, times, divide, dec, tempInUse, newNum;
    private String checkDec = "";
    private DecimalFormat df = new DecimalFormat("#.###########");


    public String numberButton(String s) {
        double num = Double.parseDouble(s.replaceAll("\\D+", ""));
        if (newNum && !dec) {
            x = num;
            newNum = false;

        } else if (!dec) {

            if(x >= 0)
                x = (x * 10) + num;
            else
                x = (x * 10) - num;

        } else if (num != 0) {
            setDecPlace();
            newNum = false;

            if(x >= 0)
                x += (num / decPlace);
            else
                x -= (num/ decPlace);

        } else {

                setDecPlace();
                checkDec = checkDec.replaceAll("\\s+", "") + "0";
                //zerosPressed++;
                setDecPlace();
                newNum = false;

                return checkDec;
            }


        checkDec = fmt(x);
        return checkDec;
    }

    public String negButton() {
//        if (tempInUse) {
//            if (plus) {
//                temp += x;
//            } else if (minus) {
//                temp -= x;
//            } else if (times) {
//                temp *= x;
//            } else if (divide) {
//                temp /= x;
//            }
//            temp *= -1;
//            x = temp;
//            tempInUse = false;
//            checkDec = fmt(temp);
//            return checkDec;
//        } else {
//            x *= -1;
//            temp = x;
//            checkDec = fmt(x);
//            return checkDec;
//        }
        if(x == 0){}
        else if(checkDec.contains(" ")) {
            if (!tempInUse) {
                x *= -1;
                temp = x;
                checkDec = fmt(x) + ". ";
            }
            else if(newNum){
                temp *= -1;
                x = temp;
                checkDec = fmt(temp) + ". ";

            }
            else{
                x *= -1;
                checkDec = fmt(x) + ". ";
            }
        }
        else if(!tempInUse) {
            checkDec = mathsButton("equalsButton");
            newNum = false;
            //double d = Double.parseDouble(checkDec);
            x *= -1;
            temp = x;

            checkDec = fmt(x);

        }
        else if(newNum){
            temp *= -1;
            x = temp;
            checkDec = fmt(temp);
        }
        else{
            x *= -1;

            checkDec = fmt(x);
        }
        return checkDec;
    }

    public String mathsButton(String s){

        if(!newNum) {
            if (!tempInUse) {
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
        //last = temp;

        newNum = true;

        checkDec = fmt(temp);
        return checkDec;
    }


    public String decimalButton(){
        if(!newNum && !dec && !checkDec.contains(".")) {
            dec = true;
            checkDec = fmt(x) + ". ";
        }
        else if(newNum){
            dec = true;
            x = 0;
            checkDec = "0. ";
        }
        else{
            checkDec = fmt(x);
        }
        return checkDec;
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
                //tempInUse = false;
                newNum = true;
                zerosPressed = 0;
                break;
            default: break;
        }
    }

//    public String saveButton(){
//       if(!newNum || !plus && !minus && !times && !divide){
//           //setSave
//           save = Double.parseDouble(checkDec);
//           newNum = true;
//       }
//       else{
//           //returnSave for Math
//           newNum = false;
//           x = save;
//           checkDec = fmt(x);
//       }
//       return checkDec;
//    }
//
//    public String lastButton() {
//        clearButton();
//        newNum = false;
//        temp = last;
//        x = last;
//        return  fmt(last);
//    }


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
