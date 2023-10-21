package tests.testNGFramework_JUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class P01_Homework_WebTable {

    @Test
    public void amazonWebTableTest(){
        //Amazon anasayfaya gidebilecek sekilde bir page sayfasi olusturun : AmazonPage

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        AmazonPage amazonPage = new AmazonPage();

        //Ø Amazon ana sayfasinda en altta bulunan Webtable’i inceleyebilmek icin
        //AmazonPage clasinda en altta gitme isini yapacak bir method olusturun
        amazonPage.sayfaninAltinaGit();

        //Ø Tests paketi altinda yeni bir class olusturun: D26_AmazonSatirSutunSayisi
        //Ø Bu class’in altinda bir test method olusturun : satirSayisi( ) ve webtable’da 8
        //satir oldugunu test edin

        List<WebElement> satirlarListesi = amazonPage.satirlarElementleri;

        int expectedSatirSayisi = 8;
        int actualSatirUzunluk = amazonPage.satirlarElementleri.size();

        Assert.assertEquals(actualSatirUzunluk,expectedSatirSayisi);

        //Ø Yeni bir method olusturun : sutunSayisi( ) ve yazi olan sutun sayisinin 7 oldugunu
        //test edin

        List<WebElement> sutunlarListesi = amazonPage.sutunlarElementleri;

        int sayac = 0;
        for (WebElement each:sutunlarListesi
        ) {
            if (!each.getText().isBlank()){
                sayac++;
                System.out.println(sayac + " - " + each.getText());
            }
        }
        System.out.println("================================");

        System.out.println("Listede bos olmayan sutun sayisi : " + sayac);

        int expectedSutunSayisi= 7;
        int actualSutunUzunluk = sayac;
        Assert.assertEquals(actualSutunUzunluk,expectedSutunSayisi);

        Driver.closeDriver();

    }
}
