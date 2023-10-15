package tests.testNGFramework_JUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HerOkuAppPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C09_HerOkuAppRaporluTest extends TestBaseRapor {

    @Test
    public void herOkuAppTest(){

    extentTest = extentReports.createTest("HerOkuApp Checkbox Testi","HerokuApp sayfasindaki chechbox'larin seçili olma durumunu test eder.");
    //a. Verilen web sayfasına gidin.
    //   https://the-internet.herokuapp.com/checkboxes
        Driver.getDriver().get(ConfigReader.getProperty("herOkuAppUrl"));
        extentTest.info("Kuulanici herokuapp sayfasina gider.");

        HerOkuAppPage herOkuAppPage = new HerOkuAppPage();

    //  b. Checkbox1 ve checkbox2 elementlerini locate edin.
    //  c. Checkbox1 seçili değilse onay kutusunu tıklayın

  // if (!herOkuAppPage.checkBox1.isSelected()){
  //     herOkuAppPage.checkBox1.click();
  // }

        Assert.assertFalse(herOkuAppPage.checkBox1.isSelected());
        herOkuAppPage.checkBox1.click();
        extentTest.pass("Checkbox1'in secili olmadığını test eder.");

        ReusableMethods.bekle(2);

    //  d. Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!herOkuAppPage.checkBox2.isSelected()){
            herOkuAppPage.checkBox2.click();
        }
        extentTest.pass("Checkbox2'in secili olmadığını test eder.");
        ReusableMethods.bekle(2);

    //  e. Checkbox1 ve Checkbox2’nin seçili olduğunu test edin
        Assert.assertTrue(herOkuAppPage.checkBox1.isSelected() && herOkuAppPage.checkBox2.isSelected());
        extentTest.pass("Checkbox1 ve Checkbox2'nin secili olduğunu test eder.");

        Driver.closeDriver();
        extentTest.info("sayfayi kapatir");
}
}
