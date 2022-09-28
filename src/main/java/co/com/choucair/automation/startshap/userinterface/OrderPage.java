package co.com.choucair.automation.startshap.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class OrderPage extends PageObject {

    public static final Target SELECT_CUSTOMER = Target.the("Select customer").located(By.xpath("//*[@class='field CustomerID']//a"));
    public static final Target INPUT_SEARCH_CUSTOMER = Target.the("box to search customer").located(By.xpath("//div[@class='select2-search']//label[text()= '*Customer']/following-sibling::input"));
    public static final Target ORDER_DATE = Target.the("Date order").located(By.name("OrderDate"));
    public static final Target REQUIRED_DATE = Target.the("Required order").located(By.name("RequiredDate"));
    public static final Target SELECT_EMPLOYEE = Target.the("Select employee").located(By.xpath("//*[@class='field EmployeeID']//a"));
    public static final Target INPUT_SEARCH_EMPLOYEE = Target.the("box to search employee").located(By.xpath("//div[@class='select2-search']//label[text()= 'Employee']/following-sibling::input"));

    public static final Target BUTTON_NEW_ORDER_DETAIL = Target.the("New order detail button").located(By.xpath("//*[@class='field DetailList']//*[@class='button-inner']//i[@class='fa fa-plus-circle text-green']"));
    public static final Target SELECT_PRODUCT = Target.the("Select product").located(By.xpath("//*[@class='field ProductID']//a"));
    public static final Target INPUT_UNIT_PRICE = Target.the("Input unit price").located(By.name("UnitPrice"));
    public static final Target INPUT_SEARCH_PRODUCT = Target.the("Input search product").located(By.xpath("//div[@class='select2-search']//label[text()= '*Product']/following-sibling::input"));
    public static final Target INPUT_QUANTITY = Target.the("Input quantity").located(By.name("Quantity"));
    public static final Target INPUT_DISCOUNT = Target.the("Input discount").located(By.name("Discount"));
    public static final Target BUTTON_SAVE_NEW_ORDER_DETAIL = Target.the("Button save order detail").located(By.xpath("//*[@class='s-TemplatedDialog ui-dialog-content ui-widget-content']//i[@class='fa fa-check-circle text-purple']"));

}
