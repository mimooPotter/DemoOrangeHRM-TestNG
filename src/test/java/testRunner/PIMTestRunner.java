package testRunner;

import Page.LoginPage;
import Page.PIMPage;
import com.github.javafaker.Faker;
import config.Setup;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Utils.Utils;

public class PIMTestRunner extends Setup {

    @BeforeTest
    public  void doLogin(){ //as login is prerequisite to run employeeRegistration//

        LoginPage loginPage = new LoginPage(driver);  //driver ta setup class theke inherit kore nicche as oikhane chrome driver setup kora ache
        loginPage.doLogin("admin", "admin123");


    }

@Test (priority = 1, description ="creates new employee")
    public void employeeRegistration() throws InterruptedException {


        PIMPage pimPage = new PIMPage(driver);

    Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userName = faker.name().username();
        String password = "P@ssword12";
        pimPage.registerUser(firstName, lastName, userName, password);

        Utils.doScroll(driver,0,300);
        Thread.sleep(5000);

    }
}
