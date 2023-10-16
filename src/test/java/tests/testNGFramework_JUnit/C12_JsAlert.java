package tests.testNGFramework_JUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HerOkuAppPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C12_JsAlert {

    @Test
    public void jsAlertTesti() {
        //2. Test
        //  -  https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("herOkuAppAlertUrl"));

        //  - 1.alert'e tiklayin
        HerOkuAppPage herOkuAppPage = new HerOkuAppPage();
        herOkuAppPage.alert1Elementi.click();
        ReusableMethods.bekle(2);

        //  -  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String expectedYazi = "I am a JS Alert";
        String actualYazi = Driver.getDriver().switchTo().alert().getText();
        Assert.assertEquals(expectedYazi, actualYazi);

        //  -  OK tusuna basip alert'i kapatin
        Driver.getDriver().switchTo().alert().accept();
    }

    @Test
    public void cancelTesti() {
        //3.Test
        //  - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("herOkuAppAlertUrl"));

        //  - 2.alert'e tiklayalim
        HerOkuAppPage herOkuAppPage = new HerOkuAppPage();
        herOkuAppPage.alert2Elementi.click();

        //  - Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        Driver.getDriver().switchTo().alert().dismiss();
        ReusableMethods.bekle(2);

        String expectedSonucYazisi = "You clicked: Cancel";
        String actualSonucYazisi = herOkuAppPage.cancelYaziElementi.getText();

        Assert.assertEquals(expectedSonucYazisi, actualSonucYazisi);
    }

    @Test
    public void promptTesti() {
        //4.Test
        //  - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("herOkuAppAlertUrl"));

        //  - 3.alert'e tiklayalim
        HerOkuAppPage herOkuAppPage = new HerOkuAppPage();
        herOkuAppPage.alert3Elementi.click();

        //  - Cikan prompt ekranina "Abdullah" yazdiralim
        Driver.getDriver().switchTo().alert().sendKeys("Abdullah");

        //  - OK tusuna basarak alert'i kapatalim
       Driver.getDriver().switchTo().alert().accept();

        //  - Cikan sonuc yazisinin Abdullah icerdigini test edelim

        String actualSonucYazisi = herOkuAppPage.abdullahYaziElementi.getText();
        String expectedIcerik = "Abdullah";

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

        Driver.getDriver().quit();
    }
}
