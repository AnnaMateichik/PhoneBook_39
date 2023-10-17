package manager;

import models.Contact;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProviderData {
    @DataProvider
    public Iterator<Object[]> userDTO(){ //Data Transfer Object = DTO
        List<Object[]> list = new ArrayList<>(); //train
        list.add(new Object[]{
                User.builder()
                        .email("anna@mail.com")
                        .password("Qq12345$")
                        .build()
        });
        list.add(new Object[]{
                User.builder()
                        .email("lera@mail.com")
                        .password("Ee12345$")
                        .build()
        });
        list.add(new Object[]{
                User.builder()
                        .email("rita@mail.com")
                        .password("Rr12345$")
                        .build()
        });
        return list.iterator();  //man in the train "list"
    }
    @DataProvider
    public Iterator<Object[]> contactDTO(){ //Data Transfer Object = DTO
        List<Object[]> list = new ArrayList<>(); //train
        list.add(new Object[]{
                Contact.builder()
                        .name("John").lastName("Silver")
                        .phone("1234567891" ).email("johna_@mail.com")
                        .address("Rehovot").description("Private").build()
        });
        list.add(new Object[]{
                Contact.builder()
                        .name("Lera").lastName("Brown")
                        .phone("0519283746" ).email("mn@mail.com")
                        .address("Ramat Gan").description("Sport coach").build()
        });
        list.add(new Object[]{
                Contact.builder()
                        .name("Harry").lastName("Block")
                        .phone("5198723645" ).email("fg@mail.com")
                        .address("Rishon").description("Teacher").build()
        });
        return list.iterator();  //man in the train "list"
    }
    @DataProvider
    public Iterator<Object[]> registrationCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(
                new FileReader(new File("src/test/resources/reg_dataset.csv")));
        String line = reader.readLine();
        while(line != null){
            String[] split = line.split(",");
            list.add(new Object[]{
                    User.builder()
                            .email(split[0])
                            .password(split[1])
                            .build()
            });
            line = reader.readLine();
        }
        reader.close();
        return list.iterator();
    }
}
