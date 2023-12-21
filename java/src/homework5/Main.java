package src.homework5;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        Thread philosipher1 = new Thread(new Philosopher("Aristotle", semaphore));
        Thread philosipher2 = new Thread(new Philosopher("Seneca", semaphore));
        Thread philosipher3 = new Thread(new Philosopher("Marcus Aurelius", semaphore));
        Thread philosipher4 = new Thread(new Philosopher("Lao Zi", semaphore));
        Thread philosipher5 = new Thread(new Philosopher("Confucius", semaphore));

        philosipher1.start();
        philosipher2.start();
        philosipher3.start();
        philosipher4.start();
        philosipher5.start();
    }
}
