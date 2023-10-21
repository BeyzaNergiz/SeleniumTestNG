package tests.testNGFramework_JUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HerOkuAppPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C13_IframeHerokuapp {

    @Test
    public void IframeTest(){
        // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        Driver.getDriver().get(ConfigReader.getProperty("herokuappUrl"));
        HerOkuAppPage herokuAppPage=new HerOkuAppPage();
        // 2 ) Bir metod olusturun: iframeTest
        //  - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve
        //  konsolda yazdirin.
        Assert.assertTrue(herokuAppPage.iFrameYaziElementi.isEnabled());
        //  - Text Box’a “Merhaba Dunya!” yazin.
        Driver.getDriver().switchTo().frame(herokuAppPage.iframe);
        herokuAppPage.textBox.clear();
        ReusableMethods.bekle(2);
        herokuAppPage.textBox.sendKeys("Merhaba Dunya");
        //  - TextBox’in altinda bulunan “Elemental Selenium”
        //    linkini textinin gorunur oldugunu dogrulayin ve konsolda yazdirin.
        //iframe'e gecen driver'i yeniden anasayfaya dondurmemiz gerekir
        Driver.getDriver().switchTo().defaultContent();
        Assert.assertTrue(herokuAppPage.elementalLinki.isDisplayed());
        System.out.println(herokuAppPage.elementalLinki.getText());
        Driver.closeDriver();
    }
}
