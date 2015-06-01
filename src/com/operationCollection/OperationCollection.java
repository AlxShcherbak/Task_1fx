package com.operationCollection;

import com.classes.Client;
import com.classes.Cost;
import com.classes.Tariff;
import com.classes.TariffType;
import com.factorys.ClientFactorySingleTone;
import com.factorys.TariffFactorySingleTone;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.GregorianCalendar;

/**
 * Created by Alx Shcherbak on 27.05.2015.
 */
public class OperationCollection {
    static ClientFactorySingleTone clientFactory = ClientFactorySingleTone.getFactoryCard();
    static TariffFactorySingleTone tariffFactory = TariffFactorySingleTone.getFactoryCard();
    static ArrayList<Tariff> tariffs = new ArrayList<Tariff>();
    static ArrayList<Client> clients = new ArrayList<Client>();

    public void addTariff(String title, TariffType type, Cost cost, GregorianCalendar dateStart, String textDescription) {
        tariffs.add(tariffFactory.addTariff(title, type, cost, dateStart, textDescription));
    }

    public void addClient(String name, Long phoneNumber, Tariff tariff) {
        clients.add(clientFactory.addClient(name, phoneNumber, tariff));
    }

    public Tariff getTariffById(Integer id) {
        for (Tariff tariff : tariffs) {
            if (tariff.getId().equals(id)) return tariff;
        }
        return null;
    }

    public Client getClientID(Integer id) {
        for (Client client : clients) {
            if (client.getId().equals(id)) return client;
        }
        return null;
    }

    public ArrayList<Tariff> tariffsArray() {
        return tariffs;
    }

    public ArrayList<Client> clientArray() {
        return clients;
    }

    public void addTestValues() {
        tariffs.add(tariffFactory.addTariff("Title first", TariffType.CONTRACT,
                new Cost(1000d, 100d, 5d, 0.6d, 0.28d, 0.15d, 1000d, 100d, 5d, 20d, 0.2d),
                new GregorianCalendar(), "description first"));
        tariffs.add(tariffFactory.addTariff("Title second", TariffType.CORPORATION,
                new Cost(900d, 100d, 5d, 0.5d, 0.2d, 0.1d, 1500d, 150d, 9d, 20d, 0.2d),
                new GregorianCalendar(), "description second"));
        tariffs.add(tariffFactory.addTariff("Title third", TariffType.PAY_TO_CALL,
                new Cost(1200d, 120d, 6d, 0.4d, 0.4d, 0.15d, 800d, 75d, 3d, 20d, 0.2d),
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

    public void sortTariffByCost(){
        Collections.sort(tariffs);
        System.out.println();
    }
}
