package stepDefinition;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HotelBooking {

	public static WebDriver driver;
    Properties obj = new Properties();
   	
	@Given("^PHPTravels site$")
	public void phptravels_site() throws Throwable {
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hitesh.Makhija\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Hitesh.Makhija\\Downloads\\geckodriver-v0.20.0-win64\\geckodriver.exe");
	    driver = new ChromeDriver();
	   // driver = new FirefoxDriver();
	    
	    //code to let your script recognize the parameters of properties file
	    FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\application.properties");
	    obj.load(objfile);
		driver.navigate().to(obj.getProperty("url"));
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^\"(.*?)\", checkin, checkout, adults and child are entered$")
	public void checkin_checkout_adults_and_child_are_entered(String location) throws Throwable {	
		WebElement element = driver.findElement(By.xpath(obj.getProperty("cityField"))); //searching for location field
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click(); //clicking on location field when it becomes visible
		
		driver.findElement(By.xpath(obj.getProperty("cityName"))).sendKeys(location); //searching for city
		driver.findElement(By.xpath(obj.getProperty("citySelect"))).click(); //selecting required city
		
		driver.findElement(By.name(obj.getProperty("checkInField"))).click(); //opening checkin dates
		driver.findElement(By.xpath(obj.getProperty("checkInDate"))).click(); //selecting checkin date
		
		driver.findElement(By.xpath(obj.getProperty("checkOutDate"))).click(); //selecting checkout date

		driver.findElement(By.name(obj.getProperty("adultsField"))).click();
		Select adultslist = new Select(driver.findElement(By.name(obj.getProperty("adultsField"))));
		adultslist.selectByIndex(0); //selecting number of adults
	}

	@When("^Search is clicked$")
	public void search_is_clicked() throws Throwable {
		driver.findElement(By.xpath(obj.getProperty("searchButton"))).click(); //search button
	}

	@When("^Required hotel is selected among the list of given hotels$")
	public void required_hotel_is_selected_among_the_list_of_given_hotesl() throws Throwable {
		driver.findElement(By.xpath(obj.getProperty("detailsButton"))).click(); //details button for hotels
	}

	@When("^Required room is selected among the list of available rooms$")
	public void required_room_is_selected_among_the_list_of_available_rooms() throws Throwable {
		driver.findElement(By.xpath("//body")).sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.xpath("//body")).sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.xpath("//body")).sendKeys(Keys.ENTER);
	}

	@When("^Book Now is clicked$")
	public void book_Now_is_clicked() throws Throwable {
		WebElement element = driver.findElement(By.xpath(obj.getProperty("bookNowButton")));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click(); //book now button for selected room
	}

	@When("^Details as \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\", country are filled for booking as a guest$")
	public void details_as_country_are_filled_for_booking_as_a_guest(String firstName, String lastName, String email, String confirmEmail, String mobileNumber, String address) throws Throwable {
		driver.findElement(By.name(obj.getProperty("firstNameField"))).sendKeys(firstName); //first name
		driver.findElement(By.name(obj.getProperty("lastNameField"))).sendKeys(lastName); //last name
		driver.findElement(By.name(obj.getProperty("emailField"))).sendKeys(email); //email
		driver.findElement(By.name(obj.getProperty("confirmEmailField"))).sendKeys(confirmEmail); //confirm email
		driver.findElement(By.name(obj.getProperty("phoneField"))).sendKeys(mobileNumber); //mobile number
		driver.findElement(By.name(obj.getProperty("addressField"))).sendKeys(address); //address
		driver.findElement(By.className(obj.getProperty("countryField"))).click(); 
	
		WebElement element = driver.findElement(By.xpath(obj.getProperty("countrySelect")));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click(); //selecting country
	}

	@When("^Confirm this booking is clicked$")
	public void confirm_this_booking_is_clicked() throws Throwable {
		driver.findElement(By.name(obj.getProperty("guestButton"))).click(); //confirm this booking button is clicked
	}

	@When("^An unpaid invoice is generated$")
	public void an_unpaid_invoice_is_generated() throws Throwable {
		System.out.println("First unpaid invoice is generated");
	}
	
	@When("^Pay Now is clicked$")
	public void pay_Now_is_clicked() throws Throwable {
		driver.findElement(By.xpath(obj.getProperty("payNowButton"))).click(); //pay now button is clicked
	}

	@When("^Payment Method is selected$")
	public void payment_Method_is_selected() throws Throwable {
		WebElement element = driver.findElement(By.name(obj.getProperty("paymentMethod")));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
		
		Select payOptions = new Select(driver.findElement(By.name(obj.getProperty("paymentMethod"))));
		payOptions.selectByIndex(1); //payment method is selected
	}

	@Then("^Again an unpaid invoice is generated$")
	public void again_an_unpaid_invoice_is_generated() throws Throwable {
		System.out.println("Same unpaid invoice is displayed");
	}
	
	@Then("^Browser is closed$")
	public void after_clicking_OK_on_pop_up_appearing_for_Pay_on_Arrival_the_booking_is_reserved() throws Throwable {
		driver.quit();
	}
	
}
