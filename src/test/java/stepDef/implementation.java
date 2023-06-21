package stepDef;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import DataProvider.ConfigFileReader;
import Pages.HomePage;
import Pages.TermsAndConditions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class implementation {
	WebDriver driver;
	WebElement acceptCookies;
	WebElement ourServices;
	WebElement AcctNPamt;
	WebElement PersnlAcct;
	WebElement bePrvtCust;
	WebElement privateCust;
	WebElement termsNConditions;
	WebElement submit;
	Set<String> windowHandles;
	String parentWindow="";
	String childWindow="";
	HomePage home;
	TermsAndConditions tNc;
	ConfigFileReader configFileReader;

	@Before
	public void setup()
	{
		configFileReader=new ConfigFileReader();
		configFileReader.initialiseDriver();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		home=new HomePage(driver);
		tNc=new TermsAndConditions(driver);

	}
	@Given("I want to open the url link")
	public void i_want_to_open_the_url_link() {
		driver.get(configFileReader.getURL());
	}

	@Given("accept the cookies")
	public void accept_the_cookies() {
		home.clickacceptCookies();
	}

	@When("I select the our services dropdown")
	public void i_select_the_our_services_dropdown() {
		home.clickourServices();
	}


	@When("I click on Accounts and Payments option")
	public void i_click_on_accounts_and_payments_option() throws InterruptedException {
		
		home.clickAcctNPamt();
	}

	@When("I click on Personal account")
	public void i_click_on_personal_account() {
   
		home.clickPersnlAcct();
	}


	@When("I click on the button {string}")
	public void i_click_on_the_button(String string) {
		home.clickbePrvtCust();
	}

	@When("choose to go for {string} button")
	public void choose_to_go_for_button(String string) {
		home.clickprivateCust();
	}

	@Then("Will navigate to the new window")
	public void will_navigate_to_the_new_window() {
		windowHandles=driver.getWindowHandles(); 
		parentWindow=driver.getWindowHandle();
		Iterator<String> it=windowHandles.iterator();
		while(it.hasNext())
		{
			childWindow=it.next();
			if(!parentWindow.equals(childWindow))
			driver.switchTo().window(childWindow);
		}
		
		
	}

	@Then("i will check the check box for Terms and conditions")
	public void i_will_check_the_check_box_for_terms_and_conditions() {
		tNc.clicktermsNConditions();
	}

	@Then("click on Borja Har button")
	public void click_on_borja_har_button() {
		tNc.clicksubmit();
	}

	@After
	public void cleanup()
	{
		driver.quit();
	}

	}
