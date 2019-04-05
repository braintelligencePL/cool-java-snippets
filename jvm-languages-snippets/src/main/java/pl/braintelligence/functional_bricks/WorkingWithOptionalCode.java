package pl.braintelligence.functional_bricks;

import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import pl.braintelligence.functional_bricks.domain.address.Address;
import pl.braintelligence.functional_bricks.domain.address.OptionAddress;
import pl.braintelligence.functional_bricks.domain.user.OptionUser;
import pl.braintelligence.functional_bricks.domain.user.OptionUserRepository;
import pl.braintelligence.functional_bricks.domain.user.User;
import pl.braintelligence.functional_bricks.domain.user.UserRepository;

import java.util.Optional;

@RequiredArgsConstructor
public class WorkingWithOptionalCode {

    private final UserRepository userRepository;
    private final OptionUserRepository optionUserRepository;

    public WorkingWithOptionalCode(UserRepository userRepository, OptionUserRepository optionUserRepository) {
        this.userRepository = userRepository;
        this.optionUserRepository = optionUserRepository;
    }

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

        return null; // aggrrr...
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

    private Option<String> muchBetterWithFlatMap() {
        return optionUserRepository.findOne("123")
                .flatMap(OptionUser::getAddress)
                .map(OptionAddress::getStreet)
                .getOrElse(Option.none());
    }
}


