package pl.braintelligence.kotlin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class JavaAddress {
    private String street;
}
