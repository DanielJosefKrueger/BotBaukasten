package main.utils.mouse;

import main.util.Sleeper;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.concurrent.TimeUnit;


public class Clicker {

    Sleeper sleeper = new Sleeper();
      Robot bot;
      int mask = InputEvent.BUTTON1_MASK;


      public Clicker(){
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