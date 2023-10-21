package tests.day16_testNG_framework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

public class C01_driverClassKullanimi {

    @Test
    public void amazonTest(){

        //amazon'a gidelim
        Driver.getDriver().get("https://www.amazon.com");

        //Nutella icin arama yapalim
        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        //driver'i kapatalim.
        Driver.closeDriver();
    }

    @Test(groups = {"smoke","regression"})
    public void youtubeTesti(){

        Driver.getDriver().get("https://www.youtube.com");

        Driver.closeDriver();
    }
    @Test
    public void googleTest(){

        //amazon'a gidelim
        Driver.getDriver().get("https://www.google.com");

    }

}
