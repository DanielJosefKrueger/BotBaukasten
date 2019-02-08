package main.Bots.fw;

import main.utils.clipboard.ClipboardUtil;
import main.utils.keyboard.KeyPresser;
import main.utils.loading.PropertyLoader;
import main.utils.mouse.MouseClicker;
import main.utils.mouse.MouseMover;
import main.utils.ocr.OCRModul;
import main.utils.screen.ScreenCatcher;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;


public class FwBot {

    private  Robot robot;
    private final PropertyLoader loader;
    private final Properties properties;
    private final ScreenCatcher screenCatcher;
    private final Rectangle hpRechtangle;
    private final JFrame frame;
    private final KeyPresser keyPresser;
    private final ClipboardUtil clipboardUtil;
    private final MouseClicker mouseClicker;
    private final NPCFinder npcFinder;
    private final MouseMover mouseMover;
    FwBot() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            robot = null;
        }
        mouseMover = new MouseMover();
        clipboardUtil = new ClipboardUtil();
        mouseClicker = new MouseClicker();
        keyPresser = new KeyPresser();
        loader = new PropertyLoader();
        properties = loader.loadProperties(new File("configuration/fw.txt"));
        screenCatcher = new ScreenCatcher();
        hpRechtangle = new Rectangle(Integer.parseInt(properties.getProperty(FwConstants.HP_X_TOP_LEFT)),
                Integer.parseInt(properties.getProperty(FwConstants.HP_Y_TOP_LEFT)),
                Integer.parseInt(properties.getProperty(FwConstants.HP_WIDTH)),
                Integer.parseInt(properties.getProperty(FwConstants.HP_HEIGHT)));
        frame = new JFrame();
        frame.getContentPane().setLayout(new FlowLayout());
        frame.pack();
        frame.setVisible(true);

        npcFinder= new NPCFinder(robot,mouseMover, mouseClicker,properties);
    }


    public int getHitPointsNew() {

        try {

            clipboardUtil.clear();
            mouseClicker.clickLeftOnPixel(Integer.parseInt(properties.getProperty(FwConstants.HP_X_TOP_LEFT)),
                    Integer.parseInt(properties.getProperty(FwConstants.HP_Y_TOP_LEFT)));
            keyPresser.copy();

            String clipCoard = clipboardUtil.getClipCoard();
            //System.out.println(clipCoard);

            for (String line : clipCoard.split("\n")) {
                if(line.startsWith("Lebenspunkte")){
                 //   System.out.println(line);
                    String brackets = line.substring(line.indexOf("(")+1, line.indexOf(")"));
                  //  System.out.println(brackets);
                    return Integer.valueOf(brackets.substring(0, brackets.indexOf("/")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    public int getAttackPower() {

        try {

            clipboardUtil.clear();
            mouseClicker.clickLeftOnPixel(Integer.parseInt(properties.getProperty(FwConstants.MAIN_X)),
                    Integer.parseInt(properties.getProperty(FwConstants.MAIN_Y)));
            keyPresser.copy();

            String clipCoard = clipboardUtil.getClipCoard();
            //System.out.println(clipCoard);

            for (String line : clipCoard.split("\n")) {
                if(line.contains("Angriffsstärke")){
                      // System.out.println(line);


                    String brackets = line.substring(line.indexOf("Angriffsstärke")+1, line.lastIndexOf("."));
                     //System.out.println(brackets);
                    return Integer.valueOf(brackets.substring(brackets.indexOf(":")+1, brackets.length()).trim());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    public void moveToAttack(){
        npcFinder.findNPCAttack();

    }


    public static void main(String[] args) {

        FwBot bot = new FwBot();
        System.out.println(bot.getHitPointsNew());
        System.out.println(bot.getAttackPower());
        bot.moveToAttack();

    }


}
