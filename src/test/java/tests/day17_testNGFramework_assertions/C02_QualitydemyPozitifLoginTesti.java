package tests.day17_testNGFramework_assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_QualitydemyPozitifLoginTesti {

    @Test
    public void pozitifLoginTesti(){
        //1- https://www.qualitydemy.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("qd1Url"));
        //2- login linkine basin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();
        // Cookies i kabul et
        qualitydemyPage.cookiesElementi.click();
        //3- Kullanici email'i olarak valid email girin
        qualitydemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliEmail"));
        //4- Kullanici sifresi olarak valid sifre girin
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        ReusableMethods.bekle(2);

        //5- Login butonuna basarak login olun
        qualitydemyPage.loginButonu.click();


        //6- Basarili olarak giris yapilabildigini test edin

        Assert.assertTrue(qualitydemyPage.basariliGirisElementi.isDisplayed());
        ReusableMethods.tumSayfaFotografCek("QualitydemyPozitifLogin");
        Driver.closeDriver();
    }
}

