import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.util.function.Supplier;
import java.util.stream.Stream;

@Slf4j
public class HigherOrderFunctions {
    public static void main(String[] args) {

        val higherOrderFunctions = new HigherOrderFunctions();

        log.info(higherOrderFunctions.availableCustomers(Customer::isAvailable));

        int[] ar = {1, 2, 3};

        Stream<int[]> integers = Stream.of(ar);


    }

    private String availableCustomers(Supplier<Boolean> customerFunction) {
        return String.valueOf(customerFunction.get());
    }
}

class Customer {
    static boolean isAvailable() {
        return true;
    }
}
