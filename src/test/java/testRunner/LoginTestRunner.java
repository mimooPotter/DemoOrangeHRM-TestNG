package testRunner;

import Page.LoginPage;
import config.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestRunner extends Setup {

    @Test (priority = 1, description = "Admin can login successfully")
    public  void doLogin(){

        LoginPage loginPage = new LoginPage(driver);  //driver ta setup class theke inherit kore nicche as oikhane chrome driver setup kora ache
        loginPage.doLogin("admin", "admin123");
        WebElement imgProfile= driver.findElement(By.className("oxd-userdropdown-img"));
        Assert.assertTrue(imgProfile.isDisplayed());

    }
}
//loginPage object create kore driver parameter pass korlam