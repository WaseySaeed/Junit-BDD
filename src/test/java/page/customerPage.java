package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class customerPage {
    WebDriver driver;

    By customerLoginButton = By.xpath("//button[contains(text(),'Customer Login')]");
    By login = By.xpath("//button[text()='Login']");

    By depositButton = By.xpath("//b[@id='notch']//ancestor::button[contains(text(),'Deposit')]");
    By withdrawlButton = By.xpath("//button[contains(text(),'Withdrawl')]");
    By amountButton = By.xpath("//input[@ng-model='amount']");
    By transactionSuccessMessage = By.xpath("//span[@ng-show='message']");
    By transactionButton = By.xpath("//b[@id='notch']//ancestor::button[contains(text(),'Transactions')]");

    By submitButton = By.xpath("//button[@type='submit']");
    By backButton = By.xpath("//button[text()='Back']");

    public customerPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void goToCustomerLogin() {
        driver.findElement(customerLoginButton).click();
    }

    public void selectValueFromDropdown(String value, String locator) {
        Select userSelectDropdown = new Select( driver.findElement(By.id(locator)));
        userSelectDropdown.selectByVisibleText(value);
    }

    public void login() {
        driver.findElement(login).click();
    }

    public void deposit(int arg0)
    {
        driver.findElement(depositButton).click();
        driver.findElement(amountButton).sendKeys(String.valueOf(arg0));
        driver.findElement(submitButton).click();
        String expectedDepositSuccessText = "Deposit Successful";
        String actualDepositSuccessText = driver.findElement(transactionSuccessMessage).getText();
        Assert.assertEquals(expectedDepositSuccessText, actualDepositSuccessText);

    }

    public void withdraw(int arg0)
    {
        driver.findElement(withdrawlButton).click();
        driver.findElement(amountButton).sendKeys(String.valueOf(arg0));
        driver.findElement(submitButton).click();
        String expectedDepositSuccessText = "Transaction successful";
        String actualDepositSuccessText = driver.findElement(transactionSuccessMessage).getText();
        Assert.assertEquals(expectedDepositSuccessText, actualDepositSuccessText);
    }

    public boolean verifyTransaction(String transactionType, int amount) throws Exception {
        driver.findElement(transactionButton).click();
        By transaction = By.xpath("//td[text()='"+transactionType+"']//preceding-sibling::td[text()='"+amount+"']");

        boolean isTransaction = driver.findElement(transaction).isDisplayed();
        driver.findElement(backButton).click();
        Thread.sleep(3000);
        if(isTransaction)
        {
            return true;
        }
        else {
            throw new Exception("Transaction not visible");
        }

    }

    public boolean verifyFinalBalance(int totalBalance) throws Exception {
        By finalBalance = By.xpath("//strong[normalize-space()='"+totalBalance+"']");
        boolean isFinalBalance = driver.findElement(finalBalance).isDisplayed();
        Thread.sleep(3000);
        if(isFinalBalance)
        {
            return true;
        }
        else {
            throw new Exception("Final Balance is incorrect");
        }
    }
}
