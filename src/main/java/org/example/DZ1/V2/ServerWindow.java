package org.example.DZ1.V2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Этот класс реализует серверную логику
 */
public class ServerWindow extends JFrame {


    private static final int WINDOW_HEIGHT = 230;
    private static final int WINDOW_WIDTH = 500;
    private static final int POST_X = 850;
    private static final int POST_Y = 200;
    private static final String LOG_FILE_PATH = "src/main/java/org/example/DZ1/V2/log.txt";

    private final JButton buttonStart = new JButton("Start");
    private final JButton buttonStop = new JButton("Stop");

    private final JTextArea textAreaServer = new JTextArea();

    private boolean isServerWorking;


    /**
     *  clients - Список клиентов для рассылки сообщений
     */
    private final List<ClientGUI> clients = new ArrayList<>();


    /**
     * clientResetCallbacks - Список обратных вызовов для сброса панели клиента
     */
    private final List<Runnable> clientResetCallbacks = new ArrayList<>();

    public ServerWindow() throws HeadlessException {
        setTitle("Chat Server");
        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(buttonStart);
        panel.add(buttonStop);
        add(new JScrollPane(textAreaServer), BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        isServerWorking = false;

        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isServerWorking) {
                    textAreaServer.append("Сервер уже остановлен\n");
                } else {
                    isServerWorking = false;
                    textAreaServer.append("Сервер остановлен\n");
                    /**
                     * Вызов всех обратных вызовов для сброса панелей клиентов
                     */
                    for (Runnable callback : clientResetCallbacks) {
                        callback.run();
                    }
                    /**
                     * Удаление всех зарегистрированных пользователей
                     */
                    clients.clear();
                }
            }
        });

        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isServerWorking) {
                    textAreaServer.append("Сервер уже работает\n");
                } else {
                    isServerWorking = true;
                    textAreaServer.append("Сервер запущен\n");
                    readLogs();
                }
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(POST_X , POST_Y);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        textAreaServer.setEditable(false);
        setVisible(true);
    }

    public boolean isServerWorking() {
        return isServerWorking;
    }

    public void serverUserConnectionInfo(String username) {
        textAreaServer.append("Пользователь: " + username + " подключи(лся)/лась к серверу\n");
    }

    public void connectUser(String username) {
        if (isServerWorking) {
            serverUserConnectionInfo(username);
        }
    }

    public void appendMessage(String message) {
        textAreaServer.append(message + "\n");
        writeLog(message);
    }

    /**
     * @param message - сообщения клиентов
     *       проходим по скиску пользователей и добавляем сообщения всех клинтов в текстэрию каждого пользователя,
     *       в итоге каждый клиент видет сообщения других пользовтелей
     */
    public void broadcastMessage(String message) {
        appendMessage(message);
        for (ClientGUI client : clients) {
            client.appendMessage(message);
        }
    }

    public void registerClient(ClientGUI client) {
        clients.add(client);
        sendLogsToClient(client);
    }

    public void addClientResetCallback(Runnable callback) {
        clientResetCallbacks.add(callback);
    }

    private void writeLog(String message) {
        try (FileWriter fw = new FileWriter(LOG_FILE_PATH, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readLogs() {
        try (FileReader fr = new FileReader(LOG_FILE_PATH);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                textAreaServer.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendLogsToClient(ClientGUI client) {
        try (FileReader fr = new FileReader(LOG_FILE_PATH);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                client.appendMessage(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


