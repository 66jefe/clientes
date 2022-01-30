package io.github.jefe.clientes.rest.excption;

import org.springframework.beans.factory.ListableBeanFactory;

import java.util.Arrays;
import java.util.List;

public class ApiErrors {
    private List<String> errors;

    public ApiErrors(List<String> errors){
        this.errors = errors;
    }

    public ApiErrors(String message){
        this.errors = Arrays.asList(message);
    }

}
