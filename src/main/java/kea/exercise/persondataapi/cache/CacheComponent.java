package kea.exercise.persondataapi.cache;

import kea.exercise.persondataapi.person.Person;
import kea.exercise.persondataapi.person.PersonResponse;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class CacheComponent {
    private static final int MAX_ENTRIES = 100;

    private final Map<Person, PersonResponse> cache;

    public CacheComponent() {
        this.cache = new LinkedHashMap<>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Person, PersonResponse> eldest) {
                return size() > MAX_ENTRIES;
            }
        };
    }

    public PersonResponse get(Person key) {
        return cache.get(key);
    }

    public void put(Person key, PersonResponse value) {
        cache.put(key, value);
    }
}