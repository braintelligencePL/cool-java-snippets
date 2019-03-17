package pl.braintelligence.java.domain;

import lombok.Data;

import javax.swing.text.html.Option;

@Data
public class User {
    private Option name;
    private Address address;
}
