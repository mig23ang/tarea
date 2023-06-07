package com.mibanco.ts.crearclientecdtdgital.services.command.business;

import com.mibanco.ts.crearclientecdtdgital.gen.type.ClienteCDTDigitalType;
import com.mibanco.ts.crearclientecdtdgital.services.command.ICommand;
import com.mibanco.ts.crearclientecdtdgital.services.command.IParam;
import com.mibanco.ts.crearclientecdtdgital.constants.Constants;
import com.mibanco.ts.crearclientecdtdgital.services.impl.MockCliente;
import com.mibanco.ts.crearclientecdtdgital.utils.ApplicationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class ValidarInformacionClienteCDT implements ICommand {

    private static final Logger LOG = LoggerFactory.getLogger(ValidarInformacionClienteCDT.class);

    @Inject
    MockCliente mockCliente;

    @Override
    public Object execute(IParam parametro) {
        LOG.info("INICIA EXISTENCIA DE CLIENTECTDDIGITAL");
        try {
            // Obtener el objeto ClienteCDTDigitalType del parámetro
            ClienteCDTDigitalType clienteCDTDigitalType = (ClienteCDTDigitalType) parametro;

            // Lógica para verificar la existencia del cliente
            boolean clienteExiste = verificarExistenciaCliente(clienteCDTDigitalType);

            LOG.info("TERMINA EXISTENCIA DE CLIENTECTDDIGITAL");
            return clienteExiste;
        } catch (ApplicationException e) {
            LOG.error(Constants.ERROR_SERVICIO + e.getMessage() + " validarInformacionClienteCDT");
            throw new ApplicationException(Response.Status.NOT_FOUND.getStatusCode(), Constants.ERROR_SERVICIO + e.getMessage() + " validarInformacionClienteCDT");
        }
    }

    private boolean verificarExistenciaCliente(ClienteCDTDigitalType clienteCDTDigitalType) {
        // Utiliza el método validarCliente del MockCliente para verificar la existencia del cliente
        return mockCliente.validarCLiente(clienteCDTDigitalType);
    }
}
