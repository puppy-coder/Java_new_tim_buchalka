package com.codecafe.classes;

import java.util.regex.Pattern;

public class BankAccount {
    private String accountNumber;
    private Long accountBalance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public String getAccountNumber() {
        return accountNumber;
    }

    public Long getAccountBalance() {
        return accountBalance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountBalance(Long accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setEmail(String email) {
        String regexPattern = "^(.+)@(\\S+)$";
        boolean emailValidation = Pattern.compile(regexPattern)
                .matcher(email).matches();
       if(!emailValidation){
           System.out.println("Email should be in correct format");
       }
       else {
           this.email = email;
       }
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void depositFunds(Long depositAmount){
        accountBalance = accountBalance + depositAmount;
        System.out.println("Deposited funds = " + accountBalance);
    }
    public void withdrawFunds(Long withdrawalAmount){
        if(accountBalance - withdrawalAmount < 0){
            System.out.println("Insufficient Funds");
        }
        else{
            accountBalance = accountBalance - withdrawalAmount;
            System.out.println("Amount withdrawal = " + withdrawalAmount );
        }
    }
}
