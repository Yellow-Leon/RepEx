package org.ies.tierno.models;

import java.util.Arrays;
import java.util.Objects;

public class Bank {
    private String name;
    private Account[] accounts;

    public Bank(String name, Account[] accounts) {
        this.name = name;
        this.accounts = accounts;
    }

    public void showAccounts (){
        for (var account : accounts){
            System.out.println(account);
        }
    }

    public void showForIban(String iban){
        for (var account: accounts){
            if (account.getIban().equals(iban)){
                System.out.println(account);
            }
            else {
                System.out.println("No se encuentra la cuenta");
            }
        }
    }

    public void showForNif(String nif){
        for (var account: accounts){
            account.customerOfTheAccount(nif);
        }
    }

    public Account returnAccountByIban(String iban){
        for (var account: accounts){
            if (account.getIban().equals(iban)){
                return account;
            }
        }
        return null;
    }

    public void changeCurrency(String iban, double cash){
        showForIban(iban);
        Account account = returnAccountByIban(iban);
        account.changeNetworth(cash);
    }

    public Account returnAccountByNif(String nif){
        for (var account: accounts){
            account.returnCustomerFromAccount(nif);
        }
        return null;
    }

    public void howManyAccounts(String nif){
        int count=0;
        for (var account: accounts){
            account.returnCustomerFromAccount(nif);
            count+=1;
        }
        System.out.println("El cliente tiene " + count + " cuentas");
    }

    public Account returnCustomerByIban(String iban){
        for (var account: accounts){
            account.returnCustomerFromAccount(iban);
        }
        return null;
    }

    public void transferency (String iban1, String iban2 , double currency){
        Account account1= returnAccountByIban(iban1);
        Account account2 = returnAccountByIban(iban2);

        if (account1.getWorthnet() < currency){
            System.out.println("Saldo insuficiente");
        }
        else
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(name, bank.name) && Objects.deepEquals(accounts, bank.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Arrays.hashCode(accounts));
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", accounts=" + Arrays.toString(accounts) +
                '}';
    }
}
