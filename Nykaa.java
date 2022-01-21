package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		//driver.manage().window().maximize();
		
		Actions builder = new Actions(driver);
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		WebElement lp = driver.findElement(By.xpath("(//a[text()=\"L'Oreal Paris\"])[1]"));
		builder.moveToElement(brands).pause(1000).click(lp).perform();
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.xpath("//div[@class='filters']//div[@id='filter-sort']")).click();
		driver.findElement(By.xpath("(//span[@class='title'])[4]")).click();
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		WebElement filterApplied = driver.findElement(By.xpath("//span[text()='Filters Applied']/following::span[text()='Shampoo']"));
		if(filterApplied != null) {
			System.out.println("Available in Filter");
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='product-listing']//img)[1]")).click();
		
		String pw = driver.getWindowHandle();
		System.out.println(pw);
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		String cw = windows.get(1);
		System.out.println(cw);
		driver.switchTo().window(cw);
		
		String title1 = driver.getTitle();
		System.out.println(title1);
		
		WebElement sizeDD = driver.findElement(By.xpath("//select[@title='SIZE']"));
		Select dd = new Select(sizeDD);
		dd.selectByIndex(2);
		
		WebElement price = driver.findElement(By.xpath("(//div[text()='inclusive of all taxes']/preceding-sibling::span)[2]"));
		System.out.println("Price of the product: " + price.getText());
		
		driver.findElement(By.xpath("(//span[text()='ADD TO BAG'])[1]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[@class='cart-count']")).click();
		Thread.sleep(3000);
		
		driver.switchTo().frame(0);
		WebElement finalPrice = driver.findElement(By.xpath("(//div[@class='value'])[4]"));
		String a = finalPrice.getText();
		System.out.println("Final Price: " + a);
		
		driver.findElement(By.xpath("//span[text()='PROCEED']")).click();
		driver.findElement(By.xpath("//button[@class='btn full big']")).click();
		
		WebElement grandTotal = driver.findElement(By.xpath("(//div[text()='Grand Total']/following::div)[1]"));
		String b = grandTotal.getText();
		System.out.println("Grand Total: " + b );
		
		if(a == b) {
			System.out.println("Both amount are not same");
		}
		else
		{
			System.out.println("Both amount are same");
		}
		
		driver.quit();
		}

		
	}


