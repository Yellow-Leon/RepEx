package org.ies.tierno.components.random;

import org.ies.tierno.components.Reader;
import org.ies.tierno.models.Account;
import org.ies.tierno.models.Bank;

import java.util.Random;

public class RandomBankReader implements Reader<Bank> {
    private final Random random;
    private final Reader<Account> accountReader;

    public RandomBankReader(Random random, Reader<Account> accountReader) {
        this.random = random;
        this.accountReader = accountReader;
    }

    private final static String[] BANKNAME = {"CaixaBank","Liberty City Bank","MazeBank" ,"IGN" ,"Revolut" ,"BBVA" , "UOMO",
            };
    @Override
    public Bank read() {
        Account[] accounts = new Account[random.nextInt(100,1000)];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i]= accountReader.read();
        }

        return new Bank(
                BANKNAME[random.nextInt(BANKNAME.length)],
                accounts
        );
    }
}
