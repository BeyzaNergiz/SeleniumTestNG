package tests.testNGFramework_JUnit;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class C04_StudentPractise {

    @Test
    public void amazonTest() throws IOException {


        // TASK01:
        // 1-"https://www.amazon.com/" adresine gidin.
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // 2-dropdown menüsündeki webelementleri bir excel dosyasına aktarın.
        // 1. sayfanın  1. sutununda sıra numarası yazsın , 2. sutunda ise dropdown menüsü yazsın.
        AmazonPage amazonPage = new AmazonPage();
        List<WebElement> dropdownOptions = amazonPage.dropDownElementi.findElements(By.tagName("option"));


        for (int i = 0; i < dropdownOptions.size(); i++) {
            String optionText = dropdownOptions.get(i).getText();
            System.out.println("Sira Numarasi: " + (i + 1) + ", Dropdown Menüsü: " + optionText);
        }

        String dosyaYolu = "src\\test\\java\\tests\\testNGFramework_JUnit\\StudentPractice.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");

            // Verileri ekleme
            for (int i = 0; i < dropdownOptions.size(); i++) {
                Row row = sayfa1.createRow(i);
                Cell cell1 = row.createCell(0);
                cell1.setCellValue(i + 1); // Sıra numarası
                Cell cell2 = row.createCell(1);
                cell2.setCellValue(dropdownOptions.get(i).getText()); // Dropdown Menüsü

            }

        // 3- 28. SATIRDA "Women's Fashion" yazdığını test edin.
        int expectedSonSatirNo = 28;
        int actualSonSatirNo = sayfa1.getLastRowNum()+1;

        Assert.assertEquals(expectedSonSatirNo,actualSonSatirNo);

        // 4-DropDown menüsüne basarak açıldığını ve listenin göründüğünü fotoğraflayın

        ReusableMethods.tumSayfaFotografCek("Dropdown Menusu");

        // 5-DropDown webelementinin fotoğrafını çekin

        ReusableMethods.webElementFotografCek(amazonPage.dropDownElementi, "Amazon Dropdown Elementi");


        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        workbook.write(fos);

        //Dosyayi kapatalim
        fis.close();
        fos.close();
        workbook.close();

    }
}