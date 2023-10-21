package tests.testNGFramework_JUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C15_ActionsFacebookTest {

    @Test
    public void facebookTesti(){  // CONGFİGURATİON.PROPERTIES DE BİLGİLER EKSİK, TAMAMLA!

        //1. "https://facebook.com" Adresine gidin
        //2. “create new account” butonuna basin
        // 3. “firstName” giris kutusuna bir isim yazin
        //4. “surname” giris kutusuna bir soyisim yazin
        //5. “email” giris kutusuna bir email yazin
        //6. “email” onay kutusuna emaili tekrar yazin
        //7. Bir sifre girin
        //8. Tarih icin gun secin
        //9. Tarih icin ay secin
        //10. Tarih icin yil secin
        //11. Cinsiyeti secin
        //12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        //13. Sayfayi kapatin
        //sayfayi kapatin
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));

        FacebookPage facebookPage=new FacebookPage();
        facebookPage.createAccountButton.click();

        Actions action =new Actions(Driver.getDriver());
        action.click(facebookPage.userNameBox).sendKeys("Beyza")
                .sendKeys(Keys.TAB)
                .sendKeys("Nergiz")
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("email"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("email"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("password"))
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("gun"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("ay"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("yil"))
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT).perform();
        Assert.assertTrue(facebookPage.maleRadioButton.isSelected()
                && !facebookPage.femaleRadioButton.isSelected()
                && !facebookPage.customRadioButton.isSelected());

        facebookPage.loginButonu.click();

        Driver.closeDriver();








    }
}
