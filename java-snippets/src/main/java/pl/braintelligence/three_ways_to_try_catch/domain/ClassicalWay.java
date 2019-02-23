package pl.braintelligence.three_ways_to_try_catch.domain;

import lombok.extern.slf4j.Slf4j;
import pl.braintelligence.three_ways_to_try_catch.infrastructure.CustomerDatabase;
import pl.braintelligence.three_ways_to_try_catch.infrastructure.exceptions.ExternalCustomerException;
import pl.braintelligence.three_ways_to_try_catch.infrastructure.exceptions.InternalCustomerException;

@Slf4j
public class ClassicalWay {

    public static String printDatabase(DatabaseSignature databaseSignature) {

        try {
            switch (databaseSignature) {
                case EXTERNAL_DATABASE:
                    return CustomerDatabase.getInternalCustomer(true);
                case INTERNAL_DATABASE:
                    return CustomerDatabase.getExternalCustomer(true);
            }
        } catch (InternalCustomerException e) {
            e.printStackTrace();
        } catch (ExternalCustomerException e) {
            e.printStackTrace();
        }

        return null;
    }
}
