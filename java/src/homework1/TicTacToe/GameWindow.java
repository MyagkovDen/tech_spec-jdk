package src.homework1.TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Основное (игровое) окно
 */
public class GameWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;

    JButton btnStart = new JButton("New game");
    JButton btnExit = new JButton("Exit");

    Map map;
    SettingsWindow settings;

    public GameWindow() {
        //Установим, чтобы программа завершалась вместе с закрытием окна
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Настроим размеры окна и его позицию
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("src/homework1/TicTacToe");
        //Запретим пользователю изменять размеры окна
        setResizable(false);

        map = new Map();
        settings = new SettingsWindow(this);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });

        //Панель с группой элементов, в которой можно использовать свой компоновщик
        //Создадим панель, в ней разместим компоновщик, расположим ее в нижней части окна, создадим в ней 2 кнопки
        JPanel panBottom = new JPanel(new GridLayout());
        panBottom.add(btnStart);
        panBottom.add(btnExit);
        //BorderLayout - компоновщик
        add(panBottom, BorderLayout.SOUTH);
        add(map);
        //Сделаем окно видимым
        setVisible(true);
    }

    void startNewGame(int mode, int fSzX, int fSzY, int wLen){
        map.startNewGame(mode, fSzX, fSzY, wLen);
    }
}
