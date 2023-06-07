package com.mibanco.ts.crearclientecdtdgital.gen.contract;

import com.mibanco.ts.crearclientecdtdgital.gen.type.ClienteCDTDigitalType;
import com.mibanco.ts.crearclientecdtdgital.gen.type.CrearClienteCDTDigitalOutput;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;



import java.io.InputStream;
import java.util.Map;
import java.util.List;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

@Path("/v1/es/clienteCDT")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-06-07T11:53:35.555376200-05:00[America/Bogota]")
public interface V1ClienteCDTDigitalTSApi {

    @POST
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response crearClienteCDTDigital(@HeaderParam("networkOwner") @NotNull   String networkOwner,@HeaderParam("networkRefId") @NotNull   String networkRefId,@HeaderParam("terminalId") @NotNull   String terminalId,@HeaderParam("ipAddress") @NotNull   String ipAddress,@HeaderParam("custPermId") @NotNull   String custPermId,@HeaderParam("operationCode") @NotNull   Integer operationCode,@Valid ClienteCDTDigitalType clienteCDTDigitalType);

    @POST
    @Path("/validaExistencia")
    @Consumes({ "application/json" })
    Response validarExistenciaClienteCDT(@Valid ClienteCDTDigitalType clienteCDTDigitalType);
}
