package com.civa.busapi.bus.domain.services;

import com.civa.busapi.bus.domain.model.aggregates.Bus;
import com.civa.busapi.bus.domain.model.queries.GetAllBusesQuery;
import com.civa.busapi.bus.domain.model.queries.GetBusQuery;

import java.util.List;
import java.util.Optional;

public interface BusQueryService {
    Optional<Bus> handle(GetBusQuery query);
    List<Bus> handle(GetAllBusesQuery query);
}
