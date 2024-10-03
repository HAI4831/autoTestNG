package login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserTest {
	public static void main(String[] args) {
	// Thiết lên ChromeDriver
	System.setProperty("webdriver.chrome.driver", "D:\\download\\chromedriver-win64\\chromedriver.exe");
	// Khád tas ChromeDriver
	WebDriver driver = new ChromeDriver();
	// 1 - Tối đa hỏa cửa số trình duxét driver.manage().window().maximize();
	//1/2 - Điều hướng DAO URL
	driver.navigate().to("https://anhtester.com");
	//3x tiêu và xà in ca console System.out.println(driver.getTitle());
	try {
        // 1 - Tối đa hóa cửa sổ trình duyệt
        driver.manage().window().maximize();

        // 2 - Điều hướng đến URL
        driver.navigate().to("https://anhtester.com");

        // 3 - Lấy tiêu đề trang và in ra console
        System.out.println(driver.getTitle());

        // 4 - Thoát khỏi trình duyệt
        driver.quit();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // Đảm bảo đóng trình duyệt nếu driver không null
        if (driver != null) {
            driver.quit();
        }
    }
}
}