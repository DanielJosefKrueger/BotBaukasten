package main.Bots.WWBarbar;

import main.utils.keyboard.KeyPresser;
import main.utils.mouse.MouseClicker;

import java.awt.*;
import java.awt.event.KeyEvent;


public class WWBarbarMain {

    Robot bot = new Robot();

    public WWBarbarMain() throws AWTException {
    }

    public static void main(String[] args) throws InterruptedException, AWTException {
       Robot robot = new Robot();

        while(true){
            robot.keyPress(KeyEvent.VK_W);
            Thread.sleep(30000);
        }
    }







}
