package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SauceDemoPage {

    public SauceDemoPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//input[@id='user-name']")
    public WebElement userNameKutusu;


    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordKutusu;


    @FindBy(xpath = "//input[@id='login-button']")
    public WebElement loginKutusu;


    @FindBy(xpath = "//div[normalize-space()='Sauce Labs Backpack']")
    public WebElement ilkUrunElementi;


    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    public WebElement addToCartButton;


    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    public WebElement urunSepeti;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    public WebElement secilenUrununGorunurluk;


}
