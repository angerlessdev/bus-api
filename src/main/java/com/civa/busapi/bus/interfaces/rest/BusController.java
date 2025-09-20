package com.civa.busapi.bus.interfaces.rest;

import com.civa.busapi.bus.domain.model.aggregates.Bus;
import com.civa.busapi.bus.domain.model.queries.GetAllBusesQuery;
import com.civa.busapi.bus.domain.model.queries.GetBusQuery;
import com.civa.busapi.bus.domain.services.BusCommandService;
import com.civa.busapi.bus.domain.services.BusQueryService;
import com.civa.busapi.bus.interfaces.rest.resources.BusResource;
import com.civa.busapi.bus.interfaces.rest.resources.CreateBusResource;
import com.civa.busapi.bus.interfaces.rest.resources.PagedBusResponse;
import com.civa.busapi.bus.interfaces.rest.transform.BusResourceFromEntityAssembler;
import com.civa.busapi.bus.interfaces.rest.transform.CreateBusCommandFromResourceAssembler;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/bus")
public class BusController {
    private final BusCommandService busCommandService;
    private final BusQueryService busQueryService;

    public BusController(BusCommandService busCommandService, BusQueryService busQueryService) {
        this.busCommandService = busCommandService;
        this.busQueryService = busQueryService;
    }

    @PostMapping
    public ResponseEntity<BusResource> createBus(@RequestBody CreateBusResource resource) {
        Optional<Bus> busResource = busCommandService.handle(CreateBusCommandFromResourceAssembler
                .toCommandFromResource(resource));

        return busResource.map(bus -> ResponseEntity.status(CREATED)
                .body(BusResourceFromEntityAssembler.toResourceFromEntity(bus)))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping
    public ResponseEntity<PagedBusResponse> getAllBuses(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        var pageable = PageRequest.of(page, size);
        var getAllBusesQuery = new GetAllBusesQuery();
        var busPage = busQueryService.handle(getAllBusesQuery, pageable);

        var busResources = busPage.getContent()
                .stream()
                .map(BusResourceFromEntityAssembler::toResourceFromEntity)
                .toList();

        var response = new PagedBusResponse(
                busResources,
                busPage.getNumber(),
                busPage.getTotalElements(),
                busPage.getTotalPages()
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{busId}")
    public ResponseEntity<BusResource> getBusById(@PathVariable Long busId) {
        var getBusByIdQuery = new GetBusQuery(busId);
        var bus = busQueryService.handle(getBusByIdQuery);
        if (bus.isEmpty()) return ResponseEntity.notFound().build();
        var busResource = BusResourceFromEntityAssembler.toResourceFromEntity(bus.get());
        return ResponseEntity.ok(busResource);
    }
}