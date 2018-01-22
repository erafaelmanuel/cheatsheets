package io.ermdev.ibatis.data.pet;

import io.ermdev.ibatis.data.person.PersonRepository;
import io.ermdev.ibatis.typeconverter.PersonConverter;
import io.ermdev.mapfierj.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pet")
public class PetController {

    private PetRepository petRepository;
    private PersonRepository personRepository;

    @Autowired
    public PetController(PetRepository petRepository, PersonRepository personRepository) {
        this.petRepository = petRepository;
        this.personRepository = personRepository;
    }

    @GetMapping("{petId}")
    PetDto findById(@PathVariable("petId") Long petId) {
        PersonConverter converter = new PersonConverter();
        converter.setPersonRepository(personRepository);

        ModelMapper mapper = new ModelMapper();

        PetDto pet = mapper.set(petRepository.findById(petId))
                .field("ownerId", "owner")
                .convertFieldByConverter("owner", converter)
                .getTransaction().mapTo(PetDto.class);
        return pet;
    }
}
