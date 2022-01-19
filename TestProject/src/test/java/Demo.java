import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Verify;

public class Demo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pooja.singh\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("PSingh110692@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("Welcome@123");
		driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
		driver.findElement(By.xpath("//*[@id=\"search_query_top\"]")).sendKeys("dresses");
		driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		List<WebElement> dresses= driver.findElements(By.xpath("//img[@title='Printed Summer Dress']"));
		System.out.println(dresses.size());
	/*	for(int i=0;i<=dresses.size()-1;i++) {
			System.out.println(dresses.get(i).getText());
		}
		WebDriverWait wait= (new WebDriverWait(driver, 5));
		wait.until(ExpectedConditions . elementToBeClickable (dresses.get(1)));
		//dresses.get(0).click(); */
		//driver.switchTo().frame(0);
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")).click();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//a[@title='Add to my wishlist']")).click();

		driver.navigate().back();
		SoftAssert sf= new SoftAssert();
		sf.assertEquals(driver.getTitle(), "My account - My store1");
		//Assert.assertEquals(driver.getTitle(), "My account - My store");
		
	//	driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();
	//	driver.navigate().back();
		driver.findElement(By.xpath("//span[text()='My wishlists']")).click();
		System.out.println();
		
	}

}
