package tests.testNGFramework_JUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HerOkuAppPage;
import utilities.Driver;

public class C02_HerokuApp {

    @Test
    public void herokuAppIframe(){
        // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        Driver.getDriver().get("https://the-internet.herokuapp.com/iframe");

        HerOkuAppPage herOkuAppPage = new HerOkuAppPage();

        // 2 ) - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.

        Assert.assertTrue(herOkuAppPage.iFrameYaziElementi.isEnabled());
        System.out.println(herOkuAppPage.iFrameYaziElementi.getText());

        Driver.getDriver().switchTo().frame(herOkuAppPage.iframe);

        // Arama Kutusuna Merhaba Dunya yazdirin.

        herOkuAppPage.textBox.clear();
        herOkuAppPage.textBox.sendKeys("Merhaba Dunya");

        //  - TextBox’in altinda bulunan “Elemental Selenium”
        //    linkini textinin gorunur oldugunu dogrulayin ve konsolda yazdirin.
        //iframe'e gecen driver'i yeniden anasayfaya dondurmemiz gerekir

        Driver.getDriver().switchTo().defaultContent();

        Assert.assertTrue(herOkuAppPage.elementalLinki.isDisplayed());
        System.out.println(herOkuAppPage.elementalLinki.getText());

        Driver.closeDriver();

    }

}
