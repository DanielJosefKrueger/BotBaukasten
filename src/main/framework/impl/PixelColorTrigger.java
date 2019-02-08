package main.framework.impl;

import main.framework.Trigger;
import main.util.PixelColorFetcher;
import main.util.PixelComparer;

import java.awt.*;


     public class PixelColorTrigger implements Trigger {

        private static PixelColorFetcher fetcher = new PixelColorFetcher();
         private static PixelComparer comparer = new PixelComparer();
         private final int x;
         private final int y;
         private final Color wishedColor;
         private final int acceptedDifference;


         public PixelColorTrigger(int x, int y, Color wishedColor, int acceptedDifference){
             this.x = x;
             this.y = y;
             this.wishedColor = wishedColor;
             this.acceptedDifference = acceptedDifference;
         }

        @Override
        public boolean evaluate() {
            Color color = fetcher.getColorOfPixel(x, y);
            int delta = comparer.compare(wishedColor, color);
            if(delta<acceptedDifference){
                return true;
            }else{
                return false;
            }
        }
    }




