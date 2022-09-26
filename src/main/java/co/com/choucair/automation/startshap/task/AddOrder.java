package co.com.choucair.automation.startshap.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.choucair.automation.startshap.userinterface.DashboardPage.BUTTON_NEW_ORDER;

public class AddOrder implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BUTTON_NEW_ORDER)
        );
    }

    public static AddOrder fill(){
        return Tasks.instrumented(AddOrder.class);
    }
}
