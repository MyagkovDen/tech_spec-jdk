package src.homework1.Server;/*Создать простейшее окно управления сервером (по сути, любым), содержащее две кнопки (JButton) –
запустить сервер и остановить сервер. Кнопки должны просто логировать нажатие (имитировать запуск и остановку
сервера, соответственно) и выставлять внутри интерфейса соответствующее булево isServerWorking.*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Server extends JFrame {
    private static final int WINDOW_HEIGHT = 259;
    private static final int WINDOW_WIDTH = 508;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;
    JButton btnStart = new JButton("Run server");
    JButton btnStop = new JButton("Stop server");
    private boolean isServerWorking = false;
    JTextArea info = new JTextArea();
    private final String STATE_UP = "src.Server.src.Server is up";
    private final String STATE_DOWN = "src.Server.src.Server is down";

    public Server() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isServerWorking) {
                    isServerWorking = true;
                    info.setText(STATE_UP);
                }
            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isServerWorking) {
                    isServerWorking = false;
                    info.setText(STATE_DOWN);
                }
            }
        });

        JPanel panel = new JPanel(new GridLayout());
        add(panel);
        panel.add(btnStart);
        panel.add(btnStop);
        add(info, BorderLayout.SOUTH);
        setVisible(true);
    }
}
