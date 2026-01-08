package com.InventoryService.InventoryService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInventoryResponse {
    private Long productId;
    private String productName;
    private List<InventoryBatchDTO> batches;
}
