package week4.day2;

import java.util.List;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(ops);
		driver.get("https://www.myntra.com/");
		//driver.manage().window().maximize();
		
		WebElement men = driver.findElement(By.xpath("(//a[text()='Men'])[1]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(men).perform();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//a[text()='Jackets'])[1]")).click();
		String totalItems = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		System.out.println("Total items of Jackets: " +totalItems);
		
		List<WebElement> categories = driver.findElements(By.xpath("//span[@class='categories-num']"));
		int categoriesCount1 = categories.size();
		System.out.println(categoriesCount1);
		List<String> amount = new ArrayList<String>();
		
		for(WebElement category : categories) {
			amount.add(category.getText());		
			}

		System.out.println(amount);
//
		driver.findElement(By.xpath("(//span[@class='categories-num'])[1]")).click();
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		WebElement searchBox = driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']"));
		searchBox.click();
		searchBox.sendKeys("Duke");
		driver.findElement(By.xpath("(//span[@class='FilterDirectory-count'])[1]")).click();
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();

	}

}
