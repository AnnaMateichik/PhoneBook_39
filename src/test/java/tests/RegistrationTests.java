package tests;


import manager.NGListener;
import manager.ProviderData;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(NGListener.class)
public class RegistrationTests extends TestBase {
    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        app.getHelperUser().refresh();
        if (app.getHelperUser().isLogged()) app.getHelperUser().logout();

    }

    @Test(groups = {"positive"})
    public void registrationPositiveTest() {
//        // open login form
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;


//        User user = new User(
//                "anna" + i +"@mail.com",
//                "Qq12345$"
//        );
        String email = "anna" + i + "@mail.com";
        String password = "Qq12345$";

        app.getHelperUser().openLoginRegistrationForm();
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//        //fill login form


//     app.getHelperUser().fillLoginRegistrationForm(user);
//     app.getHelperUser().fillLoginRegistrationForm("anna" + i +"@mail.com", "Qq12345$");
        app.getHelperUser().fillLoginRegistrationForm(email, password);

//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("anna" + i +"@mail.com");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("Qq12345$");
//
//        //click on registration button
        app.getHelperUser().submitRegistration();
//        wd.findElement(By.xpath("//button[2]")).click();
//        //assert
        logger.info("registrationPositiveTest starts with : " + email + " & " + password);
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));
//        pause(3000);
//        Assert.assertTrue(wd.findElements(By.tagName("button")).size()>0);
    }
//    @Test(groups = {"positive"}, dataProvider = "registrationCSV", dataProviderClass = ProviderData.class)
//    public void registrationPositiveTestCSV(User user) {
//        String email = user.getEmail() ;
//        String password = user.getPassword();
//        app.getHelperUser().openLoginRegistrationForm();
//        app.getHelperUser().fillLoginRegistrationForm(email, password);
//        app.getHelperUser().submitRegistration();
//        logger.info("registrationPositiveTest starts with : " + email + " & " + password);
//        app.getHelperUser().pause(3000);
//        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));
//    }


    //    //-------------HW10-----------HW12----------------------------------------------------------
    @Test(groups = {"negative"})
    public void registrationNegativeTestWrongEmail() {
//        // open login form
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User(
                "anna" + i + "mail.com",
                "Qq12345$"
        );
        app.getHelperUser().openLoginRegistrationForm();
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//        //fill login form
        app.getHelperUser().fillLoginRegistrationForm(user);
//       app.getHelperUser().fillLoginRegistrationForm("anna" + i +"mail.com",
//               "Qq12345$" );


//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("annammail.com");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("Qq12345$");
//
//        //click on registration button
        app.getHelperUser().submitRegistration();
//        wd.findElement(By.xpath("//button[2]")).click();
//        //assert
        logger.info("registrationNegativeTestWrongEmail starts with : " + user.getEmail() + " & " + user.getPassword());
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
//        pause(3000);
//        Assert.assertTrue(isAlertPresent());
//
    }

    @Test(groups = {"negative"})
    public void registrationNegativeTestWrongEmailTwo() {
//        // open login form
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User(
                "anna@" + i + "ma@l.com",
                "Qq12345$"
        );
        app.getHelperUser().openLoginRegistrationForm();

        app.getHelperUser().fillLoginRegistrationForm(user);

        app.getHelperUser().submitRegistration();

        logger.info("registrationNegativeTestWrongEmailTwo starts with : " + user.getEmail() + " & " + user.getPassword());
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isAlertPresent());

    }

    @Test(groups = {"negative"})
    public void registrationNegativeTestWrongEmailEmptyBeforeDog() {
//        // open login form
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User(
                "@" + i + "mail.com",
                "Qq12345$"
        );
        app.getHelperUser().openLoginRegistrationForm();

        app.getHelperUser().fillLoginRegistrationForm(user);

        app.getHelperUser().submitRegistration();

        logger.info("registrationNegativeTestWrongEmailEmptyBeforeDog starts with : " + user.getEmail() + " & " + user.getPassword());
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isAlertPresent());

    }

    @Test(groups = {"negative"})
    public void registrationNegativeTestWrongEmailWithoutMail() {
//        // open login form
//       int i= (int)(System.currentTimeMillis()/1000)%3600;
        User user = new User(
                "anna@",
                "Qq12345$"
        );
        app.getHelperUser().openLoginRegistrationForm();

        app.getHelperUser().fillLoginRegistrationForm(user);

        app.getHelperUser().submitRegistration();

        logger.info("registrationNegativeTestWrongEmailWithoutMail starts with : " + user.getEmail() + " & " + user.getPassword());
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isAlertPresent());

    }

    @Test(groups = {"negative"})
    public void registrationNegativeTestWrongEmailNul() {
//        // open login form
//       int i= (int)(System.currentTimeMillis()/1000)%3600;
        User user = new User(
                "",
                "Qq12345$"
        );
        app.getHelperUser().openLoginRegistrationForm();

        app.getHelperUser().fillLoginRegistrationForm(user);

        app.getHelperUser().submitRegistration();

        logger.info("registrationNegativeTestWrongEmailNul starts with : " + user.getEmail() + " & " + user.getPassword());
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isAlertPresent());

    }

    @Test(groups = {"negative"})
    public void registrationNegativeTestWrongEmailSpace() {
//        // open login form
//       int i= (int)(System.currentTimeMillis()/1000)%3600;
        User user = new User(
                " ",
                "Qq12345$"
        );
        app.getHelperUser().openLoginRegistrationForm();

        app.getHelperUser().fillLoginRegistrationForm(user);

        app.getHelperUser().submitRegistration();

        logger.info("registrationNegativeTestWrongEmailSpace starts with : " + user.getEmail() + " & " + user.getPassword());
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isAlertPresent());

    }

    @Test(groups = {"negative"})
    public void registrationNegativeTestWrongPassword() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User(
                "anna" + i + "mail.com",
                "Qq12345$"
        );
        app.getHelperUser().openLoginRegistrationForm();

        app.getHelperUser().fillLoginRegistrationForm(user);

        app.getHelperUser().submitRegistration();
        logger.info("registrationNegativeTestWrongPassword starts with : " + user.getEmail() + " & " + user.getPassword());
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isAlertPresent());

    }

    @Test(groups = {"negative"})
    public void registrationNegativeTestWrongPasswordNul() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User(
                "anna" + i + "mail.com",
                ""
        );
        app.getHelperUser().openLoginRegistrationForm();

        app.getHelperUser().fillLoginRegistrationForm(user);

        app.getHelperUser().submitRegistration();
        logger.info("registrationNegativeTestWrongPasswordNul starts with : " + user.getEmail() + " & " + user.getPassword());
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
    }

    @Test(groups = {"negative"})
    public void registrationNegativeTestWrongPasswordSpace() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User(
                "anna" + i + "mail.com",
                " "
        );
        app.getHelperUser().openLoginRegistrationForm();

        app.getHelperUser().fillLoginRegistrationForm(user);

        app.getHelperUser().submitRegistration();
        logger.info("registrationNegativeTestWrongPasswordSpace starts with : " + user.getEmail() + " & " + user.getPassword());
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isAlertPresent());

    }

    @Test(groups = {"negative"})
    public void registrationNegativeTestWrongPasswordWithoutBigLetter() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User(
                "anna" + i + "mail.com",
                "qq12345$"
        );
        app.getHelperUser().openLoginRegistrationForm();

        app.getHelperUser().fillLoginRegistrationForm(user);

        app.getHelperUser().submitRegistration();
        logger.info("registrationNegativeTestWrongPasswordWithoutBigLetter starts with : " + user.getEmail() + " & " + user.getPassword());
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isAlertPresent());

    }

    @Test(groups = {"negative"})
    public void registrationNegativeTestWrongPasswordTwoBigLetters() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User(
                "anna" + i + "mail.com",
                "QQ12345$"
        );
        app.getHelperUser().openLoginRegistrationForm();

        app.getHelperUser().fillLoginRegistrationForm(user);

        app.getHelperUser().submitRegistration();
        logger.info("registrationNegativeTestWrongPasswordTwoBigLetters starts with : " + user.getEmail() + " & " + user.getPassword());
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isAlertPresent());

    }

    @Test(groups = {"negative"})
    public void registrationNegativeTestWrongPasswordWithoutNumbers() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User(
                "anna" + i + "mail.com",
                "QQqqwer$"
        );
        app.getHelperUser().openLoginRegistrationForm();

        app.getHelperUser().fillLoginRegistrationForm(user);

        app.getHelperUser().submitRegistration();
        logger.info("registrationNegativeTestWrongPasswordWithoutNumbers starts with : " + user.getEmail() + " & " + user.getPassword());
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isAlertPresent());

    }

    @Test(groups = {"negative"})
    public void registrationNegativeTestWrongPasswordWithoutLetters() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User(
                "anna" + i + "mail.com",
                "1234567$"
        );
        app.getHelperUser().openLoginRegistrationForm();

        app.getHelperUser().fillLoginRegistrationForm(user);

        app.getHelperUser().submitRegistration();
        logger.info("registrationNegativeTestWrongPasswordWithoutLetters starts with : " + user.getEmail() + " & " + user.getPassword());
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isAlertPresent());

    }

    @Test(groups = {"negative"})
    public void registrationNegativeTestWrongPasswordWithoutSpecialSymbol() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User(
                "anna" + i + "mail.com",
                "Qq123456"
        );
        app.getHelperUser().openLoginRegistrationForm();

        app.getHelperUser().fillLoginRegistrationForm(user);

        app.getHelperUser().submitRegistration();
        logger.info("registrationNegativeTestWrongPasswordWithoutSpecialSymbol starts with : " + user.getEmail() + " & " + user.getPassword());
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isAlertPresent());

    }

    @Test(groups = {"negative"})
    public void registrationNegativeTestWrongPasswordLessThanEight() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User(
                "anna" + i + "mail.com",
                "Qq1234$"
        );
        app.getHelperUser().openLoginRegistrationForm();

        app.getHelperUser().fillLoginRegistrationForm(user);

        app.getHelperUser().submitRegistration();
        logger.info("registrationNegativeTestWrongPasswordLessThanEight starts with : " + user.getEmail() + " & " + user.getPassword());
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isAlertPresent());

    }

    @Test(groups = {"negative"})
    public void registrationNegativeTestWrongPasswordMoreThan15() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User(
                "anna" + i + "mail.com",
                "Qq12345678912345$"
        );
        app.getHelperUser().openLoginRegistrationForm();

        app.getHelperUser().fillLoginRegistrationForm(user);

        app.getHelperUser().submitRegistration();
        logger.info("registrationNegativeTestWrongPasswordMoreThan15 starts with : " + user.getEmail() + " & " + user.getPassword());
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isAlertPresent());

    }

    @Test(groups = {"negative"})
    public void registrationNegativeTestUserAlreadyExist() {
//        int i= (int)(System.currentTimeMillis()/1000)%3600;
        User user = new User(
                "anna@mail.com",
                "Qq12345$"
        );
        app.getHelperUser().openLoginRegistrationForm();

        app.getHelperUser().fillLoginRegistrationForm(user);

        app.getHelperUser().submitRegistration();
        logger.info("registrationNegativeTestUserAlreadyExist starts with : " + user.getEmail() + " & " + user.getPassword());
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isAlertPresent());

    }

}

