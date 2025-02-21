package org.ies.tierno.models;

import java.util.Objects;

public class Account {
    private String iban;
    private double worthnet;
    private Customer customer;

    public Account(String iban, double worthnet, Customer customer) {
        this.iban = iban;
        this.worthnet = worthnet;
        this.customer = customer;
    }

    public void changeNetworth(double currency){
        if (currency !=)
        worthnet += currency;
        System.out.println(worthnet);
    }

    public void customerOfTheAccount(String nif){
        System.out.println(customer);
    }

    public Customer returnCustomerFromAccount(String nif){
        if (customer.getNif().equals(nif)){
            return customer;
        }
        return null;
    }

    public Customer returnCustomerFromIban(String ibanSearched){
        if (iban.equals(ibanSearched)){
            return customer;
        }
        return null;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getWorthnet() {
        return worthnet;
    }

    public void setWorthnet(double worthnet) {
        this.worthnet = worthnet;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(worthnet, account.worthnet) == 0 && Objects.equals(iban, account.iban) && Objects.equals(customer, account.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, worthnet, customer);
    }

    @Override
    public String toString() {
        return "Account{" +
                "iban='" + iban + '\'' +
                ", worthnet=" + worthnet +
                ", customers=" + customer +
                '}';
    }
}
