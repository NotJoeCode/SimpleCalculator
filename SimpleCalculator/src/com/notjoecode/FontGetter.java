package com.notjoecode;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class FontGetter {

    public Font newFont() {
        Font ttfReal = new Font("TimesRoman", Font.BOLD, 25);
        try {
            String fontFileName = "/res/Calculator.ttf";
            InputStream is = this.getClass().getResourceAsStream(fontFileName);

            Font ttfBase = Font.createFont(Font.TRUETYPE_FONT, is);

            ttfReal = ttfBase.deriveFont(Font.PLAIN, 54);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        return ttfReal;

    }
}
