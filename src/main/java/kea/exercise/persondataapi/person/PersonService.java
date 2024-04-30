package kea.exercise.persondataapi.person;

import kea.exercise.persondataapi.agify.AgifyResponse;
import kea.exercise.persondataapi.agify.AgifyService;
import kea.exercise.persondataapi.cache.CacheComponent;
import kea.exercise.persondataapi.genderize.GenderizeResponse;
import kea.exercise.persondataapi.genderize.GenderizeService;
import kea.exercise.persondataapi.nationalize.NationalizeResponse;
import kea.exercise.persondataapi.nationalize.NationalizeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final CacheComponent cacheComponent;
    private final AgifyService agifyService;
    private final GenderizeService genderizeService;
    private final NationalizeService nationalizeService;

    public PersonService(CacheComponent cacheComponent, AgifyService agifyService, GenderizeService genderizeService, NationalizeService nationalizeService) {
        this.cacheComponent = cacheComponent;
        this.agifyService = agifyService;
        this.genderizeService = genderizeService;
        this.nationalizeService = nationalizeService;
    }

    public PersonResponse checkPersonAgeGenderAndNationality(Person person) {
        // Check if the person is in the cache
        PersonResponse cachedResponse = cacheComponent.get(person);
        if (cachedResponse != null) {
            System.out.println("Person found in cache, returning cached response");
            return cachedResponse;
        }

        // If the person is not in the cache, fetch from external APIs
        System.out.println("Person not in cache, fetching from external APIs");
        AgifyResponse agifyResponse = agifyService.getAgifyResponse(person.fullName());
        GenderizeResponse genderizeResponse = genderizeService.getGenderizeResponse(person.fullName());
        NationalizeResponse nationalizeResponse = nationalizeService.getNationalizeResponse(person.fullName());

        PersonResponse personResponse = toPersonResponse(person, agifyResponse, genderizeResponse, nationalizeResponse);
        cacheComponent.put(person, personResponse);

        return personResponse;
    }

    private PersonResponse toPersonResponse(Person person, AgifyResponse agifyResponse, GenderizeResponse genderizeResponse, NationalizeResponse nationalizeResponse) {
        return new PersonResponse(
                person.fullName(),
                person.firstName(),
                person.middleName(),
                person.lastName(),
                genderizeResponse.gender(),
                genderizeResponse.probability(),
                agifyResponse.age(),
                nationalizeResponse.country().getFirst().country_id(),
                Double.parseDouble(String.format("%.2f", nationalizeResponse.country().getFirst().probability()))
        );
    }

    public List<PersonResponse> getCache() {
        return cacheComponent.getAll();
    }
}
