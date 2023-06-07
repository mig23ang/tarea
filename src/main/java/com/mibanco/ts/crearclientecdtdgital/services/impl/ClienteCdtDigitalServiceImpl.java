package com.mibanco.ts.crearclientecdtdgital.services.impl;


import com.mibanco.ts.crearclientecdtdgital.constants.Constants;
import com.mibanco.ts.crearclientecdtdgital.gen.type.ClienteCDTDigitalType;
import com.mibanco.ts.crearclientecdtdgital.services.command.business.GenerarArchivoPlanoNovedades;
import com.mibanco.ts.crearclientecdtdgital.services.command.business.ValidarInformacionClienteCDT;
import com.mibanco.ts.crearclientecdtdgital.services.contract.IClienteCdtDigitalService;
import com.mibanco.ts.crearclientecdtdgital.utils.ApplicationException;
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
    ValidarInformacionClienteCDT validarInformacionClienteCDT;

    @Inject
    GenerarArchivoPlanoNovedades generarArchivoPlanoNovedades;


    @Transactional
    @Override
    public ClienteCDTDigitalType crearClienteCDTDigital(ClienteCDTDigitalType clienteCDTDigitalType) {

        LOG.info("Inicia creación de datos crearClienteCDTDigitalSvcImpl");
        try {
            ModelMapper modelMapper = new ModelMapper();
            ClienteCDTDigitalType clienteCreado = modelMapper.map(clienteCDTDigitalType, ClienteCDTDigitalType.class);
            mockCliente.crearClienteCDTDigital(clienteCreado);

            LOG.info("Termina creación de datos crearClienteCDTDigitalSvcImpl");
            return clienteCreado;

        } catch (Exception e) {

            LOG.error(Constants.ERROR_OUTPUT_CLIENTES + e + " en ClienteCDTDigitalSvcImpl");
            throw new ApplicationException(Response.Status.NOT_FOUND.getStatusCode(), Constants.ERROR_OUTPUT_CLIENTES);
        }
    }
}
