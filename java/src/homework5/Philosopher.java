package src.homework5;

import java.util.concurrent.Semaphore;

public class Philosopher implements Runnable {
    String name;
    Semaphore semaphore;

    public Philosopher(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        int i = 1;
        while (i <= 3) {
            System.out.printf("%s is ready to eat for the %d time\n", this.name, i);
            try {
                semaphore.acquire();
                eat();
                System.out.printf("%s finished eating for the %d time\n", this.name, i);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                semaphore.release();
            }
            think();
            i++;
        }
    }

    void eat() throws InterruptedException {
        System.out.println(this.name + " is eating");
        Thread.sleep(500);
    }

    void think() {
        System.out.println(name + " is thinking");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
