package com.civa.busapi.bus.domain.model.aggregates;

import com.civa.busapi.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.Objects;

@Getter
@Entity
public class Bus extends AuditableAbstractAggregateRoot<Bus> {

    @NotBlank
    @Size(max = 50)
    private String busNumber;

    @NotBlank
    @Size(max = 20)
    private String licensePlate;

    @Size(max = 1000)
    private String features;

    @NotNull
    private Boolean active = true;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private BusBrand brand;

    public Bus() {
    }

    public Bus(String busNumber, String licensePlate, String features, Boolean active, BusBrand brand) {
        this.busNumber = busNumber;
        this.licensePlate = licensePlate;
        this.features = features;
        this.brand = Objects.requireNonNull(brand, "brand is required");
        this.active = active == null ? Boolean.TRUE : active;
    }
}
