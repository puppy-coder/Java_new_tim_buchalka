package com.codecafe.classes;

public class ClassesChallenge {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountNumber("6786540998");
        bankAccount.setAccountBalance(10000L);
        bankAccount.setCustomerName("Dhanalakshmi");
        bankAccount.setPhoneNumber("9876435678");
        bankAccount.setEmail("katheerdhana@gmail.com");
        bankAccount.depositFunds(10000L);
        bankAccount.withdrawFunds(5000L);
        System.out.println("Balance in account = " + bankAccount.getAccountBalance());

        System.out.println(bankAccount.getEmail());
    }
}
