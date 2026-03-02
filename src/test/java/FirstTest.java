package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class FirstTest {
        WebDriver driver;

        @BeforeMethod
        public void setup() {
            driver = new ChromeDriver();
            driver.get("https://www.saucedemo.com");
        }

        @Test(groups = "smoke")
        public void testValidLogin() {
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            String title = driver.getTitle();
            Assert.assertEquals(title, "Swag Labs");

            String url = driver.getCurrentUrl();
            Assert.assertTrue(url.contains("inventory"));
        }

        @Test(groups = "smoke")
        public void testInvalidLoginWithUsername() {
            driver.findElement(By.id("user-name")).sendKeys("Hello");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            String url = driver.getCurrentUrl();
            Assert.assertFalse(url.contains("inventory"));
        }

        @Test(groups = "smoke")
        public void testInvalidLoginWithPassword() {
            driver.findElement(By.id("user-name")).sendKeys("Hello");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            String url = driver.getCurrentUrl();
            Assert.assertTrue(url.contains("inventory"));
        }

        @AfterMethod
        public void teardown() {
            driver.quit();
        }
    }