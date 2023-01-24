package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.StringUtils;
import page.customerPage;


public class customer {
    customerPage cust;

    public customer() {
        cust = new customerPage(initHookSteps.driver);
    }

    @When("i login as a customer")
    public void iLoginAsACustomer() {
        cust.goToCustomerLogin();
    }

    @And("i select {string} from the dropdown {string}")
    public void iSelectFromTheDropdown(String arg0, String arg1) {
        cust.selectValueFromDropdown(arg0, arg1);
    }

    @And("i login")
    public void iLogin() {
        cust.login();
    }

    @And("i deposit amount {int}")
    public void iDepositAmount(int arg0) throws InterruptedException {
        cust.deposit(arg0);
        Thread.sleep(3000);
    }

    @And("i withdraw amount {int}")
    public void iWithdrawAmount(int arg0) throws InterruptedException {
        cust.withdraw(arg0);
        Thread.sleep(3000);
    }

    @And("i go to transaction and verify transaction type {string} and amount {int}")
    public void iGoToTransactionAndVerifyTransactionTypeAndAmount(String arg0, int arg1) throws Exception {
        String transactionType = StringUtils.capitalize(arg0);
        cust.verifyTransaction(transactionType, arg1);
    }

    @Then("i verify the total balance to be {int}")
    public void iVerifyTheTotalBalanceToBe(int totalBalance) throws Exception {
        cust.verifyFinalBalance(totalBalance);
    }
}
