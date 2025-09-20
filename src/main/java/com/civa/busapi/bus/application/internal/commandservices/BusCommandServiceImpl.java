package com.civa.busapi.bus.application.internal.commandservices;

import com.civa.busapi.bus.domain.model.aggregates.Bus;
import com.civa.busapi.bus.domain.model.commands.CreateBusCommand;
import com.civa.busapi.bus.domain.services.BusCommandService;
import com.civa.busapi.bus.infrastructure.persistence.jpa.repositories.BusBrandRepository;
import com.civa.busapi.bus.infrastructure.persistence.jpa.repositories.BusRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BusCommandServiceImpl implements BusCommandService {
    private final BusRepository busRepository;
    private final BusBrandRepository busBrandRepository;

    public BusCommandServiceImpl(BusRepository busRepository, BusBrandRepository busBrandRepository) {
        this.busRepository = busRepository;
        this.busBrandRepository = busBrandRepository;
    }

    @Override
    public Optional<Bus> handle(CreateBusCommand command) {
        var brand = busBrandRepository.findById(command.busBrandId())
                .orElseThrow(() -> new IllegalArgumentException("BusBrand not found"));

        var bus = new Bus(
                command.busNumber(),
                command.licensePlate(),
                command.features(),
                command.active(),
                brand
        );

        var createdBus = busRepository.save(bus);
        return Optional.of(createdBus);

    }
}
