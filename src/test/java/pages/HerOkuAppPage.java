package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HerOkuAppPage {

    public HerOkuAppPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(tagName = "h3")
    public WebElement iFrameYaziElementi;

    @FindBy(xpath = "//*[@id='mce_0_ifr']")
    public WebElement iframe;

    @FindBy(tagName = "p")
    public WebElement textBox;

    @FindBy(linkText = "Elemental Selenium")
    public WebElement elementalLinki;

    @FindBy(xpath = "(//input[@type='checkbox'])[1]")
    public WebElement checkBox1;


    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    public WebElement checkBox2;


    @FindBy(xpath = "//*[text()='Click for JS Alert']")
    public WebElement alert1Elementi;


    @FindBy(xpath = "//*[text()='Click for JS Confirm']")
    public WebElement alert2Elementi;


    @FindBy(xpath = "//*[@id='result']")
    public WebElement cancelYaziElementi;

    @FindBy(xpath = "//*[text()='Click for JS Prompt']")
    public WebElement alert3Elementi;

    @FindBy(xpath = "//p[@style='color:green']")
    public WebElement abdullahYaziElementi;

    @FindBy(tagName = "h3")
    public WebElement iframeYaziElementi;

    @FindBy(id = "mce_0_ifr")
    public WebElement ilkiframeElementi;

    @FindBy(tagName = "p")
    public WebElement textBoxKutuElementi;

    @FindBy(linkText = "Elemental Selenium")
    public WebElement elementalSeleniumYaziElementi;

    @FindBy(tagName = "h3")
    public WebElement openingBaslikElementi;

    @FindBy(linkText = "Click Here")
    public WebElement clickElementi;

    @FindBy(tagName = "h3")
    public WebElement newWindowElementi;

}
