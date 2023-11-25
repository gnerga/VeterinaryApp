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
import pl.gr.veterinaryapp.model.dto.VetRequestDto;
import pl.gr.veterinaryapp.model.entity.Vet;
import pl.gr.veterinaryapp.service.VetService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/vets")
@Slf4j
public class VetRestController {

    private final VetService vetService;

    @GetMapping("/{id}")
    public Vet getVet(@PathVariable long id) {
        log.info("Get vet with given id: {}", id);
        var vet = vetService.getVetById(id);
        log.info("Return client: {}", vet);
        return vet;
    }

    @PostMapping
    public Vet addVet(@RequestBody VetRequestDto vetRequestDTO) {
        log.info("Add new vet: {}", vetRequestDTO);
        var vet =  vetService.createVet(vetRequestDTO);
        log.info("Return added vet: {}", vet);
        return vet;
    }

    @GetMapping
    public List<Vet> getAllVets() {
        log.info("Get list of all vets");
        var vets =  vetService.getAllVets();
        log.info("Return list of all vets: {}", vets);
        return vets;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        log.info("Remove vet with given id: {}", id);
        vetService.deleteVet(id);
    }
}
