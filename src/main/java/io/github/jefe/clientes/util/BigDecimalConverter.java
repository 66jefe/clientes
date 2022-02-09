package io.github.jefe.clientes.util;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BigDecimalConverter {

    public BigDecimal converter(String value){
        value = value.replace(".", "").replace(",", ".");
        return new BigDecimal(value);
    }

}
