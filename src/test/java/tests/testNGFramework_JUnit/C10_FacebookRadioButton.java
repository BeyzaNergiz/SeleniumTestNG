package tests.testNGFramework_JUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C10_FacebookRadioButton {

    @Test
    public void radioButtonTest() {
        // a. Verilen web sayfasına gidin.
        //     https://facebook.com
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));

        // b. Cookies’i kabul edin
        FacebookPage facebookPage = new FacebookPage();
       // facebookPage.cookiesButton.click();

        // c. Create an account buton’una basin
        facebookPage.createAccountButton.click();

        // d. Radio button elementlerini locate edin ve size uygun olani secin
        facebookPage.femaleRadioButton.click();
        ReusableMethods.bekle(2);

        // e. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
        Assert.assertTrue(facebookPage.femaleRadioButton.isSelected() &&
                                    !facebookPage.maleRadioButton.isSelected() &&
                                    !facebookPage.customRadioButton.isSelected());

        Driver.closeDriver();

    }
}
