package com.example;

import org.junit.Assert;
import org.junit.Test;

public class AccountTest {
    private double epsilon = 1e-6;

    @Test
    public void accountCannotHaveNegativeOverdraftLimit() {
        Account account = new Account(-20);        
        Assert.assertEquals(0d, account.getOverdraftLimit(), epsilon);
    }

    @Test
    public void accountCanHavePositiveOverdraftLimit() {
        Account account = new Account(20);        
        Assert.assertEquals(20d, account.getOverdraftLimit(), epsilon);
    }

    @Test
    public void accountCantAcceptNegativeDeposit() {
        Account account = new Account(100);        
        boolean result = account.deposit(-10);
        Assert.assertFalse(result);
    }

    @Test
    public void accountCantAcceptNegativeWithdrawal() {
        Account account = new Account(100);        
        boolean result = account.withdraw(-10);
        Assert.assertFalse(result);
    }

    @Test
    public void accountCantWithdrawMoreThanOverdraftLimit() {
        Account account = new Account(100);        
        boolean result = account.withdraw(150);
        Assert.assertFalse(result);
    }

    @Test
    public void withdrawReturnsACorrectBalance() {
        Account account = new Account(100);        
        account.deposit(50);
        boolean result = account.withdraw(120);
        Assert.assertFalse(result);
        Assert.assertEquals(50, account.getBalance(), epsilon);
    }

    @Test
    public void depositReturnsACorrectBalance() {
        Account account = new Account(100);        
        account.deposit(50);
        Assert.assertEquals(50, account.getBalance(), epsilon);
    }
}
