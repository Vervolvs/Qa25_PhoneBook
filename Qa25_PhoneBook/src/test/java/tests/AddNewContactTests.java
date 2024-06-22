package tests;

import manager.DataProviderContacts;
import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase {

    @BeforeClass(alwaysRun = true)
    public void preCondition(){

        if(!app.getHelperUser().isLogged()){

         //   app.getHelperUser().login(new User().withEmail("mara@gmail.com").withPassword("Mmar123456$"));

            app.getHelperUser().login(new User().setEmail("butranov@gmail.com").setPassword("Mmar123456$"));

        }






    }


    @Test(dataProvider = "contactSuccess",dataProviderClass = DataProviderContacts.class)
    public void  addContactSuccessAllFields(Contact contact){

        int i = (int) (System.currentTimeMillis()/1000)%3600;

     //   Contact contact = Contact.builder()

      //          .name("Tony"+i)
      //          .lastname("Silver")
       //         .phone("65656565"+i)
       //         .email("silver"+i+"@gmail.com")
       //         .address("NY")
       //         .description("The best")
       //         .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().getScreen("src/test/screenshots/screen-"+i+".png");
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));



    }


    @Test(dataProvider = "contactCSV",dataProviderClass = DataProviderContacts.class)
    public void  addContactSuccessAllFieldsCSV(Contact contact){

        int i = (int) (System.currentTimeMillis()/1000)%3600;

        //   Contact contact = Contact.builder()

        //          .name("Tony"+i)
        //          .lastname("Silver")
        //         .phone("65656565"+i)
        //         .email("silver"+i+"@gmail.com")
        //         .address("NY")
        //         .description("The best")
        //         .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().getScreen("src/test/screenshots/screen-"+i+".png");
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));



    }




    @Test(groups = {"smoke","regress","retest"})
    public void  addContactSuccessReqFields(){

        int i = (int) (System.currentTimeMillis()/1000)%3600;

        Contact contact = Contact.builder()

                .name("Tony")
                .lastname("Silver")
                .phone("65656565"+i)
                .email("silver"+i+"@gmail.com")
                .address("NY")

                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));


    }











    @Test
    public void  addContactWrongName(){

        int i = (int) (System.currentTimeMillis()/1000)%3600;

        Contact contact = Contact.builder()

                .name("")
                .lastname("Silver")
                .phone("6565656555")
                .email("silver@gmail.com")
                .address("NY")

                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());


    }


    @Test
    public void  addContactWrongLastName(){

        int i = (int) (System.currentTimeMillis()/1000)%3600;

        Contact contact = Contact.builder()

                .name("Tony")
                .lastname("")
                .phone("6565656555")
                .email("silver@gmail.com")
                .address("NY")

                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());

    }


    @Test(dataProvider = "contactWrongPhone",dataProviderClass = DataProviderContacts.class)
    public void  addContactWrongPhone(Contact contact){

        int i = (int) (System.currentTimeMillis()/1000)%3600;

     //   Contact contact = Contact.builder()

      //          .name("Tony")
      //          .lastname("Silver")
      //          .phone("")
      //          .email("silver@gmail.com")
      //          .address("NY")

      //          .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
        Assert.assertTrue(app.getHelperContact().isAlertPresent(" Phone not valid: Phone number must contain only digits! And length min 10, max 15!"));

    }


    @Test
    public void  addContactWrongEmail(){

        int i = (int) (System.currentTimeMillis()/1000)%3600;

        Contact contact = Contact.builder()

                .name("Tony")
                .lastname("Silver")
                .phone("6565656555")
                .email("silvergmail.com")
                .address("NY")

                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
        Assert.assertTrue(app.getHelperContact().isAlertPresent("Email not valid: "));
    }




    @Test
    public void  addContactWrongAddress(){

        int i = (int) (System.currentTimeMillis()/1000)%3600;

        Contact contact = Contact.builder()

                .name("Tony")
                .lastname("Silver")
                .phone("65656565"+i)
                .email("silver"+i+"@gmail.com")
                .address("")

                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());

    }




}
