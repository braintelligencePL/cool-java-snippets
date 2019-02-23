package pl.braintelligence.three_ways_to_try_catch;

import lombok.extern.slf4j.Slf4j;
import pl.braintelligence.three_ways_to_try_catch.domain.ClassicalWay;

@Slf4j
public class TryCatcher {
    public static void main(String[] args) {

        // Classical TryCatch:
        log.info("Classical result: \n{}", ClassicalWay.printDatabase());

        // First Functional TryCatch
        log.info("First functional result: \n{}", ClassicalWay.printDatabase());

        // Second Functional TryCatch
        log.info("Second functional result: \n{}", ClassicalWay.printDatabase());

    }
}




