package com.civa.busapi.bus.interfaces.rest.resources;

public record BusResource(
        Long id,
        String busNumber,
        String licensePlate,
        String features,
        Boolean active,
        Long busBrandId) {
}
