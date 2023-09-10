package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

    @Test
    public void registrationPositiveTest() {
        // open login form
        int i = (int) ((System.currentTimeMillis()/1000)%3600);
        app.getHelperUser().openLoginRegistrationForm();
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
        // fill login form
        app.getHelperUser().fillLoginRegistrationForm("kuku" + i + "@mail.ru", "Qw12345$");
        //1 emailInput
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("kuku" + i + "@mail.ru");
//        //2 passwordInput
//        WebElement passwordInput = wd.findElement(By.xpath("//input[2]"));
//        passwordInput.click();
//        passwordInput.clear();
//        passwordInput.sendKeys("Qw12345$");
        // click on button registration
        app.getHelperUser().submitRegistration();
//        wd.findElement(By.xpath("//button[2]")).click();
        // assert
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isLogged());
        //Assert.assertTrue(wd.findElements(By.xpath("//*[.='Sign Out']")).size() > 0);
        //Assert.assertTrue(wd.findElements(By.tagName("button")).size() > 0);
    }

    //Task 1
    @Test
    public void registrationNegativeTestWrongEmailSpaces() {
        // open login form
        app.getHelperUser().openLoginRegistrationForm();
        // fill login form
        app.getHelperUser().fillLoginRegistrationForm("   ", "Gg12345$");
        // click on button registration
        app.getHelperUser().submitRegistration();
        // assert
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
    }
    @Test
    public void registrationNegativeTestWrongPasswordSpaces() {
        // open login form
        int i = (int) ((System.currentTimeMillis()/1000)%3600);
        app.getHelperUser().openLoginRegistrationForm();
        // fill login form
        app.getHelperUser().fillLoginRegistrationForm("kuku" + i + "@mail.ru", "   ");
        // click on button registration
        app.getHelperUser().submitRegistration();
        // assert
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
    }
}
