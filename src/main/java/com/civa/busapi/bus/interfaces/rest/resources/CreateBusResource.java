package com.civa.busapi.bus.interfaces.rest.resources;

public record CreateBusResource(
        String busNumber,
        String licensePlate,
        String features,
        Boolean active,
        Long busBrandId) {
}
