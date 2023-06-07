package com.mibanco.ts.crearclientecdtdgital.services.impl;


import com.mibanco.ts.crearclientecdtdgital.constants.Constants;
import com.mibanco.ts.crearclientecdtdgital.gen.type.ClienteCDTDigitalType;
import com.mibanco.ts.crearclientecdtdgital.gen.type.CrearClienteCDTDigitalOutput;
import com.mibanco.ts.crearclientecdtdgital.services.contract.IClienteCdtDigitalService;
import com.mibanco.ts.crearclientecdtdgital.utils.ApplicationException;
import com.mibanco.ts.crearclientecdtdgital.utils.ClienteCDTDigitalMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class ClienteCdtDigitalServiceImpl implements IClienteCdtDigitalService {

    private static final Logger LOG = LoggerFactory.getLogger(ClienteCdtDigitalServiceImpl.class);

    @Inject
    MockCliente mockCliente;

    @Inject
    ClienteCDTDigitalMapper mapper;

    @Transactional
    @Override
    public CrearClienteCDTDigitalOutput crearClienteCDTDigital(ClienteCDTDigitalType clienteCDTDigitalType) {

        LOG.info("Inicia creación de datos crearClienteCDTDigitalSvcImpl");
        try {
            ModelMapper modelMapper = new ModelMapper();
            ClienteCDTDigitalType clienteCreado = modelMapper.map(clienteCDTDigitalType, ClienteCDTDigitalType.class);
            mockCliente.crearClienteCDTDigital(clienteCreado);
            CrearClienteCDTDigitalOutput clienteCDTDigitalOutput = mapper.clienteCDTDigitalOutputToClienteType(clienteCreado);
            LOG.info("Termina creación de datos crearClienteCDTDigitalSvcImpl");
            return clienteCDTDigitalOutput;

        } catch (Exception e) {

            LOG.error(Constants.ERROR_OUTPUT_CLIENTES + e + " en ClienteCDTDigitalSvcImpl");
            throw new ApplicationException(Response.Status.NOT_FOUND.getStatusCode(), Constants.ERROR_OUTPUT_CLIENTES);
        }
    }
}
