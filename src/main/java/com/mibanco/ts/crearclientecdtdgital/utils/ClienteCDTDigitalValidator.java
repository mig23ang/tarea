package com.mibanco.ts.crearclientecdtdgital.utils;

import com.mibanco.ts.crearclientecdtdgital.constants.Constants;
import com.mibanco.ts.crearclientecdtdgital.gen.type.ClienteCDTDigitalType;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class ClienteCDTDigitalValidator {


    public Response verificarDatosClienteCdtDigital(ClienteCDTDigitalType clienteCDTDigitalType)
            throws ApplicationException {

        if (clienteCDTDigitalType.getTelefonoPrincipal() == null) {
            throw new ApplicationException(
                    Response.Status.BAD_REQUEST.getStatusCode(),
                    Constants.ERROR_VALIDACION + "Telefono principal no puede estar vacío");
        }

        if (clienteCDTDigitalType.getClienteBase().getNumeroCliente() == null) {
            throw new ApplicationException(
                    Response.Status.BAD_REQUEST.getStatusCode(),
                    Constants.ERROR_VALIDACION + "Número cliente no puede estar vacío");
        }

        if (clienteCDTDigitalType.getClienteBase().getTipoPersona() == null) {
            throw new ApplicationException(
                    Response.Status.BAD_REQUEST.getStatusCode(),
                    Constants.ERROR_VALIDACION + "Tipo persona no puede estar vacío");
        }

        if (clienteCDTDigitalType.getClienteBase().getNumeroDocumento() == null) {
            throw new ApplicationException(
                    Response.Status.BAD_REQUEST.getStatusCode(),
                    Constants.ERROR_VALIDACION + "Número de documento no puede estar vacío");
        }

        if (clienteCDTDigitalType.getClienteBase().getFechaExpedicionDocumento() == null) {
            throw new ApplicationException(
                    Response.Status.BAD_REQUEST.getStatusCode(),
                    Constants.ERROR_VALIDACION + "Fecha expedición de documento no puede estar vacío");
        }

        if (clienteCDTDigitalType.getClienteBase().getPrimerNombre() == null || clienteCDTDigitalType.getClienteBase().getPrimerNombre().isEmpty()) {
            throw new ApplicationException(
                    Response.Status.BAD_REQUEST.getStatusCode(),
                    Constants.ERROR_VALIDACION + "Primer nombre no puede estar vacío");
        }

        if (clienteCDTDigitalType.getClienteBase().getNumeroCelular() == null) {
            throw new ApplicationException(
                    Response.Status.BAD_REQUEST.getStatusCode(),
                    Constants.ERROR_VALIDACION + "Número celular no puede estar vacío");
        }

        if (clienteCDTDigitalType.getClienteBase().getSegundoNombre() == null || clienteCDTDigitalType.getClienteBase().getSegundoNombre().isEmpty()) {
            throw new ApplicationException(
                    Response.Status.BAD_REQUEST.getStatusCode(),
                    Constants.ERROR_VALIDACION + "Segundo nombre no puede estar vacío");
        }

        if (clienteCDTDigitalType.getClienteBase().getPrimerApellido() == null || clienteCDTDigitalType.getClienteBase().getPrimerApellido().isEmpty()) {
            throw new ApplicationException(
                    Response.Status.BAD_REQUEST.getStatusCode(),
                    Constants.ERROR_VALIDACION + "Primer apellido no puede estar vacío");
        }

        if (clienteCDTDigitalType.getClienteBase().getSegundoApellido() == null || clienteCDTDigitalType.getClienteBase().getSegundoApellido().isEmpty()) {
            throw new ApplicationException(
                    Response.Status.BAD_REQUEST.getStatusCode(),
                    Constants.ERROR_VALIDACION + "Segundo apellido no puede estar vacío");
        }

        if (clienteCDTDigitalType.getClienteBase().getCorreoElectronico() == null || clienteCDTDigitalType.getClienteBase().getCorreoElectronico().isEmpty()) {
            throw new ApplicationException(
                    Response.Status.BAD_REQUEST.getStatusCode(),
                    Constants.ERROR_VALIDACION + "Correo Electronico no puede estar vacío");
        }

        return Response.ok().build();
    }
}
