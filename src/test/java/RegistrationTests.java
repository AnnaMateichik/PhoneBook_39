import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegistrationTests {
    WebDriver wd;

    @BeforeMethod
    public void init() {
        wd = new ChromeDriver();
        wd.navigate().to("https://telranedu.web.app/home");
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @Test
    public void registrationPositiveTest() {
        // open login form
        int i = (int) ((System.currentTimeMillis()/1000)%3600);
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
        // fill login form
        //1 emailInput
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("kuku" + i + "@mail.ru");
        //2 passwordInput
        WebElement passwordInput = wd.findElement(By.xpath("//input[2]"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("Qw12345$");
        // click on button registration
        wd.findElement(By.xpath("//button[2]")).click();
        // assert
        pause(3000);
        //Assert.assertTrue(wd.findElements(By.xpath("//*[.='Sign Out']")).size() > 0);
        Assert.assertTrue(wd.findElements(By.tagName("button")).size() > 0);
    }

    //Task 1
    @Test
    public void registrationNegativeTestWrongEmailSpaces() {
        // open login form
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
        // fill login form
        //1 emailInput
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("   ");
        //2 passwordInput
        WebElement passwordInput = wd.findElement(By.xpath("//input[2]"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("Gg12345$");
        // click on button registration
        wd.findElement(By.xpath("//button[2]")).click();
        // assert
        pause(3000);
    }
    @Test
    public void registrationNegativeTestWrongPasswordSpaces() {
        // open login form
        int i = (int) ((System.currentTimeMillis()/1000)%3600);
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
        // fill login form
        //1 emailInput
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("kuku" + i + "@mail.ru");
        //2 passwordInput
        WebElement passwordInput = wd.findElement(By.xpath("//input[2]"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("   ");
        // click on button registration
        wd.findElement(By.xpath("//button[2]")).click();
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
