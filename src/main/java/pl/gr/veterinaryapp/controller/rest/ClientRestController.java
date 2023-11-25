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
import pl.gr.veterinaryapp.mapper.ClientMapper;
import pl.gr.veterinaryapp.model.dto.ClientRequestDto;
import pl.gr.veterinaryapp.model.dto.ClientResponseDto;
import pl.gr.veterinaryapp.service.ClientService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/clients")
@Slf4j
public class ClientRestController {

    private final ClientService clientService;
    private final ClientMapper mapper;

    @GetMapping("/{id}")
    public ClientResponseDto getClient(@PathVariable long id) {
        log.info("Get client for id: {}", id);
        var client =  mapper.map(clientService.getClientById(id));
        log.info("Return client: {}", client);
        return client;
    }

    @PostMapping
    public ClientResponseDto createClient(@RequestBody ClientRequestDto clientRequestDTO) {
        log.info("Create new client: {}", clientRequestDTO);
        var client = mapper.map(clientService.createClient(clientRequestDTO));
        log.info("Return created client: {}", client);
        return client;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        log.info("Delete client with id: {}", id);
        clientService.deleteClient(id);
    }

    @GetMapping
    public List<ClientResponseDto> getAllClients() {
        log.info("Get list of all clients");
        var clients =  mapper.mapAsList(clientService.getAllClients());
        log.info("Return list of all clients: {}", clients);
        return clients;
    }
}
