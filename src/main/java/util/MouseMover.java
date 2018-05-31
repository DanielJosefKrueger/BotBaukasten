package util;

import java.awt.*;

public class MouseMover {

    Robot robot;

    MouseMover(){
        try {
            robot = new Robot();
        } catch (AWTException e) {
            robot =null;
            e.printStackTrace();
        }
    }

   public void move(int xe, int ye){
       PointerInfo info = MouseInfo.getPointerInfo();
       int xa = (int) info.getLocation().getX();
       int ya=  (int) info.getLocation().getY();

        int xm = (xa+xe)/2;
        int ym = (ya + ye)/2;


       int deltaXSquare = (int)Math.pow(xa-xm,2);
       int deltaYSquare = (int)Math.pow(ya-ym,2);


       int r = (int) Math.sqrt(deltaXSquare + deltaYSquare);

       System.out.println("Anfang: x:" +xa + "y:" + ya + "\nMittelpunkt: x:" +xm + "y:" +ym + "\nEndpunkt: x" +xe+"y:"+ye + "\nRadius: " + r);
       moveOnCurve( xm,  ym, ya,   r, xe, ye);


    }


    private void moveOnCurve(int xm, int ym,int ya,  int r,int xe,int ye){

       float numberOfSteps =10;

       float deltaY = ym-ya;
       float stepY = deltaY /numberOfSteps;

       float currenty = ya;
       for(int i =0; i < numberOfSteps*2; i++){
           currenty += stepY;
           float currentX = findXforGivenYOnCurve(xm, ym, r, (int)currenty, xe);
           System.out.println("Move to x:" +(int)currentX +"y" + (int)currenty);
           robot.mouseMove((int)currentX, (int)currenty);
           try {
               Thread.sleep(20);

           } catch (InterruptedException e) {
               e.printStackTrace();
           }

       }



    }


    private int findXforGivenYOnCurve(int xm, int ym, int r, int y,int xe){
       int deltaY = ym - y;

        int deltaX = (int) Math.sqrt(r * r - deltaY * deltaY);

        if(xe<xm){
            return xm - deltaX;
        }else{
            return xm + deltaX;
        }


    }


    public static void main(String[] args) {

        MouseMover mover = new MouseMover();

        mover.move(0, 0);


    }



}
