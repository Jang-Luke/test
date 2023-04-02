package pack1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://nid.naver.com/nidlogin.login?mode=form&url=https%3A%2F%2Fwww.naver.com");
//		WebElement inputID = driver.findElement(By.id("id"));
//		inputID.sendKeys("kaylike1");
//		WebElement inputPW = driver.findElement(By.id("pw"));
//		inputPW.sendKeys("vtrol1q2w3e");
		
//		driver.get("http://www.naver.com");
//		WebElement inputSearch = driver.findElement(By.id("query"));
//		inputSearch.sendKeys("KH정보교육원");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('id').value=arguments[0]", "kaylike1");
		js.executeScript("document.getElementById('pw').value=arguments[0]", "vtrol1q2w3e");
		WebElement inputButton = driver.findElement(By.id("log.login"));
		inputButton.click();
		driver.get("https://mail.naver.com/v2/new");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfElementsToBe(By.className("button_write_to_me"), 1))
			.get(0)
			.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("subject_title")));
		js.executeScript("document.getElementById('subject_title').value=arguments[0]", "새 제목");
		WebElement send = driver.findElement(By.className("button_write_task"));
		send.click();
	}

}
