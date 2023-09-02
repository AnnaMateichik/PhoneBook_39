import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTests {
    WebDriver wd;

    @BeforeMethod
    public void init() {
        wd = new ChromeDriver();
        wd.navigate().to("https://telranedu.web.app/home");
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @Test
    public void loginPositiveTest() {
        // open login form
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
        // fill login form
        //1 emailInput
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("kuku11@mail.ru");
        //2 passwordInput
        WebElement passwordInput = wd.findElement(By.xpath("//input[2]"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("Qw12345$");
        // click on button login
        wd.findElement(By.xpath("//button[1]")).click();
        // assert
        pause(3000);
        Assert.assertTrue(wd.findElements(By.xpath("//*[.='Sign Out']")).size() > 0);
        //Assert.assertTrue(wd.findElements(By.tagName("button")).size() > 0);
    }
    @Test
    public void loginNegativeTestWrongEmailWithoutStrudel(){
        // open login form
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
        // fill login form
        //1 emailInput
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("kuku11mail.ru");
        //2 passwordInput
        WebElement passwordInput = wd.findElement(By.xpath("//input[2]"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("Qw12345$");
        // click on button login
        wd.findElement(By.xpath("//button[1]")).click();
        // assert
        pause(3000);
    }
    //Task 2
    @Test
    public void loginNegativeTestWrongPasswordSpaces(){
        // open login form
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
        // fill login form
        //1 emailInput
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("kuku11@mail.ru");
        //2 passwordInput
        WebElement passwordInput = wd.findElement(By.xpath("//input[2]"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("   ");
        // click on button login
        wd.findElement(By.xpath("//button[1]")).click();
        // assert
        pause(3000);
    }

    @AfterMethod
    public void tearDown() {
        pause(3000);
        wd.quit();
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
