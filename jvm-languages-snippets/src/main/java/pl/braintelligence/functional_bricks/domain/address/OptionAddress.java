package pl.braintelligence.functional_bricks.domain.address;

import io.vavr.control.Option;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionAddress {
    private Option<String> street;
}
