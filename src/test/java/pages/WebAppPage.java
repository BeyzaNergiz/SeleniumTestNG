package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WebAppPage {

    public WebAppPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[@id='signin_button']")
    public WebElement signinButonu;

    @FindBy(xpath = "//input[@id='user_login']")
    public WebElement usernameButonu;

    @FindBy(xpath = "//input[@id='user_password']")
    public WebElement passwordButonu;

    @FindBy(xpath = "//input[@name='submit']")
    public WebElement signinButonu2;

    @FindBy(xpath = "//strong[text()='Online Banking']")
    public WebElement onlineBanking;

    @FindBy(xpath = "//span[@id='pay_bills_link']")
    public WebElement payBills;

    @FindBy(xpath = "//a[text()='Purchase Foreign Currency']")
    public WebElement purchaseForeignCurrency;

    @FindBy(id = "pc_currency")
    public WebElement pcCurrencyDropdown;

}
