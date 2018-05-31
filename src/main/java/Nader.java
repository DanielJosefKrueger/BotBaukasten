import com.sun.org.apache.xpath.internal.SourceTree;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;


public class Nader {

    static final int gKey = KeyEvent.VK_G;

    Robot bot;
    Nader(){

        try {
            bot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }


    public void nade() throws InterruptedException {

        bot.keyPress(gKey);
        TimeUnit.MILLISECONDS.sleep(50);
        bot.keyRelease(gKey);
    }


    public static void main(String[] args) throws Exception {

        Clicker clicker = new Clicker();
        Nader nader = new Nader();

        TimeUnit.SECONDS.sleep(5);


        Mover mover = new Mover();
        mover.start();


        while(true){
            nader.nade();
           // clicker.click();
        }
}




}