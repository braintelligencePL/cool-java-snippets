package pl.braintelligence.three_ways_to_try_catch.infrastructure;

import pl.braintelligence.three_ways_to_try_catch.infrastructure.exceptions.ExternalCustomerException;
import pl.braintelligence.three_ways_to_try_catch.infrastructure.exceptions.InternalCustomerException;


public class CustomerDatabase {

    public static String getInternalCustomer(boolean throwException) throws InternalCustomerException {

        if (throwException)
            throw new InternalCustomerException("Couldn't get data from MongoDB");

        return "INTERNAL Customer - from your mongoDB\n";
    }

    public static String getExternalCustomer(boolean throwException) throws ExternalCustomerException {

        if (throwException)
            throw new ExternalCustomerException("Couldn't fetch data from server");

        return "EXTERNAL Customer - fetched from server through HTTP\n";
    }

}
