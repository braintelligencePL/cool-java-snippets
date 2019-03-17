package pl.braintelligence.java.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.swing.text.html.Option;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private Address address;
}
