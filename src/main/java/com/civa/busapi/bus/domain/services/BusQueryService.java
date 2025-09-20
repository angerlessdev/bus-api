package com.civa.busapi.bus.domain.services;

import com.civa.busapi.bus.domain.model.aggregates.Bus;
import com.civa.busapi.bus.domain.model.queries.GetAllBusesQuery;
import com.civa.busapi.bus.domain.model.queries.GetBusQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BusQueryService {
    Optional<Bus> handle(GetBusQuery query);
    Page<Bus> handle(GetAllBusesQuery query, Pageable pageable);
}
