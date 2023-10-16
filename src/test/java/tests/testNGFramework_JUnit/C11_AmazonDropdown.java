package tests.testNGFramework_JUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class C11_AmazonDropdown {

    AmazonPage amazonPage;


    @BeforeTest
    public void amazonaGidis(){
        // https://www.amazon.com/ adresine gidin.
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));


    }
    @Test
    public void dropdownTesti(){
        //- Test 1
        // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 28 oldugunu test edin
        amazonPage = new AmazonPage();
        Select select = new Select(amazonPage.dropDownElementi);

        List<WebElement> kategoriList = select.getOptions();

        int expectedKategariSayisi = 28;
        int actualKategoriListesi = kategoriList.size();

        Assert.assertEquals(actualKategoriListesi,expectedKategariSayisi,"beklenen kategori sayisi ile gerceklesen uyusmuyor");



    }

    @Test
    public void javaAramaTesti(){
        //	-Test 2
        // 1. Kategori menusunden Books secenegini secin
       Select select = new Select(amazonPage.dropDownElementi);
    //   select.selectByValue("search-alias=stripbooks-intl-ship");
    //   select.selectByVisibleText("Books");
        select.selectByIndex(6);

        // 2. Arama kutusuna Java yazin ve aratin
        amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonAranacakKelime2")+ Keys.ENTER);

        // 3. Bulunan sonuc sayisini yazdirin
        System.out.println(amazonPage.sonucYaziElementi.getText());

        // 4. Sonucun Java kelimesini icerdigini test edin

        String expectedYazi = ConfigReader.getProperty("amazonAranacakKelime2");
        String actualYazi = amazonPage.sonucYaziElementi.getText();

        Assert.assertTrue(actualYazi.contains(expectedYazi));

        Driver.closeDriver();

    }
}
