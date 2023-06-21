package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TermsAndConditions {
	WebDriver driver;
	
	public TermsAndConditions(WebDriver driver) {
		this.driver=driver;
	}
	
	By termsNConditions=By.cssSelector("#id2-w-lbl");
	By submit=By.xpath("//*[@class='button button--large margin--none']/span");
	
	public void clicktermsNConditions() {
		driver.findElement(termsNConditions).click();
	}
	public void clicksubmit() {
		driver.findElement(submit).click();
	}
}
