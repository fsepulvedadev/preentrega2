package com.cliente.apiRest.controller;

import com.cliente.apiRest.model.ClientModel;
import com.cliente.apiRest.repository.ClientRepository;
import com.cliente.apiRest.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClientController {


    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientService clientService;

    @GetMapping("/")
    public List<ClientModel> obtenerClientes() {

        
        return clientRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById (@PathVariable Long id){

        return new ResponseEntity<>(this.clientService.findByID(id), HttpStatus.OK);
    }


}
