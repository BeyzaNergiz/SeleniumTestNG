package tests.testNGFramework_JUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HerOkuAppPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Set;

public class C18_KontrolsuzWindow_Herokuapp {

    @Test
    public void test01(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        Driver.getDriver().get(ConfigReader.getProperty("herokuAppWindowUrl"));
        HerOkuAppPage herokuAppPage=new HerOkuAppPage();
        String ilkSayfaWhd= Driver.getDriver().getWindowHandle();

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualBAslik=herokuAppPage.openingBaslikElementi.getText();
        String expectedBAslik="Opening a new window";
        Assert.assertEquals(actualBAslik,expectedBAslik);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle=Driver.getDriver().getTitle();
        String expectedTitle="The Internet";
        Assert.assertEquals(actualTitle,expectedTitle);

        //● Click Here butonuna basın.
        herokuAppPage.clickElementi.click();

        // artik 2.sayfanin whd'ini bildigimiz icin, ikinci sayfaya gecis yapabiliriz
        Set<String> windowHandlesSeti=Driver.getDriver().getWindowHandles();
        String ikinciWhd="";
        for (String each:windowHandlesSeti
        ) {
            if(!each.equals(ilkSayfaWhd)){
                ikinciWhd=each;
            }
        }
        Driver.getDriver().switchTo().window(ikinciWhd);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String actualYazi=herokuAppPage.newWindowElementi.getText();
        String expectedYazi="New Window";
        Assert.assertEquals(actualTitle,expectedTitle);

        //● Bir önceki pencereye geri döndükten sonra
        //  sayfa başlığının “The Internet” olduğunu doğrulayın.

        Driver.getDriver().switchTo().window(ilkSayfaWhd);
        String actual2Title=Driver.getDriver().getTitle();
        String expected2Title="The Internet";
        Assert.assertEquals(actual2Title,expected2Title);

        Driver.getDriver().quit();
    }

}

