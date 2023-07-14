import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mahar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		driver.getCurrentUrl();
		driver.getPageSource();
		driver.navigate().back();
		driver.navigate().forward();
		driver.close();
		driver.quit();// close all the browser open by selenium
	}
}
