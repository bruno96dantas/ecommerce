package br.com.bruno.ecommerce.controllers;

import br.com.bruno.ecommerce.dto.ClientDto;
import br.com.bruno.ecommerce.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity create(@RequestBody ClientDto clientDto) {
        clientService.create(clientDto);

        return ResponseEntity.ok(clientDto);
    }

    @GetMapping
    public ResponseEntity findAll() {

        return ResponseEntity.ok(clientService.getAll());
    }

    @PutMapping
    public ResponseEntity update(@RequestBody ClientDto clientDto) {

        clientService.update(clientDto);

        return ResponseEntity.ok(clientDto);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity delete(@PathVariable("clientId") Long clientId) {

        clientService.delete(clientId);

        return ResponseEntity.ok().build();
    }
}
