package io.ermdev.samples.data.person;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("owners")
public class PersonController {

    private PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("{ownerId}")
    public ResponseEntity getById(@PathVariable("ownerId") Long personId) {
        Person person = personRepository.findById(personId);
        if (person != null) {
            return new ResponseEntity<>(person, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>("No owner found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity getAll() {
        Person persons[] = personRepository.findAll();
        if (persons != null) {
            return new ResponseEntity<>(persons, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>("No owner found", HttpStatus.NOT_FOUND);
        }
    }
}
