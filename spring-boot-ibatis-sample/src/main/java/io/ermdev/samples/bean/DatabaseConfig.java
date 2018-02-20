package io.ermdev.samples.bean;

import io.ermdev.samples.data.person.PersonRepository;
import io.ermdev.samples.data.pet.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConfig implements CommandLineRunner {

    private PersonRepository personRepository;
    private PetRepository petRepository;

    @Autowired
    public DatabaseConfig(PersonRepository personRepository, PetRepository petRepository) {
        this.personRepository = personRepository;
        this.petRepository = petRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        personRepository.createTable();
        petRepository.createTable();
    }
}
