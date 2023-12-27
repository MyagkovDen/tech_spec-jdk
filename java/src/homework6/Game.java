package src.homework6;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Game {
    boolean[] doors;
    int firstChoice;
    int finalChoice;
    int goat;
    int winCounterChange;
    int winCounterKeep;


    public void setData() {
        int win = new Random().nextInt(3);
        doors = new boolean[3];
        for (int i = 0; i < 3; i++) {
            doors[i] = i == win ? true : false;
        }
        this.setFields();
    }

    public void setFields() {
        firstChoice = new Random().nextInt(3);
        for (int i = 0; i < 3; i++) {
            if (i != firstChoice && doors[i] == false)
                goat = i;
        }
    }

    public void changeChoice(Map<Integer, Boolean> results, int iteration) {
        for (int i = 0; i < doors.length; i++) {
            if (i != firstChoice && i != goat) {
                finalChoice = i;
                results.put(iteration, doors[finalChoice]);
                winCounterChange = doors[finalChoice] ? ++winCounterChange : winCounterChange;
            }
        }
    }

    public void keepChoice(Map<Integer, Boolean> results, int iteration) {
        results.put(iteration, doors[firstChoice]);
        winCounterKeep = doors[firstChoice] ? ++winCounterKeep : winCounterKeep;
    }

    public boolean testParadox() {
        int count = 500;
        Map<Integer, Boolean> changeMap = new HashMap<>();
        for (int i = 0; i < count; i++) {
            setData();
            changeChoice(changeMap, i);
        }
        int keepCounter = 0;
        Map<Integer, Boolean> keepMap;
        for (int i = 0; i < count; i++) {
            setData();
            keepChoice(changeMap, i);
        }
        System.out.println("При изменении выбора процент выигрышей составил: " + winCounterChange * 100 / count);
        System.out.println("При сохранении выбора процент выигрышей составил: " + winCounterKeep * 100 / count);
        return winCounterChange > winCounterKeep;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.testParadox();
    }


}
