import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Coding {
		public static void main(String[] args){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Myrrh Milan\\JAVA\\CodingChallenge\\src\\drivers\\chromedriver.exe");
			WebDriver driver =  new ChromeDriver();

		try{
			Thread.sleep (1000);
			driver.get("https://www.saucedemo.com/");

			Thread.sleep (1500);
			driver.findElement(By.id("user-name")).sendKeys("standard_user");
			driver.findElement(By.id("password")).sendKeys("secret_sauce");
			driver.findElement(By.id("login-button")).click();

			try{
				WebElement errorMessage = driver.findElement(By.cssSelector(".error-message-container"));
				if (errorMessage.isDisplayed()) {
					System.out.println("Scenario 1 (Log in): Failed");
				}
			}
			catch(Exception e) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.urlContains("inventory.html"));

				Thread.sleep (1000);
				driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
				Thread.sleep (1000);
				driver.findElement(By.id("remove-sauce-labs-backpack")).click();
				Thread.sleep (1000);
				driver.findElement(By.className("product_sort_container")).click();
				Thread.sleep (500);
				Select op = new Select(driver.findElement(By.className("product_sort_container")));
				op.selectByValue("hilo");
				Thread.sleep (1000);
				driver.findElement(By.className("product_sort_container")).click();
				Thread.sleep (500);
				Select opp = new Select(driver.findElement(By.className("product_sort_container")));
				opp.selectByValue("az");

				Thread.sleep (2000);
				driver.findElement(By.id("react-burger-menu-btn")).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link"))).click();
				wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/"));

				System.out.println("Scenario 1 (Log in): Passed"); 
			}

			Thread.sleep (2000);
			driver.get("https://www.saucedemo.com/");

			driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
			driver.findElement(By.id("password")).sendKeys("secret_sauce");
			driver.findElement(By.id("login-button")).click();
			
			Thread.sleep (1500);
			WebElement errorMessage1 = driver.findElement(By.cssSelector(".error-message-container"));

				if (errorMessage1.isDisplayed()) {
					System.out.println("Scenario 2: Passed");
				}
				else {
					System.out.println("Scenario 2: Failed");
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				driver.quit();
		}
	}
}