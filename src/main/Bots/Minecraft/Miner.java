package main.Bots.Minecraft;

import main.utils.keyboard.KeyPresser;
import main.utils.mouse.Clicker;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Miner {
    private KeyPresser keyPresser;
    private int numberPickAxt=0;
    private static final int MINUTES_PICKAXT = 1;
    private Robot robot = new Robot();


    private Miner() throws AWTException {
        numberPickAxt=0;
        keyPresser = new KeyPresser();
    }




    public static void main(String[] args) throws AWTException, InterruptedException {
        Miner miner = new Miner();
        miner.start();
    }

    public void start() throws InterruptedException {
        Thread.sleep(10000);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        while (true){
            nextPickAxt();
            Thread.sleep(MINUTES_PICKAXT* 60 * 1000);
        }
    }


    public  void nextPickAxt() throws InterruptedException {
        if(numberPickAxt > 9){
            System.out.println("Finished");
            System.exit(0);
        }
        keyPresser.pressButton(KeyEvent.VK_1 + numberPickAxt);
        numberPickAxt++;
    }

}
