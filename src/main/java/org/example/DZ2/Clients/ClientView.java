package org.example.DZ2.Clients;

public interface ClientView {
    /**
     * Метод для отображения сообщения в GUI
     * @param message текст сообщения
     */
    void showMessage(String message);

    /**
     * Метод отключения от сервера со стороны сервера
     */
    void disconnectedByServer();

/*
*  //TODO - доработать метод отключения по нажатию по крестику  окна пользователя ClientGUI + решено
 */
    void userDisconnected();

    String getUserName();
}
