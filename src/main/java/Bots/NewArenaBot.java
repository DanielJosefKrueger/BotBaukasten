package Bots;

import framework.Action;
import framework.ActionQueue;
import framework.Trigger;
import framework.impl.LeftClickAction;
import framework.impl.PixelColorTrigger;
import moving.ArenaBot;
import util.MouseClicker;
import util.PixelColorFetcher;
import util.PixelComparer;
import util.Sleeper;

import java.awt.*;

public class NewArenaBot {



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
        NewArenaBot arenaBot = new NewArenaBot();
        arenaBot.runBot();
    }










    public void runBot()throws Exception{

        ActionQueue actionQueue = new ActionQueue(2000, 2000);
        Trigger blueOkTrigger = new PixelColorTrigger(X_BLUE_OK_BUTTON, Y_BLUE_OK_Button, COLOR_BLUE_OK_BUTTON, DELTA_MAX_BLUE_OK_BUTTON);
        Action blueOkPress = new LeftClickAction(X_BLUE_OK_BUTTON,Y_BLUE_OK_Button );
        actionQueue.addActionsForTrigger( blueOkPress, blueOkTrigger);

        Trigger redOkTrigger = new PixelColorTrigger(X_RED_OK_BUTTON, Y_RED_OK_Button, COLOR_RED_OK_BUTTON, DELTA_MAX_RED_OK_BUTTON);
        Action redOkPress = new LeftClickAction(X_RED_OK_BUTTON,Y_RED_OK_Button );
        actionQueue.addActionsForTrigger( redOkPress, redOkTrigger);


        Trigger startTrigger = new PixelColorTrigger(X_START_BUTTON, Y_START_Button,  COLOR_START_BUTTON, DELTA_MAX_START_BUTTON);
        Action startPress = new LeftClickAction(X_START_BUTTON,Y_START_Button );
        actionQueue.addActionsForTrigger( startPress, startTrigger);

        actionQueue.start();

    }



}
