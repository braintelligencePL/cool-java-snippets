package pl.braintelligence.three_ways_to_try_catch;

import lombok.extern.slf4j.Slf4j;
import pl.braintelligence.three_ways_to_try_catch.domain.ClassicalWay;
import pl.braintelligence.three_ways_to_try_catch.domain.DatabaseSignature;

@Slf4j
public class TryCatcher {
    public static void main(String[] args) {

        // Classical TryCatch:
        log.info("Classical TryCatch example: \n{}", ClassicalWay.printDatabase(DatabaseSignature.EXTERNAL_DATABASE));

        // First Functional TryCatch
        log.info("First functional result: \n{}", ClassicalWay.printDatabase(DatabaseSignature.INTERNAL_DATABASE));

        // Second Functional TryCatch
        log.info("Second functional result: \n{}", ClassicalWay.printDatabase(DatabaseSignature.INTERNAL_DATABASE));

    }
}




