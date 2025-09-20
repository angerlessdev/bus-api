package com.civa.busapi.bus.domain.services;

import com.civa.busapi.bus.domain.model.aggregates.Bus;
import com.civa.busapi.bus.domain.model.commands.CreateBusCommand;

import java.util.Optional;

public interface BusCommandService {
    Optional<Bus> handle(CreateBusCommand command);
}
