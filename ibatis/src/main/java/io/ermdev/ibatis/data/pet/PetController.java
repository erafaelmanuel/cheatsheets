package io.ermdev.ibatis.data.pet;

import io.ermdev.ibatis.data.person.Person;
import mapfierj.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pet")
public class PetController {

    private PetRepository petRepository;
    private Mapper mapper;

    @Autowired
    public PetController(PetRepository petRepository, Mapper mapper) {
        this.petRepository = petRepository;
        this.mapper = mapper;
    }

    @GetMapping(value = "{petId}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<PetDto> getById(@PathVariable("petId") Long petId) {
        PetDto petDto = mapper.set(petRepository.findById(petId))
                .field("ownerId", "owner")
                .convertField("owner", Person.class)
                .mapTo(PetDto.class);
        return new ResponseEntity<>(petDto, HttpStatus.FOUND);
    }
}
