package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm() {

        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
    }

    public void fillLoginRegistrationForm(String email, String password) {
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys(email);
//
//        WebElement passwordInput = wd.findElement(By.xpath("//input[2]"));
//        passwordInput.click();
//        passwordInput.clear();
//        passwordInput.sendKeys(password);
        type(By.xpath("//input[1]"),email);
        type(By.xpath("//input[2]"),password);
    }
    public void submitLogin() {
        wd.findElement(By.xpath("//button[1]")).click();
    }
    public void submitRegistration() {
        wd.findElement(By.xpath("//button[2]")).click();
    }

    public void logout() {
        click(By.xpath("//button[.='Sign Out']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//button[.='Sign Out']"));
    }
}
