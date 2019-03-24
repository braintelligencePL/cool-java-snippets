package pl.braintelligence.functional_java.vavr.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.braintelligence.functional_java.vavr.domain.address.Address;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private Address address;
    private String accountNumber;

    public static List<String> findUserInfoByAccountNumber(String accountNumber) throws IOException {

        return Files.lines(Paths.get(accountNumber))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

}

