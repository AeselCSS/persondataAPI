package kea.exercise.persondataapi.person;

import java.util.Objects;

public record Person(
        String fullName,
        String firstName,
        String middleName,
        String lastName
) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(fullName, person.fullName) && Objects.equals(lastName, person.lastName) && Objects.equals(firstName, person.firstName) && Objects.equals(middleName, person.middleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, firstName, middleName, lastName);
    }
}
