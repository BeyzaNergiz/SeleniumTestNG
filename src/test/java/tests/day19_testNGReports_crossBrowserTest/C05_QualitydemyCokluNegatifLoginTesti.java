package tests.day19_testNGReports_crossBrowserTest;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C05_QualitydemyCokluNegatifLoginTesti {


    @DataProvider
    public static Object[][] gecersizKullaniciListesi() {

        String [][] gecersizKullaniciBilgileri = new String[3][2];
        // String [][] gecersizKullaniciBilgileri = {{Yetis,12345},{Aysegul,45678},{Ayfer,78945}};

        Faker faker = new Faker();

        for (int i = 0; i < gecersizKullaniciBilgileri.length ; i++) {
            gecersizKullaniciBilgileri[i][0] = faker.internet().emailAddress();
            gecersizKullaniciBilgileri[i][1] = faker.internet().password();

        }


        return gecersizKullaniciBilgileri;
    }

    @Test(dataProvider = "gecersizKullaniciListesi")

    public void cokluNegatifTest(String username, String password){
        // qualitydemy anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("qd1Url"));

        // ilk login linkine tiklayin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.cookiesElementi.click();
        // verilen gecersiz kullanici adi ve sifreleri listesindeki
        // 3 isim ve sifre icin giris yapilamadigini test edin

        qualitydemyPage.emailKutusu.sendKeys(username);
        qualitydemyPage.passwordKutusu.sendKeys(password);
        ReusableMethods.bekle(2);
        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.emailKutusu.isDisplayed());

        // sayfayi kapatin
        Driver.closeDriver();
    }
}
