package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {


    @BeforeClass
    public void preCondition() {

        if (!app.getHelperUser().isLogged()) {

           //   app.getHelperUser().login(new User().withEmail("mara@gmail.com").withPassword("Mmar123456$"));

            app.getHelperUser().login(new User().setEmail("mara@gmail.com").setPassword("Mmar123456$"));


        }
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
