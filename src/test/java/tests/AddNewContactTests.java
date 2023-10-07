package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User("kuku11@mail.ru", "Qw12345$"));
        }
    }

    @Test(invocationCount = 5)
    public void addNewContactPositive() {
        int i = (int) (System.currentTimeMillis()/1000)%3600;
        Contact contact = Contact.builder()
                .name("John")
                .lastName("Silver")
                .phone("1234567" + i)
                .email("join11!" + i + "@gmail.com")
                .address("Lod")
                .description("Friend")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitContactForm();
        Assert.assertTrue(app.getHelperContact().isContactCreated(contact));
    }

}
