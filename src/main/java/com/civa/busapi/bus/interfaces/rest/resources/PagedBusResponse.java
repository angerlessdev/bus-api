package com.civa.busapi.bus.interfaces.rest.resources;

import java.util.List;

public record PagedBusResponse(
        List<BusResource> content,
        int currentPage,
        long totalItems,
        int totalPages
) {}
