package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class createCustomerPage {
    WebDriver driver;
    By bankMangerLogin = By.xpath("//button[text() = \'Bank Manager Login\']");
    By addCustomer = By.xpath("//button[contains(text(),'Add Customer')]");
    By firstNameField = By.xpath("//input[@placeholder='First Name']");
    By lastNameField = By.xpath("//input[@placeholder='Last Name']");
    By postCodeField = By.xpath("//input[@placeholder='Post Code']");
    By buttonAddCustomer = By.xpath("//button[@type='submit' and text()='Add Customer']");
    By buttonCustomerTab = By.xpath("//button[contains(text(),'Customers')]");


    public createCustomerPage(WebDriver driver)
    {
        this.driver = driver;
    }


    public void loginAsBankManager()
    {
        driver.findElement(bankMangerLogin).click();
    }
    public void addCustomer(String firstName, String lastName, String postCode)
    {
        driver.findElement(addCustomer).click();
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postCodeField).sendKeys(postCode);
        driver.findElement(buttonAddCustomer).click();
        driver.switchTo().alert().accept();
    }

    public void goToCustomersPage()
    {
        driver.findElement(buttonCustomerTab).click();
    }

    public void deleteCustomer(String firstName, String lastName)
    {
        By deleteCustomer = By.xpath("//td[text()='"+firstName+"']//following-sibling::td[text()='"+lastName+"']//following-sibling::td//button");
        driver.findElement(deleteCustomer).click();
    }


    public boolean verifyingCustomerIsVisible(String fullName) {
        String[] name = fullName.split(" ");
        String firstName = name[0];
        String lastName = name[1];
        By customer = By.xpath("//td[text()='"+firstName+"']//following-sibling::td[text()='"+lastName+"']");

        boolean isCustomer = driver.findElement(customer).isDisplayed();

        if(isCustomer)
        {return true;};
        return false;

    }
}
