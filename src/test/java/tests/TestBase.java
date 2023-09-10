package tests;

import manager.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    //WebDriver wd;
    static ApplicationManager app = new ApplicationManager();
    @BeforeSuite
//    public void init() {
//        wd = new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
//        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//    }
    public void setup() {
        app.init();
    }
    @AfterSuite
//    public void tearDown() {
//        pause(3000);
//        wd.quit();
//    }
    public void stop() {
        app.tearDown();
    }
}
