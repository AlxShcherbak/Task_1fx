package com.controllers;

import com.classes.ValueInBound;
import javafx.scene.control.TextField;

/**
 * Created by Alx Shcherbak on 01.06.2015.
 */
public class ValueInBoundGen {
    /**
     * @param downTF - down bound
     * @param upTF   - up bound
     * @return true or false
     * @throws NullPointerException;
     */
    public ValueInBound valueInBoundGen(TextField downTF, TextField upTF) {
        Double up = null, down = null;
        try {
            down = Double.parseDouble(downTF.getText().toString());
        } catch (NumberFormatException e) {
        }
        try {
            up = Double.parseDouble(upTF.getText().toString());
        } catch (NumberFormatException e) {
        }
        return new ValueInBound(down, up);
    }
}
