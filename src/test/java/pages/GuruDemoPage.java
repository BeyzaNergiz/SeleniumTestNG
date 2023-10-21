package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class GuruDemoPage {

    public GuruDemoPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(tagName = "iframe")

    public List<WebElement> iframeElementleri;


    @FindBy(xpath = "//iframe[@wmode='transparent']")
    public WebElement ilkIframeElementi;

    @FindBy(xpath = "//button[@aria-label='Oynat']")

    public  WebElement playTusuElementi;

    @FindBy(id="a077aa5e")

    public  WebElement guruIframeElementi;

    @FindBy(xpath = "//img[@src='Jmeter720.png']")

    public WebElement madeEasyButonu;

}
