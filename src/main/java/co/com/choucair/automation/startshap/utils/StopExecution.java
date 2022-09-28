package co.com.choucair.automation.startshap.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StopExecution {

    private static final Logger LOGGER= LoggerFactory.getLogger(StopExecution.class);

    private StopExecution(){

    }

    public static void stop(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LOGGER.error("Fail in stop execution", e);
        }

    }
}
