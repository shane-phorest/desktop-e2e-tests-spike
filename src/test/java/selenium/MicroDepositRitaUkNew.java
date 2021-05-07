package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.*;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MicroDepositRitaUkNew {

	Screen screen = new Screen();

	public Pattern getImage(String imageName) {
		Pattern image = new Pattern("src/test/resources/images/" + imageName).similar((float) 0.7);
		return image;
	}

	public void waitAndClick(String image) throws FindFailed {
		screen.wait(getImage(image), 30);
		screen.click(getImage(image));
	}

	public void hoverAndClick(String image) throws FindFailed {
		screen.wait(getImage(image), 30);
		screen.hover(getImage(image));
		screen.click(getImage(image));
	}

	public void waitAndDoubleClick(String image) throws FindFailed {
		screen.wait(getImage(image), 30);
		screen.doubleClick(getImage(image));
	}

	public void enterText(String image, String text) throws FindFailed {
		screen.wait(getImage(image), 30);
		screen.click(getImage(image));
		screen.type(text);
	}

	public static String OSDetector() {
		String os = System.getProperty("os.name").toLowerCase();
		if (os.contains("win")) {
			return "Windows";
		} else
			return "Mac";

	}


	@Test
	public void createOnlineBooking() throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("http://dev.phorest.com/book/salons/ritauknew");

		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[text()='My Booking History']")).click();
		driver.findElement(By.name("email")).sendKeys("ob@ritauknew.com");
		driver.findElement(By.name("password")).sendKeys("Ph12345");
		driver.findElement(By.name("login-submit")).click();

		Thread.sleep(2000);
		driver.findElement(By.id("ember724")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text()='Book Now'])[6]")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Book Now']")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text()='4:00 PM'])[1]")).click();

		Thread.sleep(3000);

		// Card details are filled in first time the test is run so this checks both
		// cases
		if (driver.findElement(By.xpath("//a[text()='Pay with a new credit card']")).isDisplayed()) {
			driver.findElement(By.xpath("//button[@type='submit']")).click();
		} else {
			driver.switchTo().frame(0);

			driver.findElement(By.name("cardnumber")).click();
			driver.findElement(By.name("cardnumber")).sendKeys("4242424242424242");
			Thread.sleep(1000);

			driver.findElement(By.name("exp-date")).click();
			driver.findElement(By.name("exp-date")).sendKeys("1123");
			Thread.sleep(1000);

			driver.findElement(By.name("cvc")).click();
			driver.findElement(By.name("cvc")).sendKeys("123");
			Thread.sleep(1000);

			driver.switchTo().defaultContent();

			driver.findElement(By.xpath("//button[@type='submit']")).click();
		}

		Thread.sleep(5000);
		driver.close();

	}

	@Test
	public void login() throws FindFailed {
		App.open("/Applications/Memento/bin/Phorest.app");

		waitAndClick("LoginPage/server.png");

		// Clear text box
		for (int i = 0; i <= 25; i++)
			screen.type(Key.BACKSPACE);

		screen.type("https://dev.phorest.com");

		enterText("LoginPage/user.png", "admin");
		enterText("LoginPage/password.png", "q1w2e3r4");
		waitAndClick("LoginPage/next.png");

		enterText("SelectBranchPage/searchForBusiness.png", "ritauknew");

		waitAndClick("SelectBranchPage/business.png");
		waitAndClick("SelectBranchPage/branch.png");
		waitAndClick("SelectBranchPage/select.png");

		// Cancels pin popup when app opens
		waitAndClick("cancel.png");
	}

	@Test
	public void payForAppointment() throws FindFailed {
		hoverAndClick("max.png");

		waitAndClick("Menu/manager.png");

		waitAndClick("Menu/appointments.png");
		// waitAndClick("AppointmentsPage/day.png");
		waitAndClick("AppointmentsPage/app.png");

		waitAndClick("PurchasePage/pay.png");
		waitAndClick("PurchasePage/cash.png");
		waitAndClick("PurchasePage/payApp.png");
		waitAndClick("PurchasePage/close.png");
	}

	@Test
	public void editSale() throws FindFailed {
		waitAndClick("Menu/manager.png");
		waitAndClick("ManagerPage/SalesPage/sales.png");
		waitAndClick("ManagerPage/SalesPage/salesTotal.png");
		waitAndClick("ManagerPage/SalesPage/edit.png");

		waitAndClick("PurchasePage/testStaff.png");
		waitAndClick("PurchasePage/testStaff2.png");
		waitAndClick("PurchasePage/payApp.png");
		waitAndClick("PurchasePage/cash.png");
		waitAndClick("PurchasePage/payApp.png");
		waitAndClick("PurchasePage/yes.png");
	}
}
