package automation_practice.ca;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegPage {
	
	public WebDriver driver;
	
	By h1 = By.cssSelector("h1.page-heading");
	By id = By.cssSelector("#email_create");
	By account_creation_button = By.cssSelector(".btn.btn-default.button.button-medium.exclusive");
	By signin_email = By.name("email");
	By singin_pass = By.xpath("//*[@id='passwd']");
	By for_pass = By.xpath("//*[text()='Forgot your password?']"); ////*[contains(text(),'Forgot ')]
	By sing_btn = By.id("SubmitLogin");
	By gender_id = By.id("id_gender1");
	By first_name = By.name("customer_firstname");
	By last_name = By.name("customer_lastname");
	By password = By.xpath("//*[@id='passwd']");
	By dd = By.cssSelector("#days");
	By dm = By.id("months");
	By dy = By.id("years");
	By firstname = By.id("firstname");
	By lastname = By.id("lastname");
	By company = By.id("company");
	By address1 = By.id("address1");
	By address2 = By.name("address2");
	By city = By.cssSelector("#city");
	By state = By.cssSelector("#id_state");
	By postcode = By.name("postcode");
	By phone_mobile = By.name("phone_mobile");
	By address_alias = By.cssSelector("#alias");
	By submitAccount = By.id("submitAccount");
	By csr_act =By.cssSelector(".account");
	public RegPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement RegPageVerification() {
		return driver.findElement(h1);
	}
	
	public WebElement emailId() {
		return driver.findElement(id);
	}
	public WebElement acc_cre_btn()
	{
		return driver.findElement(account_creation_button);
	}
	
	public WebElement email_signin() {
		return driver.findElement(signin_email);
	}
	public WebElement pass_signin() {
		return driver.findElement(singin_pass);
	}
	public WebElement pass_reg() {
		return driver.findElement(for_pass);
	}
	public WebElement btn_sing() {
		return driver.findElement(sing_btn);
	}
	public WebElement id_gender() {
		return driver.findElement(gender_id);
	}
	public WebElement name_first() {
		return driver.findElement(first_name);
	}
	public WebElement name_last() {
		return driver.findElement(last_name);
	}
	public WebElement pwd() {
		return driver.findElement(password);
	}
	public WebElement daydropdown()
	{
		return driver.findElement(dd);
	}
	public WebElement monthdropdown()
	{
		return driver.findElement(dm);
	}
	public WebElement yeardropdown() {
		return driver.findElement(dy);
	}
	public WebElement namefirst()
	{
		return driver.findElement(firstname);
	}
	public WebElement lastname() {
		return driver.findElement(lastname);
	}
	public WebElement company()
	{
		return driver.findElement(company);
	}
	public WebElement address1()
	{
		return driver.findElement(address1);
	}
	public WebElement address2()
	{
		return driver.findElement(address2);
	}
	public WebElement city() {
		return driver.findElement(city);
	}
	public WebElement state()
	{
		return driver.findElement(state);
	}

	public WebElement phone_mobile()
	{
		return driver.findElement(phone_mobile);
	}
	public WebElement address_alias()
	{
		return driver.findElement(address_alias);
	}

	public WebElement submitAccount()
	{
		return driver.findElement(submitAccount);
	}
	public WebElement act_usr()
	{
		return driver.findElement(csr_act);
	}
}
