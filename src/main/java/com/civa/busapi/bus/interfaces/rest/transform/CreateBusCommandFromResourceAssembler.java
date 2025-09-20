package com.civa.busapi.bus.interfaces.rest.transform;

import com.civa.busapi.bus.domain.model.commands.CreateBusCommand;
import com.civa.busapi.bus.interfaces.rest.resources.CreateBusResource;

public class CreateBusCommandFromResourceAssembler {
    public static CreateBusCommand toCommandFromResource(CreateBusResource resource) {
        return new CreateBusCommand(
                resource.busNumber(),
                resource.licensePlate(),
                resource.features(),
                resource.active(),
                resource.busBrandId()
        );
    }
}
