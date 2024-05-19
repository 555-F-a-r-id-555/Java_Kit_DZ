package org.example.DZ1.V1;

public class Main {
    public static void main(String[] args) {

        ServerWindow serverWindow = new ServerWindow();
        ClientGUI client1 = new ClientGUI(serverWindow);
        ClientGUI client2 = new ClientGUI(serverWindow);

//        serverWindow.addClient(client1);
//        serverWindow.addClient(client2);
    }
}
