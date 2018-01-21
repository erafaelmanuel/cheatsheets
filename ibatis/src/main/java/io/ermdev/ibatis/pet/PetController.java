package io.ermdev.ibatis.pet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pet")
public class PetController {

    private PetRepository petRepository;

    public PetController(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @GetMapping("{petId}")
    Pet findById(@PathVariable("petId") Long petId) {
        return petRepository.findById(petId);
    }

    @GetMapping
    Pet add() {
        Pet pet = new Pet("Sonny", 21);
        petRepository.add(pet);
        return pet;
    }
}
