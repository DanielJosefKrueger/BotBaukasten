package moving;

import java.awt.*;

public class CursorTracker extends Thread{




    @Override
    public void run() {
        super.run();

        while(true)
        {
            PointerInfo a = MouseInfo.getPointerInfo();
            Robot robot = null;
            try {
                robot = new Robot();
            } catch (AWTException e) {
                e.printStackTrace();
            }
            Point b  = a.getLocation();
            System.out.println("X: " + b.getX() + " Y: " + b.getY());
            // Print the RGB information of the pixel color
            Color color = robot.getPixelColor((int)b.getX(), (int)b.getY());
            System.out.println("Red   = " + color.getRed());
            System.out.println("Green = " + color.getGreen());
            System.out.println("Blue  = " + color.getBlue());




            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
