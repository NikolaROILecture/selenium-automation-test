import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CheckoutTest extends BaseTest {

    @Test
    public void testCompleteCheckout() {
        // Login
        login();

        // Add item
        driver.findElement(
                By.id("add-to-cart-sauce-labs-backpack")).click();

        // Go to cart
        driver.findElement(
                By.className("shopping_cart_link")).click();

        // Checkout
        driver.findElement(By.id("checkout")).click();

        // Fill form
        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys("Doe");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        driver.findElement(By.id("continue")).click();

        // Finish
        driver.findElement(By.id("finish")).click();

        // Verify
        WebElement msg = driver.findElement(
                By.className("complete-header"));
        Assert.assertEquals(msg.getText(),
                "Thank you for your order!");
    }
}
