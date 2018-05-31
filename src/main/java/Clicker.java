import moving.Sleeper;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.awt.AWTEvent;
import java.awt.MouseInfo;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;


public class Clicker {

    Sleeper sleeper = new Sleeper();
      Robot bot;
      int mask = InputEvent.BUTTON1_MASK;


      Clicker(){
          try {
              bot = new Robot();
          } catch (AWTException e) {
              e.printStackTrace();
          }
      }

    public  void click() throws Exception{
        bot.mousePress(mask);
        sleeper.sleep(100);
        bot.mouseRelease(mask);
    }



    public static void main(String[] args) throws Exception {
        TimeUnit.SECONDS.sleep(5);
        Clicker clicker= new Clicker();
        while(true){
           clicker.click();
        }
}
}