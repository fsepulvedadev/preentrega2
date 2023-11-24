package com.cliente.apiRest.service;

import com.cliente.apiRest.model.ClientModel;
import com.cliente.apiRest.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public ClientModel create(ClientModel newClient) {
        return this.clientRepository.save(newClient);
    }

    public String findByID(Long id) {
        Optional<ClientModel> cajaCliente = this.clientRepository.findById(id);

        if(cajaCliente.isPresent()) {

            ClientModel c = cajaCliente.get();


            String jsonFormat = "{ \n" +
                  "\"id\": " + c.getId() + "," +
                "\"name\": " + c.getNombre() + "," +
                 "\"lastName\": " + c.getApellido() + "," +
              "\"edad\": " + this.calcularEdad(c.getFechaNac()) +
        "}";

            return jsonFormat;
        }

        return null;
    }


    public int calcularEdad(LocalDate fechaNacimiento) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNac = LocalDate.parse(fechaNacimiento.toString(),fmt);

        Period periodo = Period.between(fechaNac, fechaActual);

        return periodo.getYears();

    }

}
