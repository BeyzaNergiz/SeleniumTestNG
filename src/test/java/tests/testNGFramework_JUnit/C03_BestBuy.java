package tests.testNGFramework_JUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BestBuyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_BestBuy {


    @Test(priority = 1)
    public void bestBuyTest() {
        //o Sayfa URL’inin https://www.bestbuy.com/ ‘a eşit olduğunu test edin
        Driver.getDriver().get(ConfigReader.getProperty("bestBuyUrl"));

        String expectedUrl = ConfigReader.getProperty("bestBuyUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(actualUrl, expectedUrl, "İstenen Url'i bulamadi");


        //o titleTest => Sayfa başlığının “Rest" içermediğini(contains) test edin
        String expectedIcerik = "Rest";
        String actualTitle = Driver.getDriver().getTitle();

        softAssert.assertNotEquals(actualTitle, expectedIcerik, "Beklenen baslik mevcutla eslesdi.");


        //o logoTest => BestBuy logosunun görüntülendiğini test edin
        BestBuyPage bestBuyPage = new BestBuyPage();
        softAssert.assertTrue(bestBuyPage.logoGorunurlugu.isDisplayed(),"BestBuy logosu görüntülenmedi");


        //o FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

        softAssert.assertTrue(bestBuyPage.francaisElementi.isDisplayed(),"Fransizca Linki görüntülenmedi");

        softAssert.assertAll();
        Driver.closeDriver();


    }
}