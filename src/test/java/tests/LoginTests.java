package tests;

import manager.NGListener;
import manager.ProviderData;
import models.Contact;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(NGListener.class)

public class LoginTests extends TestBase{
    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }

    @Test(groups = {"positive", "smoke"})
    public void loginPositiveTest() {
        // open login form
        //wd.findElement(By.xpath("//*[.='LOGIN']")).click();

        app.getHelperUser().openLoginRegistrationForm();
        // fill login form
        //1 emailInput
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("kuku11@mail.ru");
//        //2 passwordInput
//        WebElement passwordInput = wd.findElement(By.xpath("//input[2]"));
//        passwordInput.click();
//        passwordInput.clear();
//        passwordInput.sendKeys("Qw12345$");
        app.getHelperUser().fillLoginRegistrationForm("kuku11@mail.ru", "Qw12345$");
        // click on button login
//        wd.findElement(By.xpath("//button[1]")).click();
        app.getHelperUser().submitLogin();
        // assert
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.xpath("//*[.='Sign Out']")));
    }
    @Test(groups = {"positive"})
    public void loginPositiveTestModel() {

        User user = new User().withEmail("kuku11@mail.ru").withPassword("Qw12345$");
        // open login form
        app.getHelperUser().openLoginRegistrationForm();
        // fill login form
        app.getHelperUser().fillLoginRegistrationForm(user.getEmail(), user.getPassword());
        // click on button login
        app.getHelperUser().submitLogin();
        // assert
        app.getHelperUser().pause(5000);
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.xpath("//*[.='Sign Out']")));
    }

    @Test(groups = {"positive"}, dataProvider = "userDTO", dataProviderClass = ProviderData.class)
    public void loginPositiveUserDTO(User user) {
        // open login form
        app.getHelperUser().openLoginRegistrationForm();
        // fill login form
        app.getHelperUser().fillLoginRegistrationForm(user.getEmail(), user.getPassword());
        // click on button login
        app.getHelperUser().submitLogin();
        // assert
        app.getHelperUser().pause(5000);
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.xpath("//*[.='Sign Out']")));
    }

    @Test(groups = {"negative"})
    public void loginNegativeTestWrongEmailWithoutStrudel(){
        // open login form
        app.getHelperUser().openLoginRegistrationForm();
        // fill login form
        app.getHelperUser().fillLoginRegistrationForm("kuku11mail.ru","Qw12345$");
        // click on button login
        app.getHelperUser().submitLogin();
        // assert
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
    }
    //Task 2
    @Test(groups = {"negative"})
    public void loginNegativeTestWrongPasswordSpaces(){
        // open login form
        app.getHelperUser().openLoginRegistrationForm();
        // fill login form
        app.getHelperUser().fillLoginRegistrationForm("kuku11@mail.ru","   ");
        // click on button login
        app.getHelperUser().submitLogin();
        // assert
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
    }
}
