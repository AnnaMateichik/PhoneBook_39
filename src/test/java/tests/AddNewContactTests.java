package tests;

import manager.NGListener;
import manager.ProviderData;
import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(NGListener.class)
public class AddNewContactTests extends TestBase {
    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        if (!app.getHelperUser().isLogged()) app.getHelperUser().login(
//                User.builder()
//                        .email("abc@def.com")
//                        .password("$Abcdef12345")
//                        .build()
                app.getEmail(), app.getPassword()
        );
    }

    //    @Test(invocationCount = 5, groups = {"positive"})
    @Test(groups = {"positive", "smoke"})
    public void addNewContactPositive() {
        int i = (int) (System.currentTimeMillis() / 1000) % 360;
        Contact contact = Contact.builder().name("John").lastName("Silver")
                .phone("12345678" + i).email("john_" + i + "@mail.com")
                .address("Rehovot").description("Private").build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitContactForm();
        logger.info("addNewContactPositive starts with --->" + contact.getName() + " " + contact.getLastName() + " " + contact.getPhone() + " " + contact.getEmail() + " " + contact.getAddress() + " " + contact.getDescription());
        Assert.assertTrue(app.getHelperContact().isContactCreated(contact));

    }@Test(groups = {"positive", "smoke"}, dataProvider = "contactDTO", dataProviderClass = ProviderData.class)
    public void addNewContactPositiveDTO(Contact contact) {

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitContactForm();
        logger.info("addNewContactPositive starts with --->" + contact.getName() + " " + contact.getLastName() + " " + contact.getPhone() + " " + contact.getEmail() + " " + contact.getAddress() + " " + contact.getDescription());
        Assert.assertTrue(app.getHelperContact().isContactCreated(contact));

    }

    @Test(groups = {"negative"})
    public void addNewContactNegativePhoneNul() {
        int i = (int) (System.currentTimeMillis() / 1000) % 360;
        Contact contact = Contact.builder().name("John").lastName("Silver")
                .phone("").email("john_" + i + "@mail.com")
                .address("Rehovot").description("Private").build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitContactForm();
        logger.info("addNewContactNegativePhoneNul starts with --->" + contact.getName() + " " + contact.getLastName() + " " + contact.getPhone() + " " + contact.getEmail() + " " + contact.getAddress() + " " + contact.getDescription());
        Assert.assertTrue(app.getHelperUser().isAlertPresent());

    }

    @Test(groups = {"negative"})
    public void addNewContactNegativePhoneLessThenTen() {
        int i = (int) (System.currentTimeMillis() / 1000) % 360;
        Contact contact = Contact.builder().name("John").lastName("Silver")
                .phone("123456" + i).email("john_" + i + "@mail.com")
                .address("Rehovot").description("Private").build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitContactForm();
        logger.info("addNewContactNegativePhoneLessThenTen starts with --->" + contact.getName() + " " + contact.getLastName() + " " + contact.getPhone() + " " + contact.getEmail() + " " + contact.getAddress() + " " + contact.getDescription());
        Assert.assertTrue(app.getHelperUser().isAlertPresent());

    }
}
