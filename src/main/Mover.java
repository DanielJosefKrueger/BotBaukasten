package main;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class Mover extends Thread{

    static final int aKey = KeyEvent.VK_A;
    static final int dKey = KeyEvent.VK_D;

    @Override
    public void run() {


        Robot bot = null;

        boolean directionLeft = true;
        while (true) {

            try {
                bot = new Robot();
            } catch (AWTException e) {
                e.printStackTrace();
            }

            if (directionLeft) {
                bot.keyPress(aKey);
            } else {
                bot.keyPress(dKey);
            }

            try {
                TimeUnit.MILLISECONDS.sleep(1250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            if (directionLeft) {
                bot.keyRelease(aKey);
            } else {
                bot.keyRelease(dKey);
            }
            directionLeft = !directionLeft;
        }
    }
}
