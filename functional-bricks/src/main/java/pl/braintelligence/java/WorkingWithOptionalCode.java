package pl.braintelligence.java;

import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import pl.braintelligence.java.domain.*;

import java.util.Optional;

@RequiredArgsConstructor
public class WorkingWithOptionalCode {

    private UserRepository userRepository;
    private OptionUserRepository optionUserRepository;

    private String badCascadingPileOfCrapAndNull_WorstOfTheWorstest() {
        User user = userRepository.findOne("123");

        if (user != null) {
            Address address = user.getAddress();
            if (address != null) {
                return address.getStreet();
            }
        }

        return null;
    }

    private Optional<Address> badCascadingOptionalPileOfCrap() {
        Optional<User> user = Optional.ofNullable(userRepository.findOne("123"));

        if (user.isPresent()) {
            Optional<Address> address = Optional.ofNullable(user.get().getAddress());

            if (address.isPresent()) {
                return address;
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

