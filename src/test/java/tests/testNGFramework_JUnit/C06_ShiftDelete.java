package tests.testNGFramework_JUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ShiftdeletePage;
import pages.YoutubePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;
public class C06_ShiftDelete {

    //TASK03:
    //1- https://forum.shiftdelete.net/ adresine gidin.
    //2- Youtube videosunun ortasındaki play logosuna tıklayın.
    //3- videoda sağ alttaki youtube logosuna tıklayın.
    //4- Yeni sayfa açıldığını test edin
    //5- İlk Sayfaya dönerek bu sayfada arama kutusunun görünür olduğunu test edin.

    @Test
    public void test03(){
        //1- https://forum.shiftdelete.net/ adresine gidin.
        Driver.getDriver().get(ConfigReader.getProperty("shiftdeleteUrl"));
        //2- Youtube videosunun ortasındaki play logosuna tıklayın.
        ShiftdeletePage shiftdeletePage = new ShiftdeletePage();
        Driver.getDriver().switchTo().frame(shiftdeletePage.iframeElementi);
        shiftdeletePage.playElementi.click();
        ReusableMethods.bekle(5);
        //3- videoda sağ alttaki youtube logosuna tıklayın.
        shiftdeletePage.sagAltPlayElementi.click();
        ReusableMethods.bekle(3);
        //4- Yeni sayfa açıldığını test edin
        String ilkSayfaWhd =Driver.getDriver().getWindowHandle();
        String ikinciSayfaWhd="";
        Set<String> whdSeti = Driver.getDriver().getWindowHandles();
        for (String each:whdSeti
        ) {
            if (!each.equals(ilkSayfaWhd)){
                ikinciSayfaWhd=each;
            }
        }
        Driver.getDriver().switchTo().window(ikinciSayfaWhd);
        YoutubePage youtubePage = new YoutubePage();
        Assert.assertTrue(youtubePage.ikinciSayfaYoutubeLogoElementi.isDisplayed());

        //5- İlk Sayfaya dönerek bu sayfada arama kutusunun görünür olduğunu test edin.
        Driver.getDriver().switchTo().window(ilkSayfaWhd);
        Assert.assertTrue(shiftdeletePage.aramaKutusuElementi.isDisplayed());
        Driver.getDriver().quit();
    }
}
