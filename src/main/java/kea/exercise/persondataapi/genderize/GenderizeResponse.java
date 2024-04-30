package kea.exercise.persondataapi.genderize;

public record GenderizeResponse(
        int count,
        String name,
        String gender,
        double probability
) {
}
