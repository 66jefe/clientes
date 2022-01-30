package io.github.jefe.clientes.model.repository;

import io.github.jefe.clientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRespository extends JpaRepository<Cliente, Integer> {
}
