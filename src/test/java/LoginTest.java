import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest extends BaseTest  {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
    }

    @Test(groups = "smoke")
    public void testValidLogin() {
        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");
        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // ASSERTION
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Swag Labs");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}