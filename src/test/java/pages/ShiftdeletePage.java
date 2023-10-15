package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ShiftdeletePage {
    public ShiftdeletePage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath = "//iframe[@class='latestVideoEmbed']")
    public WebElement iframeElementi;

    @FindBy(xpath = "//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")
    public WebElement playElementi;

    @FindBy(xpath = "//a[@class='ytp-watermark yt-uix-sessionlink']")
    public WebElement sagAltPlayElementi;



    @FindBy(id = "xbSearch")
    public WebElement aramaKutusuElementi;


}
