package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {      //declaring properties

    @FindBy (name="username")
    WebElement txtUserName;

    @FindBy(name="password")
    WebElement txtPassword;

    @FindBy (css= "[type='submit']")
    WebElement btnLogin;

    @FindBy (className = "oxd-userdropdown-img")
    WebElement loggedInUser;

    @FindBy (css="[role=\"menuitem\"]")
    List<WebElement> btnLogOut;

    WebDriver driver;

    public LoginPage(WebDriver driver) {  //creating constructor
        this.driver= driver;
        PageFactory.initElements(driver, this);

    }

    public void doLogin (String username, String password){
        txtUserName.sendKeys(username);
        txtPassword.sendKeys(password);
        btnLogin.click();

    }

    public void doLogOut () {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loggedInUser.click();
        loginPage.btnLogOut.get(3).click();
    }
}
