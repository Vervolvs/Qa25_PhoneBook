package manager;

import models.Contact;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderContacts {


    @DataProvider
    public Iterator<Object[]> example(){

        List<Object[]> list = new ArrayList<>();
        return list.iterator();

    }

    @DataProvider
    public Iterator<Object[]> contactCSV() throws IOException {

        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));
        String line = reader.readLine();
        while (line!=null){

          String[] all =  line.split(",");
          list.add(new Object[]{Contact.builder()
                  .name(all[0])
                  .lastname(all[1])
                  .email(all[2])
                  .phone(all[3])
                  .address(all[4])
                  .description(all[5])
                  .build()});

          line= reader.readLine();

        }

        return list.iterator();

    }


    @DataProvider
    public Iterator<Object[]> contactSuccess(){

        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{

                Contact.builder()
                        .name("Tony")
                        .lastname("Molly")
                        .phone("34567891022")
                        .email("tony@gmail.com")
                        .address("NY")
                        .description("Friends")
                        .build()


        });
        list.add(new Object[]{

                Contact.builder()
                        .name("Tony")
                        .lastname("Molly")
                        .phone("34567895555")
                        .email("molly@gmail.com")
                        .address("NY")

                        .build()


        });
        return list.iterator();

    }


    @DataProvider
    public Iterator<Object[]> contactWrongPhone(){

        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{

                Contact.builder()
                        .name("Tony")
                        .lastname("Molly")
                        .phone("123")
                        .email("tony@gmail.com")
                        .address("NY")
                        .description("Friends")
                        .build()


        });

        list.add(new Object[]{

                Contact.builder()
                        .name("Tony")
                        .lastname("Molly")
                        .phone("3456789102265657676745353")
                        .email("tony@gmail.com")
                        .address("NY")
                        .description("Friends")
                        .build()


        });

        list.add(new Object[]{

                Contact.builder()
                        .name("Tony")
                        .lastname("Molly")
                        .phone("wwwwwww")
                        .email("tony@gmail.com")
                        .address("NY")
                        .description("Friends")
                        .build()


        });


        list.add(new Object[]{

                Contact.builder()
                        .name("Tony")
                        .lastname("Molly")
                        .phone("")
                        .email("tony@gmail.com")
                        .address("NY")
                        .description("Friends")
                        .build()


        });






        return list.iterator();

    }







}
