package com.mibanco.ts.crearclientecdtdgital.controller;

import com.mibanco.ts.crearclientecdtdgital.constants.Constants;
import com.mibanco.ts.crearclientecdtdgital.gen.contract.V1ClienteCDTDigitalTSApi;
import com.mibanco.ts.crearclientecdtdgital.gen.type.ClienteCDTDigitalType;
import com.mibanco.ts.crearclientecdtdgital.services.impl.ClienteCdtDigitalServiceImpl;
import com.mibanco.ts.crearclientecdtdgital.utils.ApplicationException;
import com.mibanco.ts.crearclientecdtdgital.utils.ClienteCDTDigitalValidator;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClienteCDTDigitalController implements V1ClienteCDTDigitalTSApi {

    private static final Logger LOG = LoggerFactory.getLogger(ClienteCDTDigitalController.class);
    @Inject
    ClienteCdtDigitalServiceImpl clienteCdtDigitalService;

    @Inject
    ClienteCDTDigitalValidator validator;

    @Override
    public Response crearClienteCDTDigital(String networkOwner, String networkRefId, String terminalId, String ipAddress, String custPermId, Integer operationCode, ClienteCDTDigitalType clienteCDTDigitalType) {

        LOG.info("Termina crearClienteCdtDigitalController");
        try {
            validator.verificarDatosClienteCdtDigital(clienteCDTDigitalType);
            // Lógica adicional según los parámetros del método

            ClienteCDTDigitalType clienteCreado = clienteCdtDigitalService.crearClienteCDTDigital(clienteCDTDigitalType);
            LOG.info("Termina crearClienteCdtDigitalController");
            return Response.status(200).entity(clienteCreado).build();
        } catch (ApplicationException e) {

            LOG.error(Constants.ERROR_SERVICIO + e.getMessage() + " CrearClienteCDTDigitalController");
            throw new ApplicationException(Response.Status.NOT_FOUND.getStatusCode(), Constants.ERROR_SERVICIO + e.getMessage() + " CrearClienteCDTDigitalController");
        }
    }


    public Response validarExistenciaClienteCDT(ClienteCDTDigitalType clienteCDTDigitalType) {
        return null;
    }
}
