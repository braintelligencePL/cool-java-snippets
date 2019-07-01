package pl.braintelligence;

import lombok.Getter;

public class E05_FieldsProperties {

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Other Jack");

        System.out.println(person.getName());
    }

    @Getter
    public static class Person {
        private String name = "Jack";

        public void setName(String name) {
            if (name != null && !name.isEmpty()) {
                this.name = name;
            }
        }
    }

}
