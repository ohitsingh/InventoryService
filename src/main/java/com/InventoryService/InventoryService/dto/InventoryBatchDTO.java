package com.InventoryService.InventoryService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryBatchDTO {
    private Long batchId;
    private Integer quantity;
    private LocalDate expiryDate;
}
