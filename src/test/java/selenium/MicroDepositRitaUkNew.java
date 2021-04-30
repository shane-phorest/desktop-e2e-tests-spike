package selenium;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.sikuli.script.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MicroDepositRitaUkNew {

	Screen screen = new Screen();

	// Points to the images folder at src/test/resources/images
	public Pattern getImage(String imageName) {
		Pattern image = new Pattern(MicroDepositRitaUkNew.class.getClassLoader().getResource("images/" + imageName))
				.similar((float) 0.7);
		return image;
	}

	public void waitAndClick(String image) throws FindFailed {
		screen.wait(getImage(image), 30);
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

	@Test
	public void AcreateOnlineBooking() throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\shane\\Drivers\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
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
		driver.findElement(By.xpath("(//a[text()='10:00 AM'])[2]")).click();

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
	public void Blogin() throws FindFailed {
		App.open("C:\\Program Files\\Phorest\\Memento\\bin\\memento_gui.exe");

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
	public void CpayForAppointment() throws FindFailed {
		waitAndClick("maximise.png");

		waitAndClick("Menu/manager.png");

		waitAndClick("Menu/appointments.png");
		waitAndClick("AppointmentsPage/day.png");
		waitAndClick("AppointmentsPage/day.png");
		waitAndClick("AppointmentsPage/service45.png");

		waitAndClick("PurchasePage/pay.png");
		waitAndClick("PurchasePage/cash.png");
		waitAndClick("PurchasePage/payApp.png");
		waitAndClick("PurchasePage/close.png");
	}

	@Test
	public void DeditSale() throws FindFailed {
		waitAndClick("Menu/manager.png");
		waitAndClick("ManagerPage/SalesPage/sales.png");
		waitAndClick("ManagerPage/SalesPage/salesTotal.png");
		waitAndClick("ManagerPage/SalesPage/edit.png");

		waitAndClick("PurchasePage/testStaff.png");
		waitAndClick("PurchasePage/testStaff2.png");
		waitAndClick("PurchasePage/payApp.png");
		waitAndClick("PurchasePage/cash.png");
		waitAndClick("PurchasePage/payApp.png");
	}
}
