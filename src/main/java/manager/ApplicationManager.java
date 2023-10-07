package manager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    //WebDriver wd;
    EventFiringWebDriver wd;
    HelperUser helperUser;
    HelperContact helperContact;
    public void init() {
        String link = "https://telranedu.web.app/home";
        //wd = new ChromeDriver();
        wd = new EventFiringWebDriver(new ChromeDriver());
        wd.register(new WDListener());
        wd.navigate().to(link);
        logger.info("Navigated to the link ---> " + link);
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        helperUser = new HelperUser(wd);
        helperContact = new HelperContact(wd);
    }
    public void tearDown() {
        wd.quit();
        logger.info("Test completed");
    }

    public HelperUser getHelperUser() {
        return helperUser;
    }
    public HelperContact getHelperContact() {
        return helperContact;
    }

}
