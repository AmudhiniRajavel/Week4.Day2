package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Droppable {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.switchTo().frame(0);

		WebElement dragEle = driver.findElement(By.id("draggable"));

		
		WebElement dropEle = driver.findElement(By.id("droppable"));
		Actions builder = new Actions(driver);

		builder.dragAndDrop(dragEle, dropEle).click().build().perform();
		System.out.println("Done Dragging");
		driver.close();
}
}
