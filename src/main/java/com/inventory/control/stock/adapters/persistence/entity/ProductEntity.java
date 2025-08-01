package com.inventory.control.stock.adapters.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    private UUID id;

    @NotBlank @Size(max = 100)
    private String name;

    @NotBlank @Size(max = 255)
    private String description;

    @NotNull
    private BigDecimal unitPrice;

    @NotNull @Min(0)
    private Integer currentStock;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;
}