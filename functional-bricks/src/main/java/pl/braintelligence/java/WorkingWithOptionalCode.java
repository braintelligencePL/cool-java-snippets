package pl.braintelligence.java;

import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import pl.braintelligence.java.domain.address.Address;
import pl.braintelligence.java.domain.address.OptionAddress;
import pl.braintelligence.java.domain.user.OptionUser;
import pl.braintelligence.java.domain.user.OptionUserRepository;
import pl.braintelligence.java.domain.user.User;
import pl.braintelligence.java.domain.user.UserRepository;

import java.util.Optional;

@RequiredArgsConstructor
public class WorkingWithOptionalCode {

    private final UserRepository userRepository;
    private final OptionUserRepository optionUserRepository;

    private String badCascadingPileOfCrapAndReturnNull_WorstOfTheWorstest() {
        User user = userRepository.findOne("123");

        if (user != null) {
            Address address = user.getAddress();
            if (address != null) {
                String street = address.getStreet();
                if (street != null) {
                    return street; // ufff.. finally...
                }
            }
        }

        return null;
    }

    private Optional<String> badCascadingOptionalPileOfCrap() {
        Optional<User> user = Optional.ofNullable(userRepository.findOne("123"));

        if (user.isPresent()) {
            Optional<Address> address = Optional.ofNullable(user.get().getAddress());
            if (address.isPresent()) {
                Optional<String> street = Optional.ofNullable(address.get().getStreet());
                if (street.isPresent()) {
                    return street; // even worse hell... not a way to go...
                }
            }
        }

        return Optional.empty();
    }

    private Option<String> muchBetterWithOption() {
        return optionUserRepository.findOne("123")
                .flatMap(OptionUser::getAddress)
                .map(OptionAddress::getStreet)
                .getOrElse(Option.none());
    }
}


