package org.example.DZ2.DataBase;


public interface DataBaseView {

    String showMessageDataBase(String message);

    void writeLog(String txt);

    String sendLogsToServer();

    String sendLogsToClient();
}
