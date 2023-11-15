package Week4.day3;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebTableTrainNames {

	public static void main(String[] args) throws InterruptedException {
		//intialize chromedriver
				ChromeDriver driver = new ChromeDriver();
				//open url
				driver.get("https://erail.in/");
		
				//Max the window
				driver.manage().window().maximize();
				// implicit wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				// enter MAS from station
				WebElement fromStation = driver.findElement(By.id("txtStationFrom"));
				fromStation.clear();
				fromStation.sendKeys("MAS", Keys.ENTER);
				// enter MDU to station
				WebElement toStation = driver.findElement(By.id("txtStationTo"));
				toStation.clear();
				toStation.sendKeys("MDU",Keys.ENTER);
				//uncheck the checkbox
				driver.findElement(By.id("chkSelectDateOnly")).click();
				Thread.sleep(5000);
				//driver.findElement(By.id("buttonFromTos")).click();
				
				List<WebElement> list = driver.findElements(By.xpath("//table[contains(@class,'DataTable')]/tbody/tr"));
				int name = list.size();
				for(int i=2;i<name;i++) {	
					String text = driver.findElement(By.xpath("//table[contains(@class,'DataTable')]/tbody/tr["+i+"]/td[2]")).getText();
					System.out.println(text);
					/*
					 * for(int j=1;i<=2;j++) { String text =
					 * driver.findElement(By.xpath("//table[contains(@class,'DataTable')]/tbody/tr["
					 * +i+"] /td["+j+"]")).getText(); System.out.println(text); }
					 */
	}
	}

}
