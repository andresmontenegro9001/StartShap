package co.com.choucair.automation.startshap.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import org.awaitility.Awaitility;

import java.util.concurrent.TimeUnit;

public class Wait implements Interaction {

    private int unit;

    public Wait(int unit) {
        this.unit = unit;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Awaitility.await().atLeast(unit, TimeUnit.SECONDS);
    }

    public static Wait trigger(int unit){
        return Tasks.instrumented(Wait.class, unit);
    }
}
