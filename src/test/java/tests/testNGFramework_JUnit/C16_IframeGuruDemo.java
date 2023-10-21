package tests.testNGFramework_JUnit;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.GuruDemoPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class C16_IframeGuruDemo {
    @Test
    public void test01() {


        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("guruDemoUrl"));
        //   cikarsa cookies kabul edin
        //2) sayfadaki iframe sayısını bulunuz.
        GuruDemoPage guruDemoPage=new GuruDemoPage();
        List<WebElement> iframeList=guruDemoPage.iframeElementleri;
        System.out.println("iframe sayisi"+iframeList.size());

        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        Driver.getDriver().switchTo().frame(guruDemoPage.ilkIframeElementi);
        guruDemoPage.playTusuElementi.click();

        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        Driver.getDriver().switchTo().defaultContent();
        //5) ikinci iframe'deki (Jmeter Made Easy) linke
        //   (https://www.guru99.com/live-selenium-project.html) tıklayınız
        Driver.getDriver().switchTo().frame(guruDemoPage.guruIframeElementi);
        guruDemoPage.madeEasyButonu.click();

        ReusableMethods.bekle(2);

        Driver.closeDriver();


    }
}
