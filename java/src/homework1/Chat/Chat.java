package src.homework1.Chat;/*Создать окно клиента чата. Окно должно содержать JtextField для ввода логина, пароля, IP-адреса сервера,
порта подключения к серверу, область ввода сообщений, JTextArea область просмотра сообщений чата и JButton
подключения к серверу и отправки сообщения в чат. Желательно сразу сгруппировать компоненты, относящиеся к серверу
сгруппировать на JPanel сверху экрана, а компоненты, относящиеся к отправке сообщения – на JPanel снизу*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class Chat extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 607;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;
    JPanel panelUp = new JPanel(new GridLayout(2, 4));
    JPanel panelCenter = new JPanel(new BorderLayout());
    JPanel panelBottom = new JPanel(new BorderLayout());
    JLabel labelLogin = new JLabel("Login: ");
    JLabel labelPassword = new JLabel("Password: ");
    JLabel labelIpAddress = new JLabel("IP address: ");
    JLabel labelPort = new JLabel("Port: ");
    JTextField fieldLogin = new JTextField();
    JTextField fieldPassword = new JTextField();
    JTextField fieldIpAddress = new JTextField();
    JTextField fieldPort = new JTextField();
    JTextField fieldMessage = new JTextField();
    JTextArea log = new JTextArea();
    JButton btnConnect = new JButton("Connect");
    JButton btnSend = new JButton("Send");
    String login;
    String password;
    String ipAddress;
    String port;
    String message;
    private final JList<User> users = new JList<>();
    private final File file = new File("log.txt");


    public Chat() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("src/homework1/Chat");

        users.setListData(new User[]{new User(
                "Ivan", "Petrov")
                , new User("Petr", "Chernov")
                , new User("Maria", "Belaya")
                , new User("Alex", "Smirnov")
                , new User("Tatiana", "Petrova")
                , new User("Elena", "Rudina")});
        add(users, BorderLayout.WEST);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(panel);

        panel.add(panelUp, BorderLayout.NORTH);
        panelUp.add(labelLogin);
        panelUp.add(labelPassword);
        panelUp.add(labelIpAddress);
        panelUp.add(labelPort);
        panelUp.add(fieldLogin);
        panelUp.add(fieldPassword);
        panelUp.add(fieldIpAddress);
        panelUp.add(fieldPort);

        panel.add(panelCenter);
        panelCenter.add(btnConnect, BorderLayout.NORTH);
        btnConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login = fieldLogin.getText();
                password = fieldPassword.getText();
                ipAddress = fieldIpAddress.getText();
                port = fieldPort.getText();
                read();
            }
        });
        log.setEditable(false);
        JScrollPane scrollView = new JScrollPane(log);
        panelCenter.add(log);

        panel.add(panelBottom, BorderLayout.SOUTH);
        panelBottom.add(fieldMessage, BorderLayout.CENTER);
        panelBottom.add(btnSend, BorderLayout.EAST);
        btnSend.addActionListener(e -> getMessage());
        fieldMessage.addActionListener(e -> getMessage());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                write();
            }
        });

        setVisible(true);
    }

    void getMessage() {
        message = login + ": " + fieldMessage.getText() + "\n";
        log.append(message);
    }

    void write() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            //  String sp = System.getProperty("line.separator");
            writer.write(log.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void read() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                log.append(line);
                log.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


