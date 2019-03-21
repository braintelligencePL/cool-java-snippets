package pl.braintelligence.functional_java.vavr.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.braintelligence.functional_java.vavr.domain.address.Address;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    public static final int IBAN_LENGTH = 28;
    private String name;
    private Address address;
    private String accountNumber;

    // This check should be done while creating domain object
    // but lets assume that this is some legacy code so we have to work with it :(
    public static String legacyAccountNumberCheck(String accountNumber) {
        if (checkAccountNumberLength(accountNumber))
            throw new IllegalArgumentException("Invalid account number length.");
        return accountNumber;
    }

    private static boolean checkAccountNumberLength(String accountNumber) {
        return accountNumber.length() != IBAN_LENGTH;
    }
}

