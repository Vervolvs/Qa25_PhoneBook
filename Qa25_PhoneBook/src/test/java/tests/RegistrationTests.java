package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase {


    @BeforeMethod
    public void preConditions() {
        //if SignOut is present -----> logout
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }

    }

    @Test
    public void registrationSuccess(){

        Random random = new Random();
        int i = random.nextInt(1000)+1000;
        System.out.println(i);

        //***************** option 2 *********************************

        System.out.println(System.currentTimeMillis());
        int z = (int) (System.currentTimeMillis()/1000)%3600;
        System.out.println(z);

        User user = new User()
             //   .setFirstName("Lisa")
              //  .setLastName("Snow")
                .setEmail("snow"+z+"@gmail.com")
                .setPassword("Ssnow123456$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isNoContactsHereDisplayed());

    }


    @Test(description = "Bug report #12569, Fixed")
    public void registrationWrongEmail(){



        User user = new User()
                //   .setFirstName("Lisa")
                //  .setLastName("Snow")
                .setEmail("snowgmail.com")
                .setPassword("Ssnow123456$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));

    }


    @Test(description = "Bug report #12569, Fixed")
    public void registrationWrongPassword(){



        User user = new User()
                //   .setFirstName("Lisa")
                //  .setLastName("Snow")
                .setEmail("snow@gmail.com")
                .setPassword("Ssnow123456");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));

    }



    @Test(description = "Bug report #12569, Fixed")
    public void registrationExistUser(){



        User user = new User()
                //   .setFirstName("Lisa")
                //  .setLastName("Snow")
                .setEmail("maragmail.com")
                .setPassword("Mmar123456$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("User already exist"));

    }













}
