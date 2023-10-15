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
}
