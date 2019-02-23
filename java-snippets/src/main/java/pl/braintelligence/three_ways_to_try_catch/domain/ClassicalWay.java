package pl.braintelligence.three_ways_to_try_catch.domain;

import pl.braintelligence.three_ways_to_try_catch.infrastructure.CustomerDatabase;

public class ClassicalWay {

    public static String printDatabase() {
        return CustomerDatabase.getExternalCustomer();
//        CustomerDatabase.getInternalCustomer();
    }
}
