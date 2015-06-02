package com.controllers;


import com.classes.Tariff;
import com.classes.ValueInBound;
import javafx.scene.control.TextField;

/**
 * Created by Alx Shcherbak on 02.06.2015.
 */
public class SubController {
    /**
     *
     * @param textField
     * @return
     */
    public Double textFieldToDouble(TextField textField) {
        try {
            return Double.parseDouble(textField.getText().toString());
        } catch (java.lang.NumberFormatException e) {
        }
        return null;
    }

    /**
     * @param downTF - down bound
     * @param upTF   - up bound
     * @return true or false
     * @throws NullPointerException;
     */
    public ValueInBound valueInBoundGen(TextField downTF, TextField upTF) {
        Double up = null, down = null;
        down = textFieldToDouble(downTF);
        up = textFieldToDouble(upTF);
        return new ValueInBound(down, up);
    }
}
