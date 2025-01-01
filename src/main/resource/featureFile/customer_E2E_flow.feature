Feature: Customer Operations

#TC_Customer_01
Scenario: To validate that a customer can successfully log in to their XYZ Bank account, perform deposit and withdrawal transactions, view transaction history, and log out of the banking system.
Given a customer "Ron Weasly" account exists with at least one account in XYZ Bank
When the customer logs in with the username
Then the customer "Ron Weasly" should be redirected to the account dashboard 
And the customer should be able to deposit 100
And withdraw 50 successfully
And the customer should be able to view the transaction history
When the customer logs out of the system
Then the customer should be successfully logged out and redirected to the login page


#TC_Customer_02
Scenario: To validate that a customer can successfully log in to their XYZ Bank account, and when the customer holds multiple accounts, the system allows them to switch between these accounts. The customer should be able to perform deposit and withdrawal transactions for each account, view the transaction history for each account, and log out of the banking system successfully.
Given a customer "Harry Potter" account exists with multiple account in XYZ Bank
When the customer logs in with the username 
Then the customer "Harry Potter" should be redirected to the account dashboard 
And the customer should be able to deposit 100
And withdraw 50 successfully
And the customer should be able to view the transaction history
Then the customer switch to another account
And the customer should be able to deposit 100
And withdraw 50 successfully
And the customer should be able to view the transaction history
When the customer logs out of the system
Then the customer should be successfully logged out and redirected to the login page


#TC_Customer_03
Scenario: To validate that a customer can successfully log in to their XYZ Bank account and customer hold 0 accounts, so verify the customer can't perform deposit, withdrawl and view the transaction operations at last log out of the banking system.
Given setup test data "Vijayan" "KS" "TestPostCode" with 0 account in XYZ Bank
Given a customer "Vijayan KS" account exists with 0 account in XYZ Bank
When the customer logs in with the username 
Then the customer "Vijayan KS" should be redirected to the account dashboard
And no deposit, withdrawl, transaction feature are available for customer having 0 account
When the customer logs out of the system
Then the customer should be successfully logged out and redirected to the login page


#TC_Customer_04
Scenario: To validate that a customer can successfully log in to their XYZ Bank account, perform a deposit transaction, and attempt a withdrawal that exceeds the available account balance, which should result in a failed transaction, and log out of the banking system.
Given a customer "Albus Dumbledore" account exists with at least one account in XYZ Bank.
When the customer logs in with the username 
Then the customer "Albus Dumbledore" should be redirected to the account dashboard
And the customer should be able to deposit 100
And withdraw 1200 exceed with the current available balance was unsuccessfull
And the customer should be able to view the transaction history
When the customer logs out of the system
Then the customer should be successfully logged out and redirected to the login page


#TC_Customer_05
Scenario: To validate that a customer can successfully log in to their XYZ Bank account, perform deposit and withdrawal transactions, view the transaction history, log out of the banking system, and then re-login to their account perform deposit transaction verify the addition of new transactions to the transaction history and log out of the banking system
Given a customer "Neville Longbottom" account exist with at least one account in XYZ Bank
When the customer logs in with the username
Then the customer "Neville Longbottom" should be redirected to the account dashboard
And the customer should be able to deposit 100
And withdraw 50 successfully
And the customer should be able to view the transaction history
When the customer logs out of the system
Then the customer should be successfully logged out and redirected to the login page
When the customer "Neville Longbottom" re-login
And the customer should be able to deposit 100
And the customer should be able to view the updated transaction history
When the customer logs out of the system
Then the customer should be successfully logged out and redirected to the login page



