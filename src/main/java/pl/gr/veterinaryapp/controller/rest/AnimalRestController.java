package pl.gr.veterinaryapp.controller.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.gr.veterinaryapp.model.dto.AnimalRequestDto;
import pl.gr.veterinaryapp.model.entity.Animal;
import pl.gr.veterinaryapp.service.AnimalService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/animals")
@Slf4j
public class AnimalRestController {

    private final AnimalService animalService;

    @GetMapping("/{id}")
    public Animal getAnimal(@PathVariable long id) {
        log.info("Get animal with given id: {}", id);
        var animal = animalService.getAnimalById(id);
        log.info("Return animal: {}", animal);
        return animal;
    }

    @PostMapping
    public Animal createAnimal(@RequestBody AnimalRequestDto animalRequestDTO) {
        log.info("Create new animal: {}", animalRequestDTO);
        var animal = animalService.createAnimal(animalRequestDTO);
        log.info("Return created animal: {}", animal);
        return animal;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        log.info("Remove animal with given id: {}", id);
        animalService.deleteAnimal(id);
    }

    @GetMapping
    public List<Animal> getAllAnimals() {
        log.info("Get list of all animals");
        var animals = animalService.getAllAnimals();
        log.info("Return list of all animals: {}", animals);
        return animals;
    }
}
