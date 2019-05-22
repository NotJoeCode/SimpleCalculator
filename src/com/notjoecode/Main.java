package com.notjoecode;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {


        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenSize.setSize(screenSize.height/5, screenSize.height/4);
        CalcLayout c = new CalcLayout();

        JFrame f = new JFrame("Calculator");
        f.setContentPane(c.panelMain);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //f.setSize((int)screenSize.getWidth(),(int)screenSize.getHeight());
        f.pack();
        f.setVisible(true);


    }


}
