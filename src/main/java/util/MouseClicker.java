package util;

import util.Sleeper;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Random;

public class MouseClicker {

    private final Random random = new Random();
    private final Sleeper sleeper = new Sleeper();


    public void clickLeftOnPixel(int x, int y) throws AWTException, InterruptedException {
        Robot robot = new Robot();
        robot.mouseMove(x, y);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        sleeper.sleep(200);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    public void clickLeftOnPixelWithDeviation(int x, int y) throws AWTException, InterruptedException {
        int deviationX =  random.nextInt(20)-10;
        int deviationY =  random.nextInt(20)-10;
        clickLeftOnPixel( x + deviationX ,  y+deviationY);
    }


}
