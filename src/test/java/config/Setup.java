package config;

import Page.LoginPage;
 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.chrome.ChromeDriver;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.testng.annotations.AfterTest;
 import org.testng.annotations.BeforeTest;


 import java.time.Duration;

 public class Setup {

     private static final Logger log = LoggerFactory.getLogger(Setup.class);
    public WebDriver driver;

     @BeforeTest
     public void setup() {
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
         driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
     }


     @AfterTest
     public void quitBrowser (){
         LoginPage loginPage = new LoginPage(driver);
         loginPage.doLogOut();

        // driver.quit();
     }

}
