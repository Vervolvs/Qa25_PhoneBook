package manager;

import models.Contact;
import org.testng.annotations.DataProvider;

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
