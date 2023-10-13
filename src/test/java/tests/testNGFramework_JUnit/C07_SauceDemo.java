package tests.testNGFramework_JUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SauceDemoPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C07_SauceDemo {

    @Test
    public void demoTest() {


        //1.	“https://www.saucedemo.com” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("sauceDemoUrl"));

        //2.	Username kutusuna “standard_user” yazdirin
        SauceDemoPage sauceDemoPage = new SauceDemoPage();
        sauceDemoPage.userNameKutusu.sendKeys("standard_user");

        //3.	Password kutusuna “secret_sauce” yazdirin
        sauceDemoPage.passwordKutusu.sendKeys("secret_sauce");

        //4.	Login tuşuna basin
        sauceDemoPage.loginKutusu.sendKeys(Keys.ENTER);

        //5.	İlk urunun ismini kaydedin ve bu urunun sayfasina gidin
        System.out.println(sauceDemoPage.ilkUrunElementi.getText());

        sauceDemoPage.ilkUrunElementi.click();

        //6.	Add to Cart butonuna basin
        sauceDemoPage.addToCartButton.click();

        //7.	Alisveris sepetine tiklayin
        sauceDemoPage.urunSepeti.click();

        //8.	Seçtiğiniz urunun basarili olarak sepete eklendiğini control edin

        Assert.assertTrue(sauceDemoPage.secilenUrununGorunurluk.isDisplayed());

        //9.	Sayfayi kapatin
        ReusableMethods.bekle(2);
        Driver.closeDriver();

    }
}