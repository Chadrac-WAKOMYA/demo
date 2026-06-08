package com.example;

public class Account {
    private double balance;          // solde du compte
    private double overdraftLimit;   // limite de découvert autorisée

    // Constructeur : initialise le compte avec une limite de découvert
    public Account(double overdraftLimit) {
        this.balance = 0; 
        // si la limite passée est négative, on la force à 0
        this.overdraftLimit = overdraftLimit > 0 ? overdraftLimit : 0;
    }

    // Dépôt d’argent
    public boolean deposit(double amount) {
        if(amount >= 0) {
            this.balance += amount;
            return true;   // dépôt accepté
        }
        return false;      // dépôt refusé si montant négatif
    }

    // Retrait d’argent
    public boolean withdraw(double amount) {
        // Vérifie que le montant est positif et que le solde ne dépasse pas la limite de découvert
        if(this.balance - amount >= -this.overdraftLimit && amount >= 0) {
            this.balance -= amount;
            return true;   // retrait accepté
        }
        return false;      // retrait refusé
    }

    // Obtenir le solde actuel
    public double getBalance() {
        return balance;
    }

    // Obtenir la limite de découvert
    public double getOverdraftLimit() {
        return overdraftLimit;
    }
}

