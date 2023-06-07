package com.mibanco.ts.crearclientecdtdgital.utils;

import com.mibanco.ts.crearclientecdtdgital.gen.type.ClienteCDTDigitalType;
import com.mibanco.ts.crearclientecdtdgital.gen.type.CrearClienteCDTDigitalOutput;
import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class ClienteCDTDigitalMapper {

    public ClienteCDTDigitalType clienteCdtDigitalTypeToCrearClienteOutput(CrearClienteCDTDigitalOutput clienteCDTDigitalOutput) {
        return new ModelMapper().map(clienteCDTDigitalOutput, ClienteCDTDigitalType.class);
    }

    public CrearClienteCDTDigitalOutput clienteCDTDigitalOutputToClienteType(ClienteCDTDigitalType clienteCDTDigitalType) {
        return new ModelMapper().map(clienteCDTDigitalType, CrearClienteCDTDigitalOutput.class);
    }
}
