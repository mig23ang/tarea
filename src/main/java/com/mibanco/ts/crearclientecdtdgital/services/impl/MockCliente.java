package com.mibanco.ts.crearclientecdtdgital.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mibanco.ts.crearclientecdtdgital.gen.type.ClienteCDTDigitalType;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class MockCliente {
    private static final Logger LOG = LoggerFactory.getLogger(MockCliente.class);

    List<ClienteCDTDigitalType> lista=new ArrayList<>();
    private final ObjectMapper objectMapper;

    @Inject
    public MockCliente(ObjectMapper objectMapper) throws IOException {
        this.objectMapper = objectMapper;
        loadCrearClienteCDTDigital();
    }

    public void loadCrearClienteCDTDigital() throws IOException {
        String jsonString = new String(Files.readAllBytes(Paths.get("src/main/resources/ts-CrearClienteCdtDigital-api.json")), StandardCharsets.UTF_8);
        lista.add(objectMapper.readValue(jsonString, ClienteCDTDigitalType.class));
    }

    public void crearClienteCDTDigital(ClienteCDTDigitalType clienteCDTDigitalType) {
        lista.add(clienteCDTDigitalType);
    }

    public List<ClienteCDTDigitalType> listAll() {
        return lista;
    }

    public boolean validarCLiente(ClienteCDTDigitalType clienteCDTDigitalEntity) {
        return lista.stream().filter(p -> p.getClienteBase().getNumeroDocumento().equals(clienteCDTDigitalEntity.getClienteBase().getNumeroDocumento()) ).count() > 0;
    }


}
