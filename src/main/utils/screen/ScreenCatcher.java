package main.utils.screen;



import java.awt.*;
import java.awt.image.BufferedImage;

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

    public BufferedImage getScreenSection( Rectangle screenRectangle ) throws AWTException {
        if (robot != null) {
            return robot.createScreenCapture(screenRectangle);
        }else{
            return null;
        }
    }

    public BufferedImage getScreenSectionBW( Rectangle screenRectangle ) throws AWTException {
        BufferedImage screenSection = getScreenSection(screenRectangle);
        return new BufferedImage(screenSection.getWidth(), screenSection.getHeight(),
                BufferedImage.TYPE_BYTE_BINARY);
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
