package com.mibanco.ts.crearclientecdtdgital.services.contract;

import com.mibanco.ts.crearclientecdtdgital.gen.type.ClienteCDTDigitalType;
import com.mibanco.ts.crearclientecdtdgital.gen.type.CrearClienteCDTDigitalOutput;

public interface IClienteCdtDigitalService {

    CrearClienteCDTDigitalOutput crearClienteCDTDigital(ClienteCDTDigitalType clienteCDTDigitalType);
}
