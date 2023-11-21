package src.homework1.TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Стартовое (вспомогательное) окно. Здесь мы задаем настройки поля и выбираем режим игры
 */
public class SettingsWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 230;
    private static final int WINDOW_WIDTH = 350;
    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 10;
    private final JButton btnStart = new JButton("Start new game");
    private final JPanel panel;
    private JLabel gameMode;
    private JRadioButton humanVsAi;
    private JRadioButton humanVsHuman;
    private JLabel fieldSize;
    private JSlider fieldSizeSlider;
    private JLabel fSizeSet;
    private JLabel winCount;
    private JSlider winCountSlider;
    private JLabel winCountSet;


    SettingsWindow(GameWindow gameWindow) {
        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        panel = new JPanel(new GridLayout(10, 1));
        setGameMode();
        setFieldSize();
        setWinCount();

        ButtonGroup bg = new ButtonGroup();
        bg.add(humanVsAi);
        bg.add(humanVsHuman);

        add(panel);
        panel.add(gameMode);
        panel.add(humanVsAi);
        panel.add(humanVsHuman);
        panel.add(fieldSize);
        panel.add(fieldSizeSlider);
        panel.add(fSizeSet);
        panel.add(winCount);
        panel.add(winCountSlider);
        panel.add(winCountSet);
        panel.add(btnStart);

        addActionListenerToButtonStart(gameWindow);
    }

    private void setGameMode() {
        gameMode = new JLabel("Выберите режим игры: ");
        humanVsAi = new JRadioButton("Человек против компьютера");
        humanVsHuman = new JRadioButton("Человек против человека");
    }

    private void setFieldSize() {
        fieldSize = new JLabel("Выберите размер поля: ");
        fieldSizeSlider = new JSlider(MIN_SIZE, MAX_SIZE);
        fSizeSet = new JLabel("Установленный размер поля: ");
        fieldSizeSlider.addChangeListener(e -> fSizeSet.setText(
                "Установленный размер поля: " + fieldSizeSlider.getValue()));
    }

    private void setWinCount() {
        winCount = new JLabel("Выберите длину для победы");
        winCountSlider = new JSlider(MIN_SIZE, MAX_SIZE);
        winCountSet = new JLabel("Установленная длина для победы: ");
        winCountSlider.addChangeListener(e -> winCountSet.setText(
                "Установленная длина для победы: " + winCountSlider.getValue()));
    }

    private void addActionListenerToButtonStart(GameWindow gameWindow) {
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameWindow.startNewGame(
                        humanVsAi.isSelected() ? 0 : 1,
                        fieldSizeSlider.getValue(),
                        fieldSizeSlider.getValue(),
                        winCountSlider.getValue()
                );
                setVisible(false);
            }
        });
    }
}
