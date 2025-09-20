package com.civa.busapi.bus.domain.model.commands;

public record CreateBusCommand(
        String busNumber,
        String licensePlate,
        String features,
        Boolean active,
        Long busBrandId ) {
}
