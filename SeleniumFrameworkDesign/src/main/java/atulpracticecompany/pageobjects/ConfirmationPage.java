package atulpracticecompany.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atulpracticecompany.Abstractcomponent.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {

	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//h1[text()=' Thankyou for the order. ']")
	WebElement confirm;
	
	public String getConfirmationMessage()
	{
		return confirm.getText();
	
	}

}
