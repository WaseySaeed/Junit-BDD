package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page.createCustomerPage;

public class createCustomer{
    createCustomerPage createCustomer;
    public createCustomer() throws InterruptedException {
        Thread.sleep(4000);
        createCustomer = new createCustomerPage(initHookSteps.driver);
    }
    @When("i login as bank manager")
    public void iLoginAsBankManager() throws InterruptedException {
        System.out.println("RUN THE CONSTRUCTOR PLEASE");
        createCustomer.loginAsBankManager();
        Thread.sleep(4000);
    }

    @And("i add customer with first name {string} last name {string} and postal code {string}")
    public void iAddCustomerWithFirstNameLastNameAndPostalCode(String arg0, String arg1, String arg2) throws InterruptedException {
        createCustomer.addCustomer(arg0,arg1,arg2);
    }

    @And("i go to customer tab")
    public void iGoToCustomerTab() throws InterruptedException {
        createCustomer.goToCustomersPage();
    }


    @And("i delete customer with first name {string} and last name {string}")
    public void iDeleteCustomerWithFirstNameAndLastName(String arg0, String arg1) {
        createCustomer.deleteCustomer(arg0,arg1);
    }

    @And("i see customer {string} is visible")
    public void iSeeCustomerIsVisible(String arg0) {
        createCustomer.verifyingCustomerIsVisible(arg0);
    }

}
