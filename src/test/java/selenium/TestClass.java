package selenium;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.sikuli.script.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestClass {

	Screen screen = new Screen();

	public Pattern getImage(String imageName) {
		Pattern image = new Pattern(TestClass.class.getClassLoader().getResource("images/" + imageName))
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
	public void Blogin() throws FindFailed, InterruptedException {

		App.open("C:\\Program Files\\Phorest\\Memento\\bin\\memento_gui.exe");

		waitAndClick("LoginPage/server.png");

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

		waitAndClick("cancel.png");
	}

}
