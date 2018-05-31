package util;



import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class ScreenCatcher {

    private Robot robot;

    public ScreenCatcher(){
        try {
            this.robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getScreenShot() throws AWTException {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRectangle = new Rectangle(screenSize);
        if (robot != null) {
            return robot.createScreenCapture(screenRectangle);
        }else{
            return null;
        }
    }


    public List<Pixel> getPixelForColor(Robot robot){
        List<Pixel> pixels = new ArrayList<Pixel>();

       return pixels;
    }




    public class Pixel{

        final int x;
        final int y;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public Pixel(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
