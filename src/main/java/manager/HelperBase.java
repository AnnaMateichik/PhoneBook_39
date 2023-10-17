package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class HelperBase {
    WebDriver wd ;

    public HelperBase(WebDriver wd) {        this.wd = wd;
    }

    public void click(By locator){
        wd.findElement(locator).click();

    }
    public void type(By locator, String text){
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }
    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }

    public boolean isAlertPresent() {

        Alert alert = new WebDriverWait(wd,5).until(ExpectedConditions.alertIsPresent());
        if(alert == null)
            return false;

        wd.switchTo().alert();

        System.out.println(alert.getText());
        alert.accept();
        return true;
    }
    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void refresh(){
        wd.navigate().refresh();
    }
    public void takeScreenShot(String link) {
        File tmp = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE); // operativnaya pamiat
        File screenshot = new File(link); // na diske --- SSD

        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}