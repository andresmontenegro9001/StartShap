package co.com.choucair.automation.startshap.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DashboardPage extends PageObject {

    public static final Target DASHBOARD_TITLE = Target.the("Dashboard Title").located(By.xpath ("//ancestor::section[@class='content-header']//*[text()='Dashboard']"));
    public static final Target LINK_ORDERS = Target.the("Link to orders").located(By.xpath ("//a[@href='/demo/Northwind/Order?shippingState=0']"));
    public static final Target ORDERS_TITLE = Target.the("Orders Title").located(By.xpath ("//*[@id='GridDiv']//div[@class='title-text']"));
    public static final Target BUTTON_NEW_ORDER = Target.the("New order button").located(By.xpath ("//*[@id='GridDiv']//*[@class='button-inner']//i[@class='fa fa-plus-circle text-green']"));

}


