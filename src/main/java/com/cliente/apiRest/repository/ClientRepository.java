package com.cliente.apiRest.repository;

import com.cliente.apiRest.model.ClientModel;
import com.cliente.apiRest.service.ClientService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<ClientModel, Long> {

}
