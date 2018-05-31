package moving;

import java.awt.*;

public class PixelComparer {




    public int compare(Color first, Color second){
        int diffR = (int)Math.pow(first.getRed() - second.getRed(),2);
        int diffG = (int)Math.pow(first.getGreen() - second.getGreen(),2);
        int diffB = (int)Math.pow(first.getBlue() - second.getBlue(),2);
        int sqrt = (int) Math.sqrt(diffB+diffG+diffR);
        System.out.println(diffB+diffG+diffR +"wurzel:"+ sqrt);
        return sqrt;
    }


}
