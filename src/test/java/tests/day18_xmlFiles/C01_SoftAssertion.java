package tests.day18_xmlFiles;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.WebAppPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C01_SoftAssertion {

    @Test
    public void webAppSecurityTest(){

        //Yeni bir Class Olusturun : C03_SoftAssert
        //1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("webAppUrl"));

        //2. Sign in butonuna basin
        WebAppPage webAppPage = new WebAppPage();
        webAppPage.signinButonu.click();

        //3. Login kutusuna “username” yazin
        webAppPage.usernameButonu.sendKeys(ConfigReader.getProperty("loginKutusu"));

        //4. Password kutusuna “password” yazin
        webAppPage.passwordButonu.sendKeys(ConfigReader.getProperty("passwordKutusu"));

        //5. Sign in tusuna basin, bact tusuyla geri donun.
        webAppPage.signinButonu2.click();

        Driver.getDriver().navigate().back();

        //6. Online banking menusu icinde Pay Bills sayfasina gidin
        webAppPage.onlineBanking.click();
        webAppPage.payBills.click();

        //7. “Purchase Foreign Currency” tusuna basin
        webAppPage.purchaseForeignCurrency.click();

        //8. “Currency” drop down menusunden Eurozone’u secin
        Select select = new Select(webAppPage.pcCurrencyDropdown);
        select.selectByValue("EUR");

        //9. soft assert kullanarak "Eurozone (euro)" secildigini test edin
        SoftAssert softAssert = new SoftAssert();

        String actualSecilmisOpsiyon = select.getFirstSelectedOption().getText();
        String expectedSecilecekOpsiyon = "Eurozone (euro)";

        softAssert.assertEquals(actualSecilmisOpsiyon,expectedSecilecekOpsiyon,"secilen opsiyon Eurozone degil");

        // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"

        String[] dropdownElementleriArr = {"Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"};
        List<String> expectedDropdownElementleriList = Arrays.asList(dropdownElementleriArr);

        List<WebElement> dropdownElementleriList = select.getOptions();

 /*
        List<String> actualDropdownOpsiyonlariList = new ArrayList<>();

        for (WebElement each: dropdownElementleriList
             ) {
            actualDropdownOpsiyonlariList.add(each.getText());
        }

         */
        List<String> actualDropdownOpsiyonlariList = ReusableMethods.stringListeCevir(dropdownElementleriList);

        softAssert.assertEquals(actualDropdownOpsiyonlariList,expectedDropdownElementleriList,"dropdown opsiyonlari istenen sekilde degil");

        softAssert.assertAll();

        Driver.closeDriver();




    }
}
