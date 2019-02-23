package pl.braintelligence.three_ways_to_try_catch.infrastructure.exceptions;

public class ExternalCustomerException extends Exception {
    public ExternalCustomerException(String message) {
        super(message);
    }
}
