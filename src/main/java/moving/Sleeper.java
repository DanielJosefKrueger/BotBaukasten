package moving;

import java.util.Random;

public class Sleeper {

    Random random = new Random();

    public void sleep(int miliseconds) throws InterruptedException {
        int amount = miliseconds + random.nextInt((int) (2 * miliseconds));
        System.out.println("Sleep for "  + amount);
        Thread.sleep(amount);
    }
}
