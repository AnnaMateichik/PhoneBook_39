package manager;

import models.Contact;
import models.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProviderData {

    @DataProvider
    public Iterator<Object[]> userDTO() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[] {
                new User("kuku11@mail.ru", "Qw12345$")
        });
        list.add(new Object[] {
                new User("kuku12@mail.ru", "Qw12345$")
        });
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactDTO() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[] {
                Contact.builder()
                        .name("David")
                        .lastName("Or")
                        .phone("0584456585")
                        .email("david@gmail.com")
                        .address("Lod")
                        .description("My friend")
                        .build()
        });
        list.add(new Object[] {
                Contact.builder()
                        .name("Hana")
                        .lastName("Nir")
                        .phone("0535656969")
                        .email("hana@gmail.com")
                        .address("Haifa")
                        .description("My sister")
                        .build()
        });
        return list.iterator();
    }

}
