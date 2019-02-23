package pl.braintelligence.three_ways_to_try_catch.infrastructure;

import pl.braintelligence.three_ways_to_try_catch.infrastructure.exceptions.ExternalCustomerException;
import pl.braintelligence.three_ways_to_try_catch.infrastructure.exceptions.InternalCustomerException;


public class CustomerDatabase {

    public static String getInternalCustomer() throws InternalCustomerException {

//        throw new InternalCustomerException();
        return "INTERNAL Customer - from your mongoDB\n";
    }

    public static String getExternalCustomer() throws ExternalCustomerException {

//        throw new ExternalCustomerException();
        return "EXTERNAL Customer - fetched from server through HTTP\n";
    }

}
