package kea.exercise.persondataapi.person;

public record PersonResponse(
        String fullName,
        String firstName,
        String middleName,
        String lastName,
        String gender,
        double genderProbability,
        int age,
        String country,
        double countryProbability
) {
}
