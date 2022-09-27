package co.com.choucair.automation.startshap.utils;

public class StopExecution {

    private StopExecution(){

    }

    public static void stop(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }

    }
}
