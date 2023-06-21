package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
}
	By acceptCookies=By.linkText("Godkänn alla");
	By ourServices=By.xpath("//span[text()='Våra tjänster']");
	By AcctNPamt=By.linkText("Konton och betalningar");
	By PersnlAcct=By.linkText("Personkonto");
	By bePrvtCust=By.partialLinkText("Bli privatkund");
	By privateCust=By.xpath("//a[@href='https://prod.ocs.nordea.se/blikund/']");
	
	
	public void clickacceptCookies() {
		driver.findElement(acceptCookies).click();
	}
	public void clickourServices() {
		driver.findElement(ourServices).click();
	}
	public void clickAcctNPamt() {
		driver.findElement(AcctNPamt).click();
	}
	public void clickPersnlAcct() {
		driver.findElement(PersnlAcct).click();
	}
	public void clickbePrvtCust() {
		driver.findElement(bePrvtCust).click();
	}
	public void clickprivateCust() {
		driver.findElement(privateCust).click();
	}
	
	
}
