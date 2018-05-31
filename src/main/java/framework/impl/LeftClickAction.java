package framework.impl;

import framework.Action;
import util.MouseClicker;

import java.awt.*;

public class LeftClickAction implements Action{

    private static final MouseClicker mouseClicker = new MouseClicker();
    private final int x;
    private final int y;

    public LeftClickAction(int x, int y){


        this.x = x;
        this.y = y;
    }



    @Override
    public boolean onTrigger() {
        try {
            mouseClicker.clickLeftOnPixelWithDeviation(x, y);
            return true;
        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }
}
