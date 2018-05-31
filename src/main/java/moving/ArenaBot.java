package moving;

import util.MouseClicker;
import util.PixelColorFetcher;
import util.PixelComparer;
import util.Sleeper;

import java.awt.*;

public class ArenaBot {


    private static int X_BLUE_OK_BUTTON = 939;
    private static int Y_BLUE_OK_Button = 650;
    private static int RED_BLUE_OK_BUTTON = 5;
    private static int GREEN_BLUE_OK_BUTTON = 108;
    private static int BLUE_BLUE_OK_BUTTON = 168;
    private static Color COLOR_BLUE_OK_BUTTON = new Color(RED_BLUE_OK_BUTTON,GREEN_BLUE_OK_BUTTON, BLUE_BLUE_OK_BUTTON );
    private final int DELTA_MAX_BLUE_OK_BUTTON = 30;


    private static int X_RED_OK_BUTTON = 911;
    private static int Y_RED_OK_Button = 681;
    private static int RED_RED_OK_BUTTON = 165;
    private static int GREEN_RED_OK_BUTTON = 61;
    private static int BLUE_RED_OK_BUTTON = 24;
    private static Color COLOR_RED_OK_BUTTON = new Color(RED_RED_OK_BUTTON,GREEN_RED_OK_BUTTON, BLUE_RED_OK_BUTTON );
    private final int DELTA_MAX_RED_OK_BUTTON = 30;


    private static int X_START_BUTTON = 685;
    private static int Y_START_Button = 855;
    private static int RED_START_BUTTON = 208;
    private static int GREEN_START_BUTTON = 161;
    private static int BLUE_START_BUTTON = 20;
    private static Color COLOR_START_BUTTON = new Color(RED_START_BUTTON,GREEN_START_BUTTON, BLUE_START_BUTTON );
    private final int DELTA_MAX_START_BUTTON = 30;


    private final PixelColorFetcher fetcher = new PixelColorFetcher();
    private final MouseClicker mouseClicker = new MouseClicker();
    private final PixelComparer comparer = new PixelComparer();
    private final Sleeper sleeper = new Sleeper();




    public static void main(String[] args) throws Exception{


       // ScreenCatcher catcher = new ScreenCatcher();
      //  BufferedImage screenShot = catcher.getScreenShot();

       // CursorTracker tracker = new CursorTracker();
       // tracker.start();


        ArenaBot arenaBot = new ArenaBot();
        arenaBot.runBot();

    }




    public void runBot()throws Exception{
        while(true){
            if(checkBlueBotton()) {
                System.out.println("Clicking ok to progress to next round");
                sleeper.sleep(2000);
                mouseClicker.clickLeftOnPixelWithDeviation(X_BLUE_OK_BUTTON, Y_BLUE_OK_Button);
            }

            if(checkRedOkBotton()) {
                sleeper.sleep(2000);
                mouseClicker.clickLeftOnPixelWithDeviation(X_RED_OK_BUTTON, Y_RED_OK_Button);
            }

            if(checkStartBotton()) {
                sleeper.sleep(2000);
                mouseClicker.clickLeftOnPixelWithDeviation(X_START_BUTTON, Y_START_Button);
            }
            sleeper.sleep(1000);
        }
    }


    private boolean checkBlueBotton() throws AWTException {
        Color color = fetcher.getColorOfPixel(X_BLUE_OK_BUTTON, Y_BLUE_OK_Button);
        int delta = comparer.compare(COLOR_BLUE_OK_BUTTON, color);
        if(delta<DELTA_MAX_BLUE_OK_BUTTON){
            return true;
        }else{
            return false;
        }
    }


    private boolean checkRedOkBotton() throws AWTException {
        Color color = fetcher.getColorOfPixel(X_RED_OK_BUTTON, Y_RED_OK_Button);
        int delta = comparer.compare(COLOR_RED_OK_BUTTON, color);
        if(delta<DELTA_MAX_RED_OK_BUTTON){
            return true;
        }else{
            return false;
        }
    }

    private boolean checkStartBotton() throws AWTException {
        Color color = fetcher.getColorOfPixel(X_START_BUTTON, Y_START_Button);
        int delta = comparer.compare(COLOR_START_BUTTON, color);
        if(delta<DELTA_MAX_START_BUTTON){
            return true;
        }else{
            return false;
        }
    }




}
