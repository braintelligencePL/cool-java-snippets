import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.util.function.Supplier;

@Slf4j
public class HigherOrderFunctions {
    public static void main(String[] args) {

        val higherOrderFunctions = new HigherOrderFunctions();

        // function( takes another function as parameter )
        log.info(higherOrderFunctions.isCustomerAvailable(Customer::isAvailable));

    }

    private String isCustomerAvailable(Supplier<Boolean> customerFunction) {
        return String.valueOf(customerFunction.get());
    }
}

class Customer {
    static boolean isAvailable() {
        return true;
    }
}

