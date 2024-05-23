package org.example.DZ2.Server;

public interface ServerWindowView {

    void userConnectionInfo(String message);

    void userDisconnectInfo(String username);

    void  showMessage(String message);

    void connectToServer();


}
