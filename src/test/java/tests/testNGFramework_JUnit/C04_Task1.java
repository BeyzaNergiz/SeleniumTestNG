package tests.testNGFramework_JUnit;


import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class C04_Task1 {

    @Test
    public void test01() throws IOException {
        // 1-"https://www.amazon.com/" adresine gidin.
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        // 2-dropdown menüsündeki webelementleri bir excel dosyasına aktarın.
        // 1. sayfanın  1. sutununda sıra numarası yazsın , 2. sutunda ise dropdown menüsü yazsın.
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.dropDownElementi.click();
        String dosyayolu = "src\\test\\java\\tests\\testNGFramework_JUnit\\StudentPractice.xlsx";
        FileInputStream fis = new FileInputStream(dosyayolu);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");
        Row row;
        Cell cell;
        Select select = new Select(amazonPage.dropDownElementi);
        List<WebElement> optionList=  select.getOptions();
        for (int i = 0; i <optionList.size() ; i++) {
            row=sayfa1.createRow(i);
            cell=row.createCell(0);
            cell.setCellValue(i+1);

            cell= row.createCell(1);
            cell.setCellValue(optionList.get(i).getText());
        }
        FileOutputStream fos = new FileOutputStream(dosyayolu);workbook.write(fos);

        // 3- 28. SATIRDA "Women's Fashion" yazdığını test edin.
        String expectedResult = "Women's Fashion";
        String actualResult = sayfa1.getRow(27).getCell(1).toString();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualResult,expectedResult,"Bu satırda Women's Fashion yazmıyor");

        // 4-DropDown menüsüne basarak açıldığını ve listenin göründüğünü fotoğraflayın
        amazonPage.dropDownElementi.click();
        ReusableMethods.bekle(1);
        ReusableMethods.tumSayfaFotografCek("drop");
        // 5-DropDown webelementinin fotoğrafını çekin
        ReusableMethods.webElementFotografCek(amazonPage.dropDownElementi,"dropDownElementi");
        fis.close();
        fos.close();
        workbook.close();
        softAssert.assertAll();
        Driver.closeDriver();
    }
}
