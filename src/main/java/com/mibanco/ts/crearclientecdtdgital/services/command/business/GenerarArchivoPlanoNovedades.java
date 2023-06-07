package com.mibanco.ts.crearclientecdtdgital.services.command.business;

import com.mibanco.ts.crearclientecdtdgital.constants.Constants;
import com.mibanco.ts.crearclientecdtdgital.gen.type.ArchivoType;
import com.mibanco.ts.crearclientecdtdgital.services.command.ICommand;
import com.mibanco.ts.crearclientecdtdgital.services.command.IParam;
import com.mibanco.ts.crearclientecdtdgital.utils.ApplicationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

@ApplicationScoped
public class GenerarArchivoPlanoNovedades implements ICommand {

    private static final Logger LOG = LoggerFactory.getLogger(GenerarArchivoPlanoNovedades.class);

    @Override
    public Object execute(IParam parametro) {
        LOG.info("INICIA GENERAR ARCHIVO PLANO NOVEDADES DE CLIENTECTDDIGITAL");
        try {
            // Lógica para generar el archivo plano y obtener el objeto ArchivoType
            ArchivoType archivoPlano = generarArchivoPlano();

            LOG.info("FIN GENERAR ARCHIVO PLANO NOVEDADES DE CLIENTECTDDIGITAL");
            return archivoPlano;
        } catch (ApplicationException e) {
            LOG.error(Constants.ERROR_SERVICIO + e.getMessage() + " GenerarArchivoPlanoNovedades");
            throw new ApplicationException(Response.Status.NOT_FOUND.getStatusCode(), Constants.ERROR_SERVICIO + e.getMessage() + " GenerarArchivoPlanoNovedades");
        }
    }

    private ArchivoType generarArchivoPlano() {
        // Implementa la lógica para generar el archivo plano y retorna un objeto ArchivoType
        ArchivoType archivoPlano = new ArchivoType();
        // Asigna los valores adecuados a las propiedades del objeto archivoPlano
        archivoPlano.setArchivoId("123456");
        archivoPlano.setBase64(new ArrayList<>());
        archivoPlano.setExtensionArchivo("txt");
        archivoPlano.setNombreArchivo("archivo.txt");
        archivoPlano.setUrl("https://example.com/archivos/archivo.txt");
        archivoPlano.setUrlPublica(true);

        return archivoPlano;
    }
}
