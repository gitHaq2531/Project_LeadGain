package practiceScenarios;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Amazon {
@Test
public void test1() throws InterruptedException
{
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--disable-notifications");
	WebDriver driver=new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.amazon.com");
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nike shoes",Keys.ENTER);
	driver.findElement(By.xpath("//span[text()=\"Men's Air Max 270 Sneaker\"]")).click();
	List<WebElement> allImages = driver.findElements(By.xpath("//span[@class='a-button a-button-toggle image-swatch-button-with-slots']//img"));
	Actions act=new Actions(driver);
	for (WebElement img : allImages) {
		act.moveToElement(img).perform();
		WebElement colorPrint = driver.findElement(By.xpath("//span[text()=' Color: ']//following-sibling::span"));
		System.out.println("color: "+colorPrint.getText());
		System.out.println("  alt: "+img.getDomAttribute("alt"));
		Thread.sleep(1000);
		Assert.assertEquals(colorPrint.getText(), img.getDomAttribute("alt"));
	}
	System.out.println(allImages.size());
}
}
