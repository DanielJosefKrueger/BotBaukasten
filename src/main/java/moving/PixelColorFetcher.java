package moving;

import java.awt.*;

public class PixelColorFetcher {


    public Color getColorOfPixel(int x, int y) throws AWTException {
        Robot robot = new Robot();
        return robot.getPixelColor(x, y);
    }


}
