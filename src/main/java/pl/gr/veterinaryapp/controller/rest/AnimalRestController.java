package pl.gr.veterinaryapp.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.gr.veterinaryapp.mapper.AnimalMapper;
import pl.gr.veterinaryapp.model.dto.AnimalRequestDto;
import pl.gr.veterinaryapp.model.dto.AnimalResponseDto;
import pl.gr.veterinaryapp.service.AnimalService;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/animals")
public class AnimalRestController {

    private final AnimalService animalService;
    private final AnimalMapper mapper;

    @GetMapping("/{id}")
    public AnimalResponseDto getAnimal(@PathVariable long id) {
        return mapper.mapToResponse(animalService.getAnimalById(id));
    }

    @PostMapping
    public AnimalResponseDto createAnimal(@RequestBody AnimalRequestDto animalRequestDTO) {
        return mapper.mapToResponse(animalService.createAnimal(animalRequestDTO));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        animalService.deleteAnimal(id);
    }

    @GetMapping
    public List<AnimalResponseDto> getAllAnimals() {
        return animalService.getAllAnimals()
                .stream()
                .map(animal -> mapper.mapToResponse(animal))
                .collect(Collectors.toList());
    }
}
