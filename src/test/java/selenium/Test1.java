package selenium;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.sikuli.script.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test1 {

	Screen screen = new Screen();
	String filepath = "C:\\Users\\shane\\Sikuli\\test-suite\\images.sikuli\\";

	public Pattern getImage(String imageName) {
		Pattern image = new Pattern(filepath + imageName);
		return image;
	}

	public void waitForAndClickImage(String image) throws FindFailed {
		screen.wait(getImage(image), 30);
		screen.click(getImage(image));
	}

	public void waitForAndDoubleClickImage(String image) throws FindFailed {
		screen.wait(getImage(image), 30);
		screen.doubleClick(getImage(image));
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
		driver.findElement(By.xpath("(//a[text()='11:30 AM'])[2]")).click();

		Thread.sleep(10000);
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();

		// driver.switchTo().frame(0);

//		if (driver.findElement(By.xpath("//a[text()='Pay with a new credit card']")).isDisplayed()) {
//			driver.findElement(By.xpath("//a[text()='Pay with a new credit card']")).click();
//		}
//
//		driver.findElement(By.name("cardnumber")).click();
//		driver.findElement(By.name("cardnumber")).sendKeys("4242424242424242");
//
//		driver.findElement(By.name("exp-date")).click();
//		driver.findElement(By.name("exp-date")).sendKeys("1123");
//
//		driver.findElement(By.name("cvc")).click();
//		driver.findElement(By.name("cvc")).sendKeys("123");
//
//		Thread.sleep(2000);
//
//		// driver.findElement(By.name("cvc")).sendKeys(Keys.RETURN);

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);

		driver.close();

	}

	@Test
	public void Blogin() throws FindFailed, InterruptedException {

		App.open("C:\\Program Files\\Phorest\\Memento\\bin\\memento_gui.exe");

		String urlInput = "server.png";
		String userInput = "user.png";
		String passwordInput = "password.png";
		String nextButton = "next.png";
		String selectButton = "select.png";
		String searchForBusiness = "searchForBusiness.png";
		String ritaUKnew = "ritaUKnew.png";
		String ritaUKnew2 = "ritaUKnew2.png";
		String cancelButton = "cancel.png";

		waitForAndClickImage(urlInput);

		for (int i = 0; i <= 25; i++)
			screen.type(Key.BACKSPACE);

		screen.type("https://dev.phorest.com");

		screen.click(getImage(userInput));
		screen.type("admin");
		screen.click(getImage(passwordInput));
		screen.type("q1w2e3r4");

		waitForAndClickImage(nextButton);

		waitForAndClickImage(searchForBusiness);
		screen.type("ritauk");

		waitForAndClickImage(ritaUKnew);
		waitForAndClickImage(ritaUKnew2);
		waitForAndClickImage(selectButton);

		waitForAndClickImage(cancelButton);
	}

	@Test
	public void CpayForOnlineBookingAppointment() throws FindFailed, InterruptedException {
		String appointments = "appointments.png";
		String marketing = "marketing.png";
		String purchase = "purchase.png";
		String app = "app.png";
		String app2 = "service45.png";
		String pay = "pay.png";
		String day = "day.png";
		String cash = "cash.png";
		String payApp = "payApp.png";
		String close = "close.png";
		String manager = "manager.png";
		String expand = "expandWindow.png";

		screen.click(getImage(expand));

		waitForAndClickImage(manager);

		waitForAndClickImage(appointments);
		waitForAndClickImage(day);
		waitForAndClickImage(day);
		waitForAndDoubleClickImage(app2);

		waitForAndClickImage(pay);
		waitForAndClickImage(cash);
		waitForAndClickImage(payApp);
		waitForAndClickImage(close);
	}

	@Test
	public void DsalesScreen() throws FindFailed {
		String manager = "manager.png";
		String sales = "sales.png";
		String salesTotal = "salesTotal.png";
		String edit = "edit.png";
		String testStaff = "testStaff.png";
		String testStaff2 = "testStaff2.png";
		String payApp = "payApp.png";
		String cash = "cash.png";

		waitForAndClickImage(manager);
		waitForAndClickImage(sales);
		waitForAndClickImage(salesTotal);
		waitForAndClickImage(edit);
		waitForAndClickImage(testStaff);
		waitForAndClickImage(testStaff2);
		waitForAndClickImage(payApp);
		waitForAndClickImage(cash);
		waitForAndClickImage(payApp);
	}
}
