package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {
    public FacebookPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "email")
    public WebElement emailKutusu;

    @FindBy(xpath = "//input[@id='u_2_b_CF']")
    public WebElement userNameBox;

    @FindBy(id="pass")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement loginButonu;

   @FindBy(xpath = "//*[@*='Allow all cookies']")
   public WebElement cookiesButton;

    @FindBy(linkText = "Hesabını bul ve giriş yap.")
    public WebElement girisYapilamadiYaziElementi;

    @FindBy(xpath = "//*[@*='open-registration-form-button']")
    public WebElement createAccountButton;

    @FindBy(xpath = "(//input[@*='_8esa'])[1]")
    public WebElement femaleRadioButton;

    @FindBy(xpath = "(//input[@*='_8esa'])[2]")
    public WebElement maleRadioButton;

    @FindBy(xpath = "(//input[@*='_8esa'])[3]")
    public WebElement customRadioButton;



}
