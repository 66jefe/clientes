package io.github.jefe.clientes.rest;

import io.github.jefe.clientes.model.entity.Cliente;
import io.github.jefe.clientes.model.entity.ServicoPrestado;
import io.github.jefe.clientes.model.repository.ClienteRespository;
import io.github.jefe.clientes.model.repository.ServicoPrestadoRepository;
import io.github.jefe.clientes.rest.dto.ServicoPrestadoDTO;
import io.github.jefe.clientes.util.BigDecimalConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@RestController
@RequestMapping("/api/sevico-prestado")
@RequiredArgsConstructor
public class ServicoPrestadoController {

    private final ClienteRespository clienteRespository;
    private final ServicoPrestadoRepository respository;
    private final BigDecimalConverter bigDecimalConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestado salvar(@RequestBody ServicoPrestadoDTO dto){
        LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Integer idCliente = dto.getIdCliente();

        Cliente cliente = clienteRespository
                .findById(idCliente).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente Inexistente"));

        ServicoPrestado servicoPrestado = new ServicoPrestado();
        servicoPrestado.setDescricao(dto.getDescricao());
        servicoPrestado.setData(data);
        servicoPrestado.setCliente(cliente);
        servicoPrestado.setValor(bigDecimalConverter.converter(dto.getPreco()));

        return respository.save(servicoPrestado);
    }

}
