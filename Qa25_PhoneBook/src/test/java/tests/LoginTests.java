package tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {



    @BeforeMethod
    public void preConditions(){
    //if SignOut is present -----> logout
    if (app.getHelperUser().isLogged()){
        app.getHelperUser().logout();
        logger.info("Before method finish logout");
    }



    }


    @Test
    public void loginSuccess(){

    logger.info("Start test with name 'loginSuccess'");
    logger.info("Test data --->: email: 'mara@gmail.com' & password: 'Mmar123456$'");

    app.getHelperUser().openLoginRegistrationForm();
    app.getHelperUser().fillLoginRegistrationForm("mara@gmail.com","Mmar123456$");
    app.getHelperUser().submitLogin();

    //Assert
   // Assert.assertEquals();
   // Assert.assertNotEquals();
   // Assert.assertTrue();
   // Assert.assertFalse();

    Assert.assertTrue(app.getHelperUser().isLogged());
    logger.info("Assert check is Element button 'Sign out' present");

    }

    @Test
    public void loginSuccessModel(){

       logger.info("Test data --->: email: 'mara@gmail.com' & password: 'Mmar123456$'");
       app.getHelperUser().openLoginRegistrationForm();
       app.getHelperUser().fillLoginRegistrationForm("mara@gmail.com","Mmar123456$");
       app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Sign out' present");



    }






    @Test
    public void loginWrongEmail(){
        logger.info("Test data --->: email: 'maragmail.com' & password: 'Mmar123456$'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("maragmail.com","Mmar123456$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");

    }
    @Test
    public void loginWrongPassword(){
        logger.info("Test data --->: email: 'mara@gmail.com' & password: 'Mmar123456'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("mara@gmail.com","Mmar123456");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");

    }

    @Test
    public void loginUnregisteredUser(){
        logger.info("Test data --->: email: 'redtt@gmail.com' & password: 'Mmar123456$'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("viz@gmail.com","Viz123456$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");

    }



}
