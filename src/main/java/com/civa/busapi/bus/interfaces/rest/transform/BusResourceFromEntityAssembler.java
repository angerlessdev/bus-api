package com.civa.busapi.bus.interfaces.rest.transform;

import com.civa.busapi.bus.domain.model.aggregates.Bus;
import com.civa.busapi.bus.interfaces.rest.resources.BusBrandResource;
import com.civa.busapi.bus.interfaces.rest.resources.BusResource;

public class BusResourceFromEntityAssembler {
    public static BusResource toResourceFromEntity(Bus entity) {
        return new BusResource(
                entity.getId(),
                entity.getBusNumber(),
                entity.getLicensePlate(),
                entity.getFeatures(),
                entity.getActive(),
                new BusBrandResource(entity.getBrand().getId(), entity.getBrand().getName()));
    }
}
