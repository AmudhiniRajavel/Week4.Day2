package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops =new ChromeOptions();
		ops.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(ops);
		driver.get("https://www.snapdeal.com/");
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		Actions builder = new Actions(driver);
		
		WebElement mensFashion = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
		
		WebElement shoes = driver.findElement(By.xpath("//span[text()='Sports Shoes']"));
		
		builder.moveToElement(mensFashion).pause(1000).click(shoes).perform();
		
		WebElement count = driver.findElement(By.xpath("(//div[@class='child-cat-count '])[1]"));
		String c = count.getText();
		System.out.println("Count of sports shoes: " + c);
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		driver.findElement(By.xpath("//i[@class='sd-icon sd-icon-expand-arrow sort-arrow']")).click();
		driver.findElement(By.xpath("(//li[@data-index=\"1\"])[2]")).click();
		WebElement fromVal = driver.findElement(By.xpath("//input[@name='fromVal']"));
		fromVal.clear();
		fromVal.sendKeys("900");
		WebElement toVal = driver.findElement(By.xpath("//input[@name='toVal']"));
		toVal.clear();
		toVal.sendKeys("1200");
		driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@data-filtername='Color_s']//div[@class='filter-type-name lfloat']"));
		driver.findElement(By.xpath("(//div[@class='sdCheckbox filters-list '])[5]")).click();
		Thread.sleep(2000);
		WebElement firstEle = driver.findElement(By.xpath("(//img[@class='product-image wooble'])[1]"));
	
		builder.moveToElement(firstEle).perform();
		driver.findElement(By.xpath("(//div[contains(text(),'Quick View')])[1]")).click();

		WebElement price = driver.findElement(By.xpath("//span[@class='payBlkBig']"));
		String a = price.getText();
		System.out.println("Price of the Product is: " + a);
		WebElement dis = driver.findElement(By.xpath("//span[@class='percent-desc ']"));
		String b = dis.getText();
		System.out.println("Price of the Product is: " + b);
		
		WebElement ssImage = driver.findElement(By.xpath("(//img[@class='cloudzoom'])[1]"));
		File source = ssImage.getScreenshotAs(OutputType.FILE);
		File destination = new File("./Images/sportshoeImage.png");
		FileUtils.copyFile(source, destination);
		System.out.println("Screenshot taken");
		driver.quit();
		
		
		

	}

}
