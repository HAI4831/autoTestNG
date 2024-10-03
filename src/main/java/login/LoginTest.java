package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTest {
    public static void main(String[] args) {
        // Set up ChromeDriver
        System.setProperty("webdriver.chrome.driver", "D:\\download\\chromedriver-win64\\chromedriver.exe");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("http://localhost:8000/login");
            driver.manage().window().maximize();
            // Set up WebDriverWait with a timeout of 120 seconds
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

            // Wait until the username field is visible and enter the username
            WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
            username.sendKeys("nvh@gmail.com");

            // Wait until the password field is visible and enter the password
            WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
            password.sendKeys("abCD@1234");

            // Wait until the login button is clickable and click it
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("login")));
            loginButton.click();

            // Verify redirection to the main page by checking the URL
            wait.until(ExpectedConditions.urlContains("http://localhost:8000/home"));

            // Verify if the dashboard element is displayed
            WebElement dashboardElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[role='banner']")));

            if (dashboardElement.isDisplayed()) {
                System.out.println("Test Passed: User is redirected to the dashboard.");
            } else {
                System.out.println("Test Failed: User is not redirected to the dashboard.");
            }
        } catch (Exception e) {
            System.out.println("Test Failed: " + e.getMessage());
        } finally {
            // Quit the driver
            driver.quit();
        }
    }
}

