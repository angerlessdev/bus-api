package com.civa.busapi.bus.domain.model.aggregates;

import com.civa.busapi.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class BusBrand extends AuditableAbstractAggregateRoot<BusBrand> {

    @NotBlank
    @Size(max = 100)
    private String name;

    public BusBrand(String name) {
        this.name = name;
    }
}
