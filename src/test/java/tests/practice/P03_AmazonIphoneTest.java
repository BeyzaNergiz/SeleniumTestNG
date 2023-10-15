package tests.practice;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class P03_AmazonIphoneTest {

    @Test
    public void amazonTest(){

        // iPhone 15 PRO icin arama yapin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // Arama kutusunun locator'ina ihtiyacimiz var
        // locator'larimiz artik pages class'larinda
        // Locator'lar static olmadigi icin obje olusturarak kullanabiliriz
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("iPhone 15 PRO"+ Keys.ENTER);

        String expectedIcerik = "iPhone 15 PRO";
        String actualResult = amazonPage.sonucYaziElementi.getText();
        Assert.assertTrue(actualResult.contains(expectedIcerik));

        Driver.closeDriver();
    }
}
