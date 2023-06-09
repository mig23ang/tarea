package com.mibanco.ts.crearclientecdtdgital.services.impl;


import com.mibanco.ts.crearclientecdtdgital.constants.Constants;
import com.mibanco.ts.crearclientecdtdgital.dto.ClienteDTO;
import com.mibanco.ts.crearclientecdtdgital.dto.MockCliente;
import com.mibanco.ts.crearclientecdtdgital.gen.type.ArchivoType;
import com.mibanco.ts.crearclientecdtdgital.gen.type.ClienteCDTDigitalType;
import com.mibanco.ts.crearclientecdtdgital.services.command.business.GenerarArchivoPlanoNovedadesCmd;
import com.mibanco.ts.crearclientecdtdgital.services.command.business.ValidarInformacionClienteCDTCmd;
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
    ClienteCDTDigitalMapper clienteMapper;

    //comandos/////////////////////////////////////
    @Inject
    ValidarInformacionClienteCDTCmd validarInformacionClienteCDT;

    @Inject
    GenerarArchivoPlanoNovedadesCmd generarArchivoPlanoNovedades;
    //fin comandos ///////////////////////////////////////


    @Transactional
    @Override
    public ClienteCDTDigitalType crearClienteCDTDigital(ClienteCDTDigitalType clienteCDTDigitalType) {
        LOG.info("Inicia creación de datos crearClienteCDTDigitalSvcImpl");
        ClienteDTO clienteDTO = clienteMapper.ClienteCDTDigitalTypeToClienteDTO(clienteCDTDigitalType);
        try {
            // 1. Validar la información del cliente
            boolean clienteExiste = (boolean) validarInformacionClienteCDT.execute(clienteDTO);

            // Realiza la lógica necesaria según el resultado de la validación
            if (clienteExiste) {
                LOG.info("Error creación de datos crearClienteCDTDigitalSvcImpl");
                // 2. Generar el archivo plano de novedades **recordar que se envian los parametro necesarios para crear el archivo plano, los parametros aca enviados son un ejemplo
                ArchivoType archivoPlano = (ArchivoType) generarArchivoPlanoNovedades.execute(clienteDTO);
                throw new ApplicationException(Response.Status.EXPECTATION_FAILED.getStatusCode(), Constants.CLIENTE_YA_EXISTE);
            } else {
                ModelMapper modelMapper = new ModelMapper();
                ClienteCDTDigitalType clienteCreado = modelMapper.map(clienteCDTDigitalType, ClienteCDTDigitalType.class);
                mockCliente.crearClienteCDTDigital(clienteCreado);

                LOG.info("Termina creación de datos crearClienteCDTDigitalSvcImpl");
                return clienteCreado;
            }

        } catch (ApplicationException e) {
            LOG.error(Constants.ERROR_OUTPUT_CLIENTES + e + " en ClienteCDTDigitalSvcImpl");
            throw new ApplicationException(Response.Status.NOT_FOUND.getStatusCode(), Constants.ERROR_OUTPUT_CLIENTES);
        }
    }
}
