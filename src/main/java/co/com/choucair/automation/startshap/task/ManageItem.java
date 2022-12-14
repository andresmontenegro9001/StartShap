package co.com.choucair.automation.startshap.task;

import co.com.choucair.automation.startshap.utils.TypeObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ManageItem implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(ManageItem.class);

    private String typeObject;
    private Target selector;
    private Target input;
    private String data;

    public ManageItem(String typeObject, Target selector, Target input, String data) {
        this.typeObject = typeObject;
        this.selector = selector;
        this.input = input;
        this.data = data;
    }

    public ManageItem(String typeObject, Target input, String data) {
        this.typeObject = typeObject;
        this.input = input;
        this.data = data;
    }

    public ManageItem(String typeObject, Target selector) {
        this.typeObject = typeObject;
        this.selector = selector;
    }

    public static ManageItem goSelect(String typeObject, Target selector, Target input, String data) {
        return Tasks.instrumented(ManageItem.class, typeObject, selector, input, data);
    }

    public static ManageItem goInput(String typeObject, Target input, String data) {
        return Tasks.instrumented(ManageItem.class, typeObject, input, data);
    }

    public static ManageItem goButton(String typeObject, Target selector) {
        return Tasks.instrumented(ManageItem.class, typeObject, selector);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (typeObject) {
            case TypeObject.SELECT:
                executeSelect(actor);
                break;
            case TypeObject.INPUT_FILLED:
                executeInputFilled(actor);
                break;
            case TypeObject.INPUT_EMPTY:
                executeInputEmpty(actor);
                break;
            case TypeObject.BUTTON:
                executeButton(actor);
                break;
            default:
                LOGGER.error("Please check TypeObject used ManageItem ");
                break;
        }
    }

    private <T extends Actor> void executeButton(T actor) {
        actor.attemptsTo(
                MoveMouse.to(this.selector),
                Click.on(this.selector)
        );
    }

    private <T extends Actor> void executeInputEmpty(T actor) {
        actor.attemptsTo(
                MoveMouse.to(this.input),
                SendKeys.of(this.data).into(this.input)
        );
    }

    private <T extends Actor> void executeInputFilled(T actor) {
        actor.attemptsTo(
                MoveMouse.to(this.input),
                Clear.field(this.input),
                SendKeys.of(this.data).into(this.input)
        );
    }

    private <T extends Actor> void executeSelect(T actor) {
        actor.attemptsTo(
                Click.on(this.selector),
                MoveMouse.to(this.input),
                SendKeys.of(this.data).into(this.input),
                SendKeys.of(Keys.ENTER).into(this.input)
        );
    }

}
