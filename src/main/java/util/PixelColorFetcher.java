package util;

import java.awt.*;

public class PixelColorFetcher {


    public Color getColorOfPixel(int x, int y){
        try{
            Robot robot = new Robot();
            return robot.getPixelColor(x, y);

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

}


}
