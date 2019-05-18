package pl.braintelligence.functional.standard.domain.user;

import io.vavr.control.Option;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.braintelligence.functional.standard.domain.address.OptionAddress;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionUser {
    private Option<String> name;
    private Option<OptionAddress> address;
}
