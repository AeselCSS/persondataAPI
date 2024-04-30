package kea.exercise.persondataapi.person;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static kea.exercise.persondataapi.person.Utility.nameParts;

@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public ResponseEntity<PersonResponse> checkPersonAgeGenderAndNationality(@RequestParam String query) {
        List<String> names = nameParts(query);
        Person person = new Person(names.getFirst(), names.get(1), names.get(2), names.get(3));

        return ResponseEntity.ok(personService.checkPersonAgeGenderAndNationality(person));
    }
}
