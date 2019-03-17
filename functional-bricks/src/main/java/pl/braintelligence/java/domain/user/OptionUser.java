package pl.braintelligence.java.domain.user;

import io.vavr.control.Option;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.braintelligence.java.domain.address.OptionAddress;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionUser {
    private Option<String> name;
    private Option<OptionAddress> address;
}
