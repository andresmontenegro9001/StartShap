package co.com.choucair.automation.startshap.task;

import co.com.choucair.automation.startshap.models.DetailOrder;
import co.com.choucair.automation.startshap.utils.TypeObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static co.com.choucair.automation.startshap.userinterface.OrderPage.*;

public class AddDetailOrder implements Task {

    private Map<String, String> map;
    private DetailOrder detailOrder;

    public AddDetailOrder(List<Map<String, String>> params) {
        this.map = new HashMap<>();
        this.map = params.get(0);
        ObjectMapper mapper = new ObjectMapper();
        this.detailOrder =  mapper.convertValue(map, DetailOrder.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ManageItem.goButton(TypeObject.BUTTON, BUTTON_NEW_ORDER_DETAIL),
                ManageItem.goSelect(TypeObject.SELECT, SELECT_PRODUCT, INPUT_SEARCH_PRODUCT, this.detailOrder.getProduct()),
                ManageItem.goInput(TypeObject.INPUT_FILLED, INPUT_UNIT_PRICE, this.detailOrder.getUnitPrice()),
                ManageItem.goInput(TypeObject.INPUT_FILLED, INPUT_QUANTITY, this.detailOrder.getQuantity()),
                ManageItem.goInput(TypeObject.INPUT_FILLED, INPUT_DISCOUNT, this.detailOrder.getDiscount()),
                ManageItem.goButton(TypeObject.BUTTON, BUTTON_SAVE_NEW_ORDER_DETAIL)
        );
    }

    public static AddDetailOrder fill(List<Map<String, String>> params){
        return Tasks.instrumented(AddDetailOrder.class, params);
    }
}
