import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest extends BaseTest  {

    @Test
    public void testAddToCart() {
        // Login first
        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");
        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Add to cart
        driver.findElement(
                By.id("add-to-cart-sauce-labs-backpack")).click();

        // Verify badge
        WebElement badge = driver.findElement(
                By.className("shopping_cart_badge"));

        Assert.assertEquals(badge.getText(), "1");
    }
}

