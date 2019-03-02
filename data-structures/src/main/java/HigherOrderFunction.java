import java.util.function.Consumer;

public class HigherOrderFunction {
    public static void main(String[] args) {
        availableCustomers(Customer::isAvailable);
    }

    static void availableCustomers(Consumer<Customer> customerConsumer) {
    }
}

class Customer {
    boolean isAvailable() {
        return true;
    }
}
