package com.controllers;

import com.classes.Client;
import com.classes.Cost;
import com.classes.Tariff;
import com.classes.TariffType;
import com.operationCollection.OperationCollection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    static public OperationCollection operationCollection = new OperationCollection();
    public AnchorPane anchorMain;

    public AnchorPane anchorAddTariffFirst;
    public TextField textFieldAddNewTariffTitle;
    public ChoiceBox choiceBoxAddNewTariffType;

    public TextArea textAreaAddNewTariffDescription;
    public Button buttonAddNewTariffNext;

    public MenuItem menuItem_close;
    public MenuItem menuItem_watchingTabs;
    public MenuItem menuItem_addNewTariff;
    public MenuItem menuItem_addTestValues;
    public MenuItem menuItem_addNewClient;
    public MenuItem menuItem_actionDBSortTariffByCost;

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

    public TableView tableView;
    public TableColumn tableColumnWatchClientID;
    public TableColumn tableColumnWatchClientName;
    public TableColumn tableColumnWatchClientPhoneNum;
    public TableColumn tableColumnWatchClientTariff;
    public TableColumn tableColumnWatchClientBalance;
    public TableView tableViewClient;
    public TableView tableViewTariff;
    public TableColumn tableColumnWatchTariffID;
    public TableColumn tableColumnWatchTariffTitle;
    public TableColumn tableColumnWatchTariffType;
    public TableColumn tableColumnWatchTariffLicFee;
    public TableColumn tableColumnWatchTariffLicFeeYear;
    public TableColumn tableColumnWatchTariffLicFeeMonth;
    public TableColumn tableColumnWatchTariffLicFeeDay;
    public TableColumn tableColumnWatchTariffInternetFee;
    public TableColumn tableColumnWatchTariffInternetFeeYear;
    public TableColumn tableColumnWatchTariffInternetFeeMonth;
    public TableColumn tableColumnWatchTariffInternetFeeDay;
    public TableColumn tableColumnWatchTariffCost;
    public TableColumn tableColumnWatchTariffCostConnect;
    public TableColumn tableColumnWatchTariffCostCall;
    public TableColumn tableColumnWatchTariffCostMinute;
    public TableColumn tableColumnWatchTariffCost1Mb;
    public TableColumn tableColumnWatchTariffCost1Gb;
    public TableColumn tableColumnWatchTariffDescription;


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

        for (Tariff tariff : operationCollection.tariffsArray()) {
            comboBoxAddNewClientTariff.getItems().add(tariff.toString());
        }
    }

    private void allAnchorsVisibleFalse() {
        anchorMain.setVisible(true);
        anchorAddTariffFirst.setVisible(false);
        anchorAddTariffSecond.setVisible(false);
        anchorAddClient.setVisible(false);
        tabPane.setVisible(false);
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
        tabPane.setVisible(true);
        watchTariff(new Event(null));
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

    public void close(ActionEvent actionEvent) {
        System.exit(100);
    }

    public void watchTariff(Event event) {
        ArrayList<Tariff> tariffs = operationCollection.tariffsArray();
        if (tariffs != null && !tariffs.isEmpty()) {
            ArrayList<StringProprty.TariffStringProperty> propertyArrayList = new ArrayList<StringProprty.TariffStringProperty>();

            for (Tariff tariff : tariffs) {
                propertyArrayList.add(new StringProprty.TariffStringProperty(tariff));
            }

            tableColumnWatchTariffID.setCellValueFactory(new PropertyValueFactory<Tariff, String>("id"));
            tableColumnWatchTariffTitle.setCellValueFactory(new PropertyValueFactory<Tariff, String>("title"));
            tableColumnWatchTariffType.setCellValueFactory(new PropertyValueFactory<Tariff, String>("type"));
            tableColumnWatchTariffLicFeeYear.setCellValueFactory(new PropertyValueFactory<Tariff, String>("licFeeYear"));
            tableColumnWatchTariffLicFeeMonth.setCellValueFactory(new PropertyValueFactory<Tariff, String>("licFeeMonth"));
            tableColumnWatchTariffLicFeeDay.setCellValueFactory(new PropertyValueFactory<Tariff, String>("licFeeDay"));
            tableColumnWatchTariffInternetFeeYear.setCellValueFactory(new PropertyValueFactory<Tariff, String>("internetFeeYear"));
            tableColumnWatchTariffInternetFeeMonth.setCellValueFactory(new PropertyValueFactory<Tariff, String>("internetFeeMonth"));
            tableColumnWatchTariffInternetFeeDay.setCellValueFactory(new PropertyValueFactory<Tariff, String>("internetFeeDay"));
            tableColumnWatchTariffCostConnect.setCellValueFactory(new PropertyValueFactory<Tariff, String>("costOfConnection"));
            tableColumnWatchTariffCostCall.setCellValueFactory(new PropertyValueFactory<Tariff, String>("costOfCall"));
            tableColumnWatchTariffCostMinute.setCellValueFactory(new PropertyValueFactory<Tariff, String>("costOfMinute"));
            tableColumnWatchTariffCost1Mb.setCellValueFactory(new PropertyValueFactory<Tariff, String>("internetCost1Mb"));
            tableColumnWatchTariffCost1Gb.setCellValueFactory(new PropertyValueFactory<Tariff, String>("internetCost1Gb"));
            tableColumnWatchTariffDescription.setCellValueFactory(new PropertyValueFactory<Tariff, String>("textDescription"));

            ObservableList<StringProprty.TariffStringProperty> data =
                    FXCollections.observableArrayList(propertyArrayList);
            tableViewTariff.setItems(data);
        }
    }

    public void watchClient(Event event) {
        ArrayList<Client> clients = operationCollection.clientArray();
        if (clients != null && !clients.isEmpty()) {
            ArrayList<StringProprty.ClientStringProperty> propertyArrayList = new ArrayList<StringProprty.ClientStringProperty>();

            for (Client client : clients) {
                propertyArrayList.add(new StringProprty.ClientStringProperty(client));
            }

            tableColumnWatchClientID.setCellValueFactory(new PropertyValueFactory<Client, String>("id"));
            tableColumnWatchClientName.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
            tableColumnWatchClientPhoneNum.setCellValueFactory(new PropertyValueFactory<Client, String>("phoneNumber"));
            tableColumnWatchClientTariff.setCellValueFactory(new PropertyValueFactory<Client, String>("tariff"));
            tableColumnWatchClientBalance.setCellValueFactory(new PropertyValueFactory<Client, String>("balance"));

            ObservableList<StringProprty.ClientStringProperty> data =
                    FXCollections.observableArrayList(propertyArrayList);
            tableViewClient.setItems(data);
        }
    }

    public void actionDBSortTariffByCost(ActionEvent actionEvent) {
        operationCollection.sortTariffByCost();
    }

    public void watchingTabs(ActionEvent actionEvent) {
        allAnchorsVisibleFalse();
        tabPane.setVisible(true);
    }
}
