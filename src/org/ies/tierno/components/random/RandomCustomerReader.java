package org.ies.tierno.components.random;

import org.ies.tierno.components.Reader;
import org.ies.tierno.models.Customer;

import java.util.Random;

public class RandomCustomerReader implements Reader<Customer>{
    private final Random random;

    public RandomCustomerReader(Random random) {
        this.random = random;
    }

    private final static String[] NAMES = {"Ana","Anais","Alejandro" ,"Armando" ,"Alex" ,"Alejandra" , "Alicia","Amanda"
            ,"Arnaldo","Araceli","Antonela" , "Bernardo" , "Bernardino" ,"Benito","Bill"};

    private final static String[] LASTNAMES = {"Amarilla","Almada","Armani" ,"" ,"Alex" ,"Alejandra" , "Alicia","Amanda"
            ,"Arnaldo","Araceli","Antonela" , "Bernardo" , "Bernardino" ,"Benito","Bill"};

    private final static String[] NIF = {"10192823A","10192823B","10192823C" ,"20292827A" ,"20292827B" ,"20292827C" , "30393837A",
           "30393837B" ,"30393837C","40494874A","40494874B" , "40494874C"};


    @Override
    public Customer read() {
        return new Customer(
                NAMES[random.nextInt(NAMES.length)],
                LASTNAMES[random.nextInt(LASTNAMES.length)],
                NIF[random.nextInt(NIF.length)]
        );
    }
}
