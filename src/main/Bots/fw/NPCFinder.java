package main.Bots.fw;

import main.utils.mouse.MouseClicker;
import main.utils.mouse.MouseMover;

import java.awt.*;
import java.util.Properties;

public class NPCFinder {

    private final Robot robot;
    private final int topLeftY;
    private final MouseClicker mouseClicker;
    private final int topLeftX;
    private final int personR;
    private final int personG;
    private final int personB;
    private final int angriffR;
    private final int angriffG;
    private final int angriffB;


    private final int distanceYToAttack;

    private int currentX;
    private int currentY;
    private final MouseMover mouseMover;



    private static final int MAXIMUM_Y=1000;
    private static final int MINIMUM_X = -1900;

    NPCFinder(Robot robot, MouseMover mouseMover, MouseClicker mouseClicker, Properties properties){
        this.robot = robot;
        this.mouseMover = mouseMover;
        this.mouseClicker = mouseClicker;
        topLeftX = Integer.parseInt(properties.getProperty(FwConstants.TOP_LEFT_X));
        topLeftY = Integer.parseInt( properties.getProperty(FwConstants.TOP_LEFT_Y));
        personR = Integer.parseInt( properties.getProperty(FwConstants.PERSON_LABEL_RED));
        personG = Integer.parseInt( properties.getProperty(FwConstants.PERSON_LABEL_GREEN));
        personB = Integer.parseInt( properties.getProperty(FwConstants.PERSON_LABEL_BLUE));

        angriffR = Integer.parseInt( properties.getProperty(FwConstants.ANGRIFF_LABEL_RED));
        angriffG = Integer.parseInt( properties.getProperty(FwConstants.ANGRIFF_LABEL_GREEN));
        angriffB = Integer.parseInt( properties.getProperty(FwConstants.ANGRIFF_LABEL_BLUE));
        distanceYToAttack= Integer.parseInt( properties.getProperty(FwConstants.ANGRIFF_Y_DISTANCE));

    }



    public boolean findNPCAttack(){
        currentX =topLeftX;
        currentY = topLeftY;
        //demark
        try {
            mouseClicker.clickLeftOnPixel(topLeftX, topLeftY);
        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }

        while(!fitsToPersontab()){
            currentY++;
          //  mouseMover.move(currentX,currentY);
            if(currentY > MAXIMUM_Y){
                System.out.println("Couldnt find person tab");
                return false;
            }
        }



        currentY += distanceYToAttack;
        mouseMover.move(currentX,currentY);


        while(!fitsToAttack()){
            currentX-=2;
           // mouseMover.move(currentX,currentY);
            if(currentX< MINIMUM_X){
                System.out.println("Couldnt find Attack Button");
                return false;
            }
        }

        mouseMover.move(currentX,currentY);
        return true;


    }

    private boolean fitsToPersontab(){
        Color pixelColor = robot.getPixelColor(currentX, currentY);

        int diff =0;
        diff +=Math.abs(pixelColor.getRed()-personR);
        diff +=Math.abs(pixelColor.getGreen()-personG);
        diff +=Math.abs(pixelColor.getBlue()-personB) ;
        System.out.println(diff);
        return diff < 70;
    }

    private boolean fitsToAttack(){
        Color pixelColor = robot.getPixelColor(currentX, currentY);
        int diff =0;
        diff +=Math.abs(pixelColor.getRed()-angriffR);
        diff +=Math.abs(pixelColor.getGreen()-angriffG);
        diff +=Math.abs(pixelColor.getBlue()-angriffB) ;
        System.out.println("AngriffsbuttonDifferenz: "+diff);
        return diff < 20;

    }
}
