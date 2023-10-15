package tests.practice;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutoExercisePage;
import utilities.ConfigReader;
import utilities.Driver;

public class P05_AutomationExercise {

    @Test
    public void AETest(){

        Driver.getDriver().get(ConfigReader.getProperty("aeUrl"));

        AutoExercisePage autoExercisePage = new AutoExercisePage();

        autoExercisePage.signUp.click();
        autoExercisePage.registerName.sendKeys("Berk1");
        autoExercisePage.registermail.sendKeys("berk3@babayigit.net");
        autoExercisePage.signupButton.click();
        autoExercisePage.gender1.click();
        autoExercisePage.password.sendKeys("12345678");
        autoExercisePage.firstName.sendKeys("Berk");
        autoExercisePage.lastName.sendKeys("Babayigit");
        autoExercisePage.address.sendKeys("Beylikduzu");
        Select select=new Select(autoExercisePage.country);
        select.selectByValue("Canada"); // options daki value değeri yazılır.
        //select.selectByVisibleText("Canada"); // sayfada görünen değer
        autoExercisePage.state.sendKeys("Istanbul");
        autoExercisePage.city.sendKeys("Istanbul");
        autoExercisePage.zipcode.sendKeys("34697");
        autoExercisePage.mobileNumber.sendKeys("902126547896"+ Keys.ENTER);

        String expectedverify="ACCOUNT CREATED!";
    //    String actualVerify = autoExercisePage.regverify.getText();
    //    Assert.assertTrue(actualVerify.contains(expectedverify));

    //    Driver.closeDriver();




    }

}
