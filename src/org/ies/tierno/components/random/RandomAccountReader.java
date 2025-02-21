package org.ies.tierno.components.random;

import org.ies.tierno.components.Reader;
import org.ies.tierno.models.Account;
import org.ies.tierno.models.Customer;

import java.util.Random;

public class RandomAccountReader implements Reader<Account>{
    private final Random random;
    private final Reader<Customer> customerReader;

    public RandomAccountReader(Random random, Reader<Customer> customerReader) {
        this.random = random;
        this.customerReader = customerReader;
    }

    @Override
    public Account read() {
        return new Account(
                "ES"+random.nextInt(),
                random.nextDouble(),
                customerReader.read()
        );
    }
}
