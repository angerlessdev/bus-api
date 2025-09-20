package com.civa.busapi.bus.application.internal.queryservices;

import com.civa.busapi.bus.domain.model.aggregates.Bus;
import com.civa.busapi.bus.domain.model.queries.GetAllBusesQuery;
import com.civa.busapi.bus.domain.model.queries.GetBusQuery;
import com.civa.busapi.bus.domain.services.BusQueryService;
import com.civa.busapi.bus.infrastructure.persistence.jpa.repositories.BusRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BusQueryServiceImpl implements BusQueryService {
    private final BusRepository busRepository;

    public BusQueryServiceImpl(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    @Override
    public Optional<Bus> handle(GetBusQuery query) {
        return busRepository.findById(query.busId());
    }

    @Override
    public Page<Bus> handle(GetAllBusesQuery query, Pageable pageable) {
        return busRepository.findAll(pageable);
    }
}
