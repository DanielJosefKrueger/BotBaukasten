package main.utils.keyboard;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class KeyPresser {


    static final int G = KeyEvent.VK_G;
    static final int A = KeyEvent.VK_A;
    static final int C = KeyEvent.VK_C;


    static final int COMMAND= KeyEvent.VK_CONTROL;

    Robot bot;
    public KeyPresser(){

        try {
            bot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }






    public void markAll() throws InterruptedException {
        bot.keyPress(COMMAND);
        bot.keyPress(A);

        TimeUnit.MILLISECONDS.sleep(50);
        bot.keyRelease(A);
        bot.keyRelease(COMMAND);
    }

    public void copy() throws InterruptedException {
        markAll();



        bot.keyPress(COMMAND);
        bot.keyPress(C);

        TimeUnit.MILLISECONDS.sleep(50);
        bot.keyRelease(C);
        bot.keyRelease(COMMAND);
    }

}
