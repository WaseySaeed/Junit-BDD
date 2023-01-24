Feature: Bank Manager Operation

  Scenario Outline: Creating customers and deleting as Bank Manager
    Given Starting the browser
    When i login as bank manager
    And i add customer with first name <arg0> last name <arg1> and postal code <arg2>
    And i add customer with first name <arg01> last name <arg11> and postal code <arg21>
    And i add customer with first name <arg0> last name <arg12> and postal code <arg22>
    And i add customer with first name <arg02> last name <arg13> and postal code <arg2>
    And i add customer with first name <arg03> last name <arg14> and postal code <arg2>
    And i add customer with first name <arg04> last name <arg13> and postal code <arg21>
    And i add customer with first name <arg03> last name <arg1> and postal code <arg2>
    And i go to customer tab
    And i see customer "Christopher Connely" is visible
    And i see customer "Frank Christopher" is visible
    And i see customer "Christopher Minka" is visible
    And i see customer "Connely Jackson" is visible
    And i see customer "Jackson Frank" is visible
    And i see customer "Minka Jackson" is visible
    And i see customer "Jackson Connely" is visible
    And i delete customer with first name <arg13> and last name <arg14>
    And i delete customer with first name <arg11> and last name <arg1>
    Examples:
      | arg0          | arg1      | arg2       | arg01   | arg11         | arg21      | arg12   | arg22      | arg02     | arg13     | arg03     | arg14   | arg04   |
      | "Christopher" | "Connely" | "L789C349" | "Frank" | "Christopher" | "A897N450" | "Minka" | "M098Q585" | "Connely" | "Jackson" | "Jackson" | "Frank" | "Minka" |


  Scenario: Performing customer operations; Bank deposit and withdrawal
    Given Starting the browser
    When i login as a customer
    And i select "Hermoine Granger" from the dropdown "userSelect"
    And i login
    And i select "1003" from the dropdown "accountSelect"
    And i deposit amount 50000
    And i go to transaction and verify transaction type "Credit" and amount 50000
    And i withdraw amount 3000
    And i go to transaction and verify transaction type "debit" and amount 3000
    And i withdraw amount 2000
    And i go to transaction and verify transaction type "debit" and amount 2000
    And i deposit amount 5000
    And i go to transaction and verify transaction type "credit" and amount 5000
    And i withdraw amount 10000
    And i go to transaction and verify transaction type "debit" and amount 10000
    And i withdraw amount 15000
    And i go to transaction and verify transaction type "debit" and amount 15000
    And i deposit amount 1500
    And i go to transaction and verify transaction type "credit" and amount 1500
    Then i verify the total balance to be 26500