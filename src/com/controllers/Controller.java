package com.controllers;

import com.classes.Cost;
import com.classes.Tariff;
import com.classes.TariffType;
import com.operationCollection.OperationCollection;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    static public OperationCollection operationCollection;
    public AnchorPane anchorMain;

    public AnchorPane anchorAddTariffFirst;
    public TextField textFieldAddNewTariffTitle;
    public ChoiceBox choiceBoxAddNewTariffType ;

    public TextArea textAreaAddNewTariffDescription;
    public Button buttonAddNewTariffNext;

    public MenuItem menuItem_addNewTariff;
    public MenuItem menuItem_addTestValues;
    public MenuItem menuItem_addNewClient;

    public TabPane tabPane;

    public AnchorPane anchorAddTariffSecond;
    public TextField textFieldAddNewTariffLicFeeYear;
    public TextField textFieldAddNewTariffLicFeeMonth;
    public TextField textFieldAddNewTariffLicFeeDay;
    public TextField textFieldAddNewTariffCostCall;
    public TextField textFieldAddNewTariffCostConnect;
    public TextField textFieldAddNewTariffCostMinute;
    public TextField textFieldAddNewTariffInternetFeeYear;
    public TextField textFieldAddNewTariffInternetFeeMonth;
    public TextField textFieldAddNewTariffInternetFeeDay;
    public TextField textFieldAddNewTariffCost1Gb;
    public TextField textFieldAddNewTariffCost1Mb;
    public Button buttonAddTariffApply;

    public AnchorPane anchorAddClient;
    public TextField textFieldAddNewClientName;
    public TextField textFieldAddNewClientPhone;
    public TextField textFieldAddNewClientBalance;
    public ComboBox comboBoxAddNewClientTariff;
    public Button buttonAddNewClientApply;

    private void clearAllFields() {
        choiceBoxAddNewTariffType.getItems().clear();
        choiceBoxAddNewTariffType.getItems().addAll(TariffType.CONTRACT, TariffType.CORPORATION, TariffType.PAY_TO_CALL);

        textFieldAddNewTariffTitle.clear();
        textAreaAddNewTariffDescription.clear();
        textFieldAddNewTariffLicFeeYear.clear();
        textFieldAddNewTariffLicFeeMonth.clear();
        textFieldAddNewTariffLicFeeDay.clear();
        textFieldAddNewTariffCostCall.clear();
        textFieldAddNewTariffCostConnect.clear();
        textFieldAddNewTariffCostMinute.clear();
        textFieldAddNewTariffInternetFeeYear.clear();
        textFieldAddNewTariffInternetFeeMonth.clear();
        textFieldAddNewTariffInternetFeeDay.clear();
        textFieldAddNewTariffCost1Gb.clear();
        textFieldAddNewTariffCost1Mb.clear();

        textFieldAddNewClientName.clear();
        textFieldAddNewClientPhone.clear();
        textFieldAddNewClientBalance.clear();
        comboBoxAddNewClientTariff.getItems().clear();

        for (Tariff tariff : operationCollection.tariffsArray()){
            comboBoxAddNewClientTariff.getItems().add(tariff.toString());
        }
    }

    private void allAnchorsVisibleFalse() {
        anchorMain.setVisible(true);
        anchorAddTariffFirst.setVisible(false);
        anchorAddTariffSecond.setVisible(false);
        anchorAddClient.setVisible(false);
    }


    public void buttonAddNewTariffNext(ActionEvent actionEvent) {
        allAnchorsVisibleFalse();
        anchorAddTariffSecond.setVisible(true);
    }

    public void buttonAddTariffApply(ActionEvent actionEvent) {
        Double licenceFeeYear = 0d, licenceFeeMonth = 0d, licenceFeeDay = 0d,
                costOfCall = 0d, connectionCost = 0d, costOfMinute = 0d,
                internetFeeYear = 0d, internetFeeMonth = 0d, internetFeeDay = 0d,
                internetCost1Gb = 0d, internetCost1Mb = 0d;
        try {
            licenceFeeYear = Double.parseDouble(textFieldAddNewTariffInternetFeeYear.getText());
        } catch (java.lang.NumberFormatException e) {
        }
        try {
            licenceFeeMonth = Double.parseDouble(textFieldAddNewTariffLicFeeMonth.getText());
        } catch (java.lang.NumberFormatException e) {
        }
        try {
            licenceFeeDay = Double.parseDouble(textFieldAddNewTariffLicFeeDay.getText());
        } catch (java.lang.NumberFormatException e) {
        }
        try {
            costOfCall = Double.parseDouble(textFieldAddNewTariffCostCall.getText());
        } catch (java.lang.NumberFormatException e) {
        }
        try {
            connectionCost = Double.parseDouble(textFieldAddNewTariffCostConnect.getText());
        } catch (java.lang.NumberFormatException e) {
        }
        try {
            costOfMinute = Double.parseDouble(textFieldAddNewTariffCostMinute.getText());
        } catch (java.lang.NumberFormatException e) {
        }
        try {
            internetFeeYear = Double.parseDouble(textFieldAddNewTariffInternetFeeYear.getText());
        } catch (java.lang.NumberFormatException e) {
        }
        try {
            internetFeeMonth = Double.parseDouble(textFieldAddNewTariffInternetFeeMonth.getText());
        } catch (java.lang.NumberFormatException e) {
        }
        try {
            internetFeeDay = Double.parseDouble(textFieldAddNewTariffInternetFeeDay.getText());
        } catch (java.lang.NumberFormatException e) {
        }
        try {
            internetCost1Gb = Double.parseDouble(textFieldAddNewTariffCost1Gb.getText());
        } catch (java.lang.NumberFormatException e) {
        }
        try {
            internetCost1Mb = Double.parseDouble(textFieldAddNewTariffCost1Mb.getText());
        } catch (java.lang.NumberFormatException e) {
        }

        Cost cost = new Cost(licenceFeeYear, licenceFeeMonth, licenceFeeDay,
                costOfCall, connectionCost, costOfMinute,
                internetFeeYear, internetFeeMonth, internetFeeDay,
                internetCost1Gb, internetCost1Mb);

        String title = "", description = "";
        title = textFieldAddNewTariffTitle.getText();
        description = textAreaAddNewTariffDescription.getText();

        TariffType tariffType = TariffType.valueOf(choiceBoxAddNewTariffType.getSelectionModel().getSelectedItem().toString());
        operationCollection.addTariff(title, tariffType, cost, new GregorianCalendar(), description);
    }

    public void menuAddNewTariff(ActionEvent actionEvent) {
        allAnchorsVisibleFalse();
        clearAllFields();
        anchorAddTariffFirst.setVisible(true);
    }

    public void menuAddTestValues(ActionEvent actionEvent) {
        operationCollection.addTestValues();
    }

    public void menuAddNewClient(ActionEvent actionEvent) {
        allAnchorsVisibleFalse();
        clearAllFields();
        anchorAddClient.setVisible(true);
    }

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        allAnchorsVisibleFalse();
        operationCollection = new OperationCollection();
    }

    public void addNewClientApply(ActionEvent actionEvent) {
        Long phoneNumber = 0l;
        String name = "", tariffChoiceString;
        Tariff tariff = null;

        try {
            phoneNumber = Long.parseLong(textFieldAddNewClientPhone.getText().toString());
        } catch (NumberFormatException e) {
        }

        name = textFieldAddNewClientName.getText().toString();
        tariffChoiceString = comboBoxAddNewClientTariff.getSelectionModel().getSelectedItem().toString();
        String[] parts = tariffChoiceString.split("/");
        Integer tariffChoiceID = -1;

        try {
            tariffChoiceID = Integer.parseInt(parts[0]);
        } catch (NumberFormatException e) {
        }

        if (tariffChoiceID > -1)
            tariff = operationCollection.getTariffById(tariffChoiceID);
        operationCollection.addClient(name, phoneNumber, tariff);
    }
}
