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

public class LoginTests extends TestBase {
    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        app.getHelperUser().refresh();
        if (app.getHelperUser().isLogged()) app.getHelperUser().logout();
    }
//    WebDriver wd;------> TestBase

//    @BeforeMethod
//    public void init() {
//        wd = new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
//        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//    }

    @Test(groups = {"positive"})
    public void loginPositiveTest() {

        // open login form
        User user = new User(
                "anna@mail.com",
                "Qq12345$"
        );
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
        app.getHelperUser().openLoginRegistrationForm();

        //fill login form
        app.getHelperUser().fillLoginRegistrationForm(user);
//       app.getHelperUser().fillLoginRegistrationForm(   "anna@mail.com" ,
//               "Qq12345$");


//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("anna@mail.com");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("Qq12345$");

        //click on login button
//
        app.getHelperUser().submitLogin();
        //assert
        logger.info("loginPositiveTest starts with : " + user.getEmail() + " & " + user.getPassword());
        app.getHelperUser().pause(3000);
//        Assert.assertTrue(wd.findElements(By.tagName("button")).size()>0);
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));

    }
    @Test(groups = {"positive"}, dataProvider = "userDTO", dataProviderClass = ProviderData.class)
    public void loginPositiveDTO(User user) {

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        logger.info("loginPositiveTest starts with : " + user.getEmail() + " & " + user.getPassword());
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));

    }

    //    @Test
//    public void loginPositiveTestModel(){
//
//        User user = User.builder()
//                .email("anna@mail.com")
//                .password("Qq12345$")
//                .build();
//                // open login form
//        app.getHelperUser().openLoginRegistrationForm();
//
//        //fill login form
//        // app.getHelperUser().fillLoginRegistrationForm(user);
//        app.getHelperUser().fillLoginRegistrationForm( user.getEmail(), user.getPassword());
//
//
//        //click on login button
//        app.getHelperUser(). submitLogin();
//        //assert
//        app.getHelperUser().pause(3000);
////        Assert.assertTrue(wd.findElements(By.tagName("button")).size()>0);
//        Assert.assertTrue( app.getHelperUser().isElementPresent(By.tagName("button")));
//
//    }
    @Test(groups = {"positive"})
    public void loginPositiveTestProps(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm( app.getEmail(), app.getPassword());
        app.getHelperUser(). submitLogin();
        app.getHelperUser().pause(3000);
        Assert.assertTrue( app.getHelperUser().isElementPresent(By.tagName("button")));

    }

    @Test(groups = {"negative"})
    public void loginNegativeTestWrongEmail() {
//        // open login form
        User user = new User(
                "annamail.com",
                "Qq12345$"
        );
        app.getHelperUser().openLoginRegistrationForm();
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//        //fill login form
        app.getHelperUser().fillLoginRegistrationForm(user);
//        app.getHelperUser().fillLoginRegistrationForm( "annamail.com" ,
//                "Qq12345$");

//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("annamail.com");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("Qq12345$");
//
//        //click on login button
        app.getHelperUser().submitLogin();
//        wd.findElement(By.xpath("//button[1]")).click();
//        //assert
        logger.info("loginNegativeTestWrongEmail starts with : " + user.getEmail() + " & " + user.getPassword());
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
//        pause(3000);
//        Assert.assertTrue(isAlertPresent());
//
    }

    @Test(groups = {"negative"})
    public void loginNegativeTestWrongEmailTwo() {
//        // open login form
        User user = new User(
                "anna@ma@il.com",
                "Qq12345$"
        );
        app.getHelperUser().openLoginRegistrationForm();

        app.getHelperUser().fillLoginRegistrationForm(user);

        app.getHelperUser().submitLogin();

        logger.info("loginNegativeTestWrongEmailTwo starts with : " + user.getEmail() + " & " + user.getPassword());
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isAlertPresent());

    }

    @Test(groups = {"negative", "smoke"})
    public void loginNegativeTestWrongPass() {
//        // open login form
        User user = new User(
                "anna@mail.com",
                "qq12345$"
        );
        app.getHelperUser().openLoginRegistrationForm();
//        openLoginRegistrationForm();
//        //fill login form
        app.getHelperUser().fillLoginRegistrationForm(user);
//       app.getHelperUser().fillLoginRegistrationForm("anna@mail.com" ,
//               "qq12345$");

//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("anna@mail.com");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("qq12345$");
//
//        //click on login button
        app.getHelperUser().submitLogin();
//        wd.findElement(By.xpath("//button[1]")).click();
//        //assert
        logger.info("loginNegativeTestWrongPass starts with : " + user.getEmail() + " & " + user.getPassword());
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
//        pause(3000);
//        Assert.assertTrue(isAlertPresent());
//    }
//    @AfterMethod
//    public void tearDown(){
//        pause(3000);
//        wd.quit();
//    }
//    public void pause(int millis){
//        try {
//            Thread.sleep(millis);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//    }
//    public boolean isAlertPresent() {
//
//        Alert alert = new WebDriverWait(wd,5).until(ExpectedConditions.alertIsPresent());
//        if(alert == null)
//            return false;
//
//        wd.switchTo().alert();
//
//        System.out.println(alert.getText());
//        alert.accept();
//        return true;
//
    }
}
