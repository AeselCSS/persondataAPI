package kea.exercise.persondataapi.nationalize;

import java.util.List;

public record NationalizeResponse(
        int count,
        String name,
        List<Country> country
) {
}
