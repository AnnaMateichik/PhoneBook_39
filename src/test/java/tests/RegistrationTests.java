package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }

    @Test(groups = {"positive"})
    public void registrationPositiveTest() {
        // open login form
        int i = (int) ((System.currentTimeMillis()/1000)%3600);
        String email = "kuku" + i + "@mail.ru";
        String password = "Qw12345$";
        //User user = new User("kuku" + i + "@mail.ru", "Qw12345$");
        User user = new User(email, password);
        app.getHelperUser().openLoginRegistrationForm();
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
        // fill login form
        app.getHelperUser().fillLoginRegistrationForm(user);
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
        logger.info("registrationPositiveTest starts with:" + email + " & " + password);
        // assert
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isLogged());
        //Assert.assertTrue(wd.findElements(By.xpath("//*[.='Sign Out']")).size() > 0);
        //Assert.assertTrue(wd.findElements(By.tagName("button")).size() > 0);
    }

    //Task 1
    @Test(groups = {"negative"})
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
    @Test(groups = {"negative"})
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
