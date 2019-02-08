package main.util;

import java.util.Random;

public class Sleeper {

    Random random = new Random();

    public void sleep(int miliseconds)  {
        int amount = miliseconds + random.nextInt((int) (2 * miliseconds));
        System.out.println("Sleep for "  + amount);
        try {
            Thread.sleep(amount);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
