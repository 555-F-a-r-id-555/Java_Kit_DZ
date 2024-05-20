package org.example.DZ1.V1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class ClientGUI extends JFrame {

    private boolean loginTrigger;
    private static int count = 0;
    private static final int OFFSET_STEP = 20;
    private ServerWindow serverWindow;

    private static final int WINDOW_HEIGHT = 230;
    private static final int WINDOW_WIDTH = 500;
    private static final int POST_X = 100;
    private static final int POST_Y = 100;


    private final JTextArea textAreaClient = new JTextArea();


    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));
    private final JTextField textIPAddress = new JTextField("127.0.0.1");
    private final JTextField textPort = new JTextField("8888");
    private final JTextField textSpace = new JTextField("  ");

    private static final String[] USERS ={
            "Ivan_Ivanovich",
            "Petr_Petrovich",
            "Vasilisa_Vasilisovna",
            "Zaxar_Zaxarovich",
            "Nicka_Nickolayevna"
    };
    private final JComboBox comboBox = new JComboBox<>(USERS);

//    private final JTextField textLogin = new JTextField("Ivan_Ivanovich");

    private final JPasswordField password = new JPasswordField("12345");
    private final JButton buttonLogin = new JButton("Login");

    private final JPanel panelBottom = new JPanel(new BorderLayout());
    private final JTextField textMessage = new JTextField();
    private final JButton buttonSend = new JButton("Send");


    public ClientGUI(ServerWindow serverWindow) {

        this.serverWindow = serverWindow;

        setTitle("Chat Client");


        panelTop.add(textIPAddress);
        panelTop.add(textPort);
        panelTop.add(textSpace);
        panelTop.add(comboBox);
//        panelTop.add(textLogin);
        panelTop.add(password);
        panelTop.add(buttonLogin);
        add(panelTop, BorderLayout.NORTH);

        panelBottom.add(textMessage, BorderLayout.CENTER);
        panelBottom.add(buttonSend, BorderLayout.EAST);
        add(panelBottom, BorderLayout.SOUTH);

        textAreaClient.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textAreaClient);
        add(scrollPane);


        textMessage.setEnabled(false);


        loginTrigger = false;

        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (serverWindow.isServerWorking()) {
                    panelTop.setVisible(false);
                    textMessage.setEnabled(true);
                    buttonSend.setEnabled(true);
                    textAreaClient.append("Вы успешно подключились к серверу\n");
                    loginTrigger = true;
                    serverWindow.connectUser((String) comboBox.getSelectedItem());
//                    serverWindow.connectUser(textLogin.getText());
                    serverWindow.registerClient(ClientGUI.this);

                } else {
//                    panelTop.setVisible(true);
//                    textMessage.setEnabled(false);
//                    buttonSend.setEnabled(false);
                    textAreaClient.append("Сервер не запущен\n");
                }
            }
        });


        ActionListener sendActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        };

        textMessage.addActionListener(sendActionListener);
        buttonSend.addActionListener(sendActionListener);

//        textMessage.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                sendMessage(serverWindow);
//            }
//        });
//
//        buttonSend.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                sendMessage(serverWindow);
//            }
//        });


//        setDefaultCloseOperation(EXIT_ON_CLOSE);
        int xOffset = POST_X + count * OFFSET_STEP;
        int yOffset = POST_Y + count * OFFSET_STEP;
        count++;
        setLocation(xOffset, yOffset);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        textSpace.setVisible(false);
        setVisible(true);
    }

    public void resetPanelTop() {
        panelTop.setVisible(true);
        textMessage.setEnabled(false);
    }

    private void sendMessage() {
        if (!loginTrigger) {
            textAreaClient.append("Вы не подключены/не залогинились\n");
            return;
        }
        if (textMessage.getText().trim().isEmpty()) {
            textAreaClient.append("Сообщение не может быть пустым\n");
            textAreaClient.append("Вероятно,Вы не подключены/не залогинились\n");
            return;
        }

        LocalDateTime localDateTime = LocalDateTime.now();
        String dataNow = localDateTime.getDayOfMonth() + "-" + localDateTime.getMonth() + "-" + localDateTime.getYear();
        String hourNow = localDateTime.getHour() + ":" + localDateTime.getMinute() + ":" + localDateTime.getSecond();
        String resDateNow = "дата: " + dataNow + " время: " + hourNow;

        String selectedUser = (String) comboBox.getSelectedItem();
        String message = resDateNow + " пользователь: " + selectedUser + ": " + textMessage.getText();
//        String message = textLogin.getText() + ": " + textMessage.getText();
        if (serverWindow.isServerWorking()) {
            textMessage.setText("");
            serverWindow.broadcastMessage(message);
        } else {
            textAreaClient.append("Сервер не запущен\n");
        }

//        if (serverWindow.isServerWorking() && loginTrigger) {
//            textMessage.setText("");
//            serverWindow.broadcastMessage(message);
//        } else if (!loginTrigger && serverWindow.isServerWorking()) {
//            textAreaClient.append("Вы не подлючились/не залогинились\n");
//        }else {
//            textAreaClient.append("Сервер не запущен\n");
//
//        }

//        if (serverWindow.isServerWorking()) {
//            textMessage.setText("");
//            serverWindow.broadcastMessage(message);
//        } else {
//            textAreaClient.append("Сервер не запущен\n");
//        }

    }

    public void appendMessage(String message) {
        textAreaClient.append(message + "\n");
    }

}

