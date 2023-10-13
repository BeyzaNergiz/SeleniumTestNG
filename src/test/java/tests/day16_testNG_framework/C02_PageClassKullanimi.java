package tests.day16_testNG_framework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_PageClassKullanimi {

    @Test(groups = {"smoke","end2end1"})
    public void amazonTest(){

        //amazon'a gidelim
        Driver.getDriver().get("https://www.amazon.com");

        //Nutella icin arama yapalim
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        //arama sonuclarinin Nutella icerdigini test edelim
        String expectedIcerik = "Nutella";
        String actualSonucYazisi = amazonPage.sonucYaziElementi.getText();

        //driver'i kapatalim.
        Driver.closeDriver();
    }
}
