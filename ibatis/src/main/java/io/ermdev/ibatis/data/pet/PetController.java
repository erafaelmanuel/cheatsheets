package io.ermdev.ibatis.data.pet;

import io.ermdev.ibatis.data.person.Person;
import io.ermdev.mapfierj.ModelMapper;
import io.ermdev.mapfierj.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pet")
public class PetController {

    private PetRepository petRepository;
    private ModelMapper mapper;

    @Autowired
    public PetController(PetRepository petRepository, ModelMapper mapper) {
        this.petRepository = petRepository;
        this.mapper = mapper;
    }

    @GetMapping("{petId}")
    PetDto findById(@PathVariable("petId") Long petId) {
        Transaction transaction = mapper.set(petRepository.findById(petId))
                .field("ownerId", "owner")
                .convertFieldToType("owner", Person.class)
                .getTransaction();

        return transaction.mapTo(PetDto.class);
    }
}
