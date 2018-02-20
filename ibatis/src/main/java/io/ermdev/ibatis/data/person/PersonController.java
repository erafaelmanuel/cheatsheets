package io.ermdev.ibatis.data.person;

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

    @GetMapping("{personId}")
    public Person getById(@PathVariable("personId") Long personId) {
        return personRepository.findById(personId);
    }
}
