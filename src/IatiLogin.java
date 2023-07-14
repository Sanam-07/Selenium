package Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IatiLogin {
	@Test
	public void correctCredentials() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mahar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://iatipublisher-dev.yipl.com.np/login");
		driver.findElement(By.id("username")).sendKeys("testing_amrit");
		driver.findElement(By.id("password")).sendKeys("12345678");
		driver.findElement(By.cssSelector("button#btn")).click();
		Thread.sleep(5000);
		boolean Visible = driver.findElement(By.xpath("//span[@class='last font-bold']")).isDisplayed();
		System.out.println(Visible);
		driver.close();
	}

	@Test
	public void correctUsername() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mahar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://iatipublisher-dev.yipl.com.np/login");
		driver.findElement(By.id("username")).sendKeys("zfsfsdf");
		driver.findElement(By.id("password")).sendKeys("12345678");
		driver.findElement(By.cssSelector("button#btn")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='error text-xs']")));
		String message = driver.findElement(By.cssSelector("span[class='error text-xs']")).getText();
		Assert.assertEquals(message, "These credentials do not match our records.");
//		System.out.println("I am sanam Message" + message);
		driver.close();
	}

	@Test
	public void correctPassword() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mahar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://iatipublisher-dev.yipl.com.np/login");
		driver.findElement(By.id("username")).sendKeys("testing_amrit");
		driver.findElement(By.id("password")).sendKeys("434ss");
		driver.findElement(By.cssSelector("button#btn")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='error text-xs']")));
		String message = driver.findElement(By.cssSelector("span[class='error text-xs']")).getText();
		Assert.assertEquals(message, "These credentials do not match our records.");
		driver.close();
	}

	@Test
	public void incorrectCredentials() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mahar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://iatipublisher-dev.yipl.com.np/login");
		driver.findElement(By.id("username")).sendKeys("zfsfsdf");
		driver.findElement(By.id("password")).sendKeys("434ss");
		driver.findElement(By.cssSelector("button#btn")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='error text-xs']")));
		String message = driver.findElement(By.cssSelector("span[class='error text-xs']")).getText();
		Assert.assertEquals(message, "These credentials do not match our records.");
		driver.close();
	}
}
