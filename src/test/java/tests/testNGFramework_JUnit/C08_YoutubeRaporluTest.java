package tests.testNGFramework_JUnit;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.YoutubePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C08_YoutubeRaporluTest extends TestBaseRapor {

    @Test
    public void youtubeTest(){
        extentTest = extentReports.createTest("Youtube Testi","Youtube baslik, erisilebilirlik ve gorunebilirlik testi");

        //2) https://www.youtube.com adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("youtubeUrl"));
        extentTest.info("Kullanici Youtube adresine gider.");

        //3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
        // ○ titleTest  => Sayfa başlığının “YouTube” oldugunu test edin
        String expectedTitle = "YouTube";
        String actualTitle = Driver.getDriver().getTitle();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualTitle,expectedTitle,"Istenen baslik bulunamadi.");
        extentTest.pass("Title Youtube oldugunu test eder.");


        // ○ imageTest  => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        YoutubePage youtubePage = new YoutubePage();
        softAssert.assertTrue(youtubePage.youtubeLogosu.isDisplayed());
        extentTest.pass("Youtube Logosunun goruntulendigini test eder.");

        // ○ Search Box ’in erisilebilir oldugunu test edin (isEnabled())
        softAssert.assertTrue(youtubePage.searchBoxElementi.isEnabled());
        extentTest.pass("Youtube SearcBox'in erisilebilirligini test eder.");

        // ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String unexpectedTitle = "you";
        String actualTitle2 = Driver.getDriver().getTitle();
        softAssert.assertFalse(actualTitle2.contains(unexpectedTitle),"uyusmuyor");
        extentTest.pass("Title'in youtube olmadigini test eder.");

        softAssert.assertAll();

        Driver.closeDriver();
        extentTest.info("sayfayi kapatir");


    }
}
