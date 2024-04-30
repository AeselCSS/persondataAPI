package kea.exercise.persondataapi.person;

public record PersonResponse(
        String fullName,
        String firstName,
        String middleName,
        String lastName,
        String gender,
        double genderProbability,
        int age,
        double ageProbability,
        String country,
        double countryProbability
) {
}