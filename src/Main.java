import org.ies.tierno.components.Reader;
import org.ies.tierno.components.random.RandomAccountReader;
import org.ies.tierno.components.random.RandomBankReader;
import org.ies.tierno.components.random.RandomCustomerReader;
import org.ies.tierno.models.Account;
import org.ies.tierno.models.Bank;
import org.ies.tierno.models.Customer;

import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Reader<Customer> customerReader = new RandomCustomerReader(random);
        Reader<Account> accountReader = new RandomAccountReader(random,customerReader);
        Reader<Bank> bankReader = new RandomBankReader(random,accountReader);

        Bank bank = bankReader.read();
        bank.showAccounts();
    }
}