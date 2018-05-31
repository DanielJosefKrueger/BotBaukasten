import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Listener extends Thread{

    private final ToggleCallback toggleCallback;

    public Listener(ToggleCallback toggleCallback) {
        this.toggleCallback = toggleCallback;
    }


    public void run() {

        Scanner in = new Scanner(System.in);

        while(true){

          int anInt = in.nextInt();
            if(anInt == 'q'){
                toggleCallback.OnClick();
            }
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }



    }
}
