package tests.testNGFramework_JUnit;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
public class C05_CreateExcel {

    // TASK02:
    //1- map kullanarak oluşturduğumuz excel dosyasında, dropdown listesinde 5. sıradaki elementin "beauty & personal care"
    //  olduğunu test edin ve bu satırın yanına testin sonucunu yazdırın
    @Test
    public  void test02() throws IOException {
        //1- map kullanarak oluşturduğumuz excel dosyasında, dropdown listesinde 5. sıradaki elementin "Beauty & Personal Care"
        //    olduğunu test edin ve bu satırın yanına testin sonucunu yazdırın
        String dosyayolu = "src\\test\\java\\tests\\testNGFramework_JUnit\\StudentPractice.xlsx";
        FileInputStream fis = new FileInputStream(dosyayolu);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        String no;
        String dropDownListesi;
        Map<String,String> dropDownMap = new TreeMap<>();
        for (int i = 0; i <sayfa1.getLastRowNum() ; i++) {
            no=sayfa1.getRow(i).getCell(0).toString();
            dropDownListesi=sayfa1.getRow(i).getCell(1).toString();
            dropDownMap.put(no,dropDownListesi);
        }
        System.out.println(dropDownMap);

        String expectedSonuc ="Beauty & Personal Care";
        String actualSonuc = dropDownMap.get("5.0");

        if (expectedSonuc.equals(actualSonuc)){
            String testSonucu ="TEST PASSED  : "+expectedSonuc+"yazmaktadır";
            ReusableMethods.bekle(2);
            sayfa1.getRow(4).createCell(2).setCellValue(testSonucu);
        }else {
            System.out.println("TEST FAILED  : "+expectedSonuc+"yazmaktadır");
        }
        FileOutputStream fos = new FileOutputStream(dosyayolu);
        workbook.write(fos);
        fis.close();
        fos.close();
        workbook.close();
        ReusableMethods.bekle(2);
        Driver.closeDriver();
    }
}
