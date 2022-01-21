package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		Actions builder = new Actions(driver);

		driver.findElement(By.xpath("//option[text()='Select your programs']")).click();
		WebElement val1 = driver.findElement(By.xpath("(//option[text()='Selenium'])[6]"));
		WebElement val2 = driver.findElement(By.xpath("(//option[text()='Loadrunner'])[6]"));
		builder.keyDown(Keys.CONTROL).click(val1).click(val2).keyUp(Keys.CONTROL).perform();		
		

		
	}

}
