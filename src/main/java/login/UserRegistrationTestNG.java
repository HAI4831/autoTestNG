package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class UserRegistrationTestNG {

    // DataProvider cho dữ liệu kiểm tra
    @DataProvider(name = "registrationData")
    public Object[][] registrationData() {
        return new Object[][] {
            { "existingUser@gmail.com", "WeakPass1", false }, // Email đã tồn tại
            { "newUser@gmail.com", "weakpass", false }, // Mật khẩu yếu
            { "newUser2@gmail.com", "StrongPass1", true } // Đăng ký thành công
        };
    }

    // Phương thức kiểm tra sử dụng DataProvider
    @Test(dataProvider = "registrationData")
    public void testUserRegistration(String email, String password, boolean expectedOutcome) {
        boolean actualOutcome = registerUser(email, password, expectedOutcome);
        Assert.assertEquals(actualOutcome, expectedOutcome, "Kết quả đăng ký phải khớp với kết quả mong đợi");
    }

    // Phương thức để đăng ký người dùng sử dụng Selenium
    private boolean registerUser(String email, String password, boolean expectedOutcome) {
        // Thiết lập ChromeDriver
        System.setProperty("webdriver.chrome.driver", "D:\\download\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

        try {
            // Điều hướng đến trang đăng ký
            driver.get("http://localhost:8000/register");
            driver.manage().window().maximize();

            // Nhập tên
            WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
            nameField.sendKeys("Test User");

            // Nhập email
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
            emailField.sendKeys(email);

            // Nhập mật khẩu
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
            passwordField.sendKeys(password);

            // Nhập xác nhận mật khẩu
            WebElement confirmPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password_confirmation")));
            confirmPasswordField.sendKeys(password);

            // Nhấn nút đăng ký
            WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Register']")));
            registerButton.click();

            // Kiểm tra xem việc đăng ký có thành công không
            if (expectedOutcome) {
                // Chờ cho đến khi chuyển hướng đến trang chính hoặc thông báo thành công hiển thị
                wait.until(ExpectedConditions.urlContains("http://localhost:8000/home"));
                return true; // Đăng ký thành công
            } else {
                // Chờ thông báo lỗi xuất hiện
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.alert-danger")));
                return false; // Đăng ký thất bại
            }
        } catch (Exception e) {
            System.out.println("Kiểm tra thất bại: " + e.getMessage());
            return false; // Nếu có bất kỳ ngoại lệ nào xảy ra, coi như đăng ký thất bại
        } finally {
            // Đóng trình duyệt
            driver.quit();
        }
    }
}
