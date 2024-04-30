package kea.exercise.persondataapi.agify;

public record AgifyResponse(
        int count,
        String name,
        int age
) {
}
