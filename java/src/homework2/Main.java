package src.homework2;

import src.homework2.Developer;

public class Main {
    public static void main(String[] args) {
        Developer developer = new FrontendDeveloper("Petr", 900.00);
        ((Frontender) developer).developGUI();
    }
}
