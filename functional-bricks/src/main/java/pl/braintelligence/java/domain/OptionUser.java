package pl.braintelligence.java.domain;

import io.vavr.control.Option;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionUser {
    private Option<String> name;
    private Option<OptionAddress> address;
}
