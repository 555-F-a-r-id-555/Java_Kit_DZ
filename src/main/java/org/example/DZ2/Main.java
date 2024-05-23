package org.example.DZ2;


import org.example.DZ2.Clients.ClientController;
import org.example.DZ2.Clients.ClientGUI;
import org.example.DZ2.DataBase.DataBase;
import org.example.DZ2.Server.ServerWindowController;
import org.example.DZ2.Server.ServerWindowGUI;

public class Main {
    public static void main(String[] args) {


        DataBase dataBase = new DataBase();

        ServerWindowGUI serverWindowGUI = new ServerWindowGUI();
        ServerWindowController serverWindowController = new ServerWindowController(serverWindowGUI, dataBase);
        serverWindowGUI.setServerWindowController(serverWindowController);


        ClientGUI clientGUI1 = new ClientGUI();
        ClientController clientController1 = new ClientController(clientGUI1, serverWindowController);
        clientGUI1.setClientController(clientController1);

        ClientGUI clientGUI2 = new ClientGUI();
        ClientController clientController2 = new ClientController(clientGUI2, serverWindowController);
        clientGUI2.setClientController(clientController2);






    }


}