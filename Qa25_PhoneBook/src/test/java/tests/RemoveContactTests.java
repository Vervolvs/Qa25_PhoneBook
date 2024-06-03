package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {


    @BeforeMethod
    public void preCondition() {

        if (!app.getHelperUser().isLogged()) {

           //   app.getHelperUser().login(new User().withEmail("mara@gmail.com").withPassword("Mmar123456$"));

            app.getHelperUser().login(new User().setEmail("butranov@gmail.com").setPassword("Mmar123456$"));


        }

        app.getHelperContact().providerContacts();
    }

        @Test
    public void removeFirstContact(){

            Assert.assertEquals(app.getHelperContact().removeOneContact(),1);


        }


    @Test
    public void removeAllContact(){

        app.getHelperContact().removeAllContacts();

        Assert.assertTrue(app.getHelperUser().isNoContactsHereDisplayed());


    }






}
