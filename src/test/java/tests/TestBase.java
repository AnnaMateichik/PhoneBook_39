package tests;

import manager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {
    //WebDriver wd;
    static ApplicationManager app = new ApplicationManager(
            System.getProperty("browser", BrowserType.CHROME)
    );
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod(alwaysRun = true)
    public void startTest(Method method) {
        logger.info("Started test ---> " + method.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void stopTest(Method method) {
        logger.info("Finished test ---> " + method.getName());
        logger.info("========================================");
    }

    @BeforeSuite(alwaysRun = true)
//    public void init() {
//        wd = new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
//        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//    }
    public void setUp() {
        app.init();
    }
    @AfterSuite(alwaysRun = true)
//    public void tearDown() {
//        pause(3000);
//        wd.quit();
//    }
    public void stop() {
        app.tearDown();
    }
}
