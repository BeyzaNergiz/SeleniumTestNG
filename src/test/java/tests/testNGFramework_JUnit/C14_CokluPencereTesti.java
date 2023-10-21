package tests.testNGFramework_JUnit;

import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C14_CokluPencereTesti {

    @Test
    public void test01(){
        // amazon ana sayfaya gidip url'in amazon icerdigini test edin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        String expectedUrlIcerik = "amazon";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        String amazonWhd=Driver.getDriver().getWindowHandle();
        // yeni bir tab'da wisequarter.com'a gidin ve url'in wise icerdigini test edin
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get(ConfigReader.getProperty("wiseUrl"));
        expectedUrlIcerik ="wise";
        actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        String wiseWhd= Driver.getDriver().getWindowHandle();
        // yeni bir pencere olarak youtube'a gidin ve url'in youtube icerdigini test edin
        Driver.getDriver().switchTo().newWindow(WindowType.WINDOW);
        Driver.getDriver().get(ConfigReader.getProperty("youtubeUrl"));
        expectedUrlIcerik = "youtube";
        actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        ReusableMethods.bekle(2);
        // wisequarter'in acik oldugu sayfaya donup title'in Wise icerdigini test edin
        Driver.getDriver().switchTo().window(wiseWhd);
        String expectedTitleIcerik = "Wise";
        String actualTitle = Driver.getDriver().getTitle();
        ReusableMethods.bekle(2);
        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));
        // Amazon'un acik oldugu sayfaya donun ve Title'in Amazon icerdigini test edin
        Driver.getDriver().switchTo().window(amazonWhd);
        expectedTitleIcerik = "Amazon";
        actualTitle =Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));
        ReusableMethods.bekle(2);
        Driver.getDriver().quit();
    }
}
