package com.operationCollection;

import com.classes.*;
import com.factorys.ClientFactorySingleTone;
import com.factorys.TariffFactorySingleTone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;

/**
 * Created by Alx Shcherbak on 27.05.2015.
 */
public class OperationCollection {
    /**
     *
     */
    static ClientFactorySingleTone clientFactory = ClientFactorySingleTone.getFactoryCard();
    /**
     *
     */
    static TariffFactorySingleTone tariffFactory = TariffFactorySingleTone.getFactoryCard();
    /**
     *
     */
    static ArrayList<Tariff> tariffs = new ArrayList<Tariff>();
    /**
     *
     */
    static ArrayList<Client> clients = new ArrayList<Client>();

    /**
     * @param title
     * @param type
     * @param cost
     * @param dateStart
     * @param textDescription
     */
    public void addTariff(String title, TariffType type, Cost cost, GregorianCalendar dateStart, String textDescription) {
        tariffs.add(tariffFactory.addTariff(title, type, cost, dateStart, textDescription));
    }

    /**
     * @param name
     * @param phoneNumber
     * @param tariff
     */
    public void addClient(String name, Long phoneNumber, Tariff tariff) {
        clients.add(clientFactory.addClient(name, phoneNumber, tariff));
    }

    /**
     * @param id
     * @return
     */
    public Tariff getTariffById(Integer id) {
        if (id == null) return null;
        for (Tariff tariff : tariffs) {
            if (tariff.getId().equals(id)) return tariff;
        }
        return null;
    }

    /**
     * @param id
     * @return
     */
    public Client getClientByID(Integer id) {
        for (Client client : clients) {
            if (client.getId().equals(id)) return client;
        }
        return null;
    }

    /**
     * @return
     */
    public ArrayList<Tariff> tariffsArray() {
        return tariffs;
    }

    /**
     * @return
     */
    public ArrayList<Client> clientArray() {
        return clients;
    }

    /**
     *
     */
    public void addTestValues() {
        /*id, title, type, cost, dateStart, textDescription*/
        tariffs.add(tariffFactory.addTariff("Title first", TariffType.CONTRACT,
                /*licenceFeeYear, licenceFeeMonth, licenceFeeDay, costOfCall, connectionCost, costOfMinute,
                internetFeeYear, internetFeeMonth, internetFeeDay, internetCost1Gb, internetCost1Mb*/
                new Cost(1000d, 100d, 5d, 0.6d, 0d, 0d, 1000d, 100d, 5d, 20d, 0.2d),
                new GregorianCalendar(), "description first"));
        tariffs.add(tariffFactory.addTariff("Title second", TariffType.CORPORATION,
                new Cost(1200d, 150d, 7.5d, 0d, 0d, 0d, 1500d, 150d, 9d, 20d, 0.2d),
                new GregorianCalendar(), "description second"));
        tariffs.add(tariffFactory.addTariff("Title third", TariffType.PAY_TO_CALL,
                new Cost(0d, 0d, 0d, 0.4d, 0d, 0.15d, 800d, 75d, 3d, 20d, 0.2d),
                new GregorianCalendar(), "description third"));
        clients.add(clientFactory.addClient("Name first", 380960000000l, tariffs.get(0)));
        clients.add(clientFactory.addClient("Name second", 380960000001l, tariffs.get(0)));
        clients.add(clientFactory.addClient("Name third", 380960000002l, tariffs.get(1)));
        clients.add(clientFactory.addClient("Name fourth", 380960000003l, tariffs.get(0)));
        clients.add(clientFactory.addClient("Name fifth", 380960000004l, tariffs.get(1)));
        clients.add(clientFactory.addClient("Name sixth", 380960000005l, tariffs.get(2)));
        clients.add(clientFactory.addClient("Name seventh", 380960000006l, tariffs.get(2)));
        clients.add(clientFactory.addClient("Name eighth", 380960000007l, tariffs.get(0)));
    }

    /**
     *
     */
    public void sortTariffByCost() {
        Collections.sort(tariffs);
        System.out.println();
    }

    /**
     * @param licenceFeeYear
     * @param licenceFeeMonth
     * @param licenceFeeDay
     * @param costOfCall
     * @param connectionCost
     * @param costOfMinute
     * @param internetFeeYear
     * @param internetFeeMonth
     * @param internetFeeDay
     * @param internetCost1Gb
     * @param internetCost1Mb
     * @param tariffType
     * @return
     */
    public ArrayList<Tariff> searchTariffByParam(ValueInBound licenceFeeYear, ValueInBound licenceFeeMonth,
                                                 ValueInBound licenceFeeDay, ValueInBound costOfCall,
                                                 ValueInBound connectionCost, ValueInBound costOfMinute,
                                                 ValueInBound internetFeeYear, ValueInBound internetFeeMonth,
                                                 ValueInBound internetFeeDay, ValueInBound internetCost1Gb,
                                                 ValueInBound internetCost1Mb, TariffType tariffType) {
        ArrayList<Tariff> returnArrayList = new ArrayList<Tariff>();
        Boolean flag, tariffTypeflag;
        for (Tariff tariffBuff : tariffs) {
            flag = true;
            flag = flag && licenceFeeYear.valueInBound(tariffBuff.getCost().getLicenceFeeYear());
            flag = flag && licenceFeeMonth.valueInBound(tariffBuff.getCost().getLicenceFeeMonth());
            flag = flag && licenceFeeDay.valueInBound(tariffBuff.getCost().getLicenceFeeDay());
            flag = flag && costOfCall.valueInBound(tariffBuff.getCost().getCostOfCall());
            flag = flag && connectionCost.valueInBound(tariffBuff.getCost().getConnectionCost());
            flag = flag && costOfMinute.valueInBound(tariffBuff.getCost().getCostOfMinute());
            flag = flag && internetFeeYear.valueInBound(tariffBuff.getCost().getInternetFeeYear());
            flag = flag && internetFeeMonth.valueInBound(tariffBuff.getCost().getInternetFeeMonth());
            flag = flag && internetFeeDay.valueInBound(tariffBuff.getCost().getInternetFeeDay());
            flag = flag && internetCost1Gb.valueInBound(tariffBuff.getCost().getInternetCost1Gb());
            flag = flag && internetCost1Mb.valueInBound(tariffBuff.getCost().getInternetCost1Mb());
            if (tariffType == null) tariffTypeflag = true;
            else tariffTypeflag = tariffType == tariffBuff.getType();
            flag = flag && tariffTypeflag;
            if (flag) returnArrayList.add(tariffBuff);
        }
        return returnArrayList;
    }

    /**
     * @param tariff
     * @return
     */
    public Integer statisticByTariff(Tariff tariff) {
        Integer clientCounter = 0;
        if (tariff != null) {
            for (Client clientBuff : clients) {
                if (clientBuff.getTariff() == (tariff)) clientCounter++;
            }
        } else clientCounter = clients.size();
        return clientCounter;
    }
}
