package com.InventoryService.InventoryService.service;

import com.InventoryService.InventoryService.dto.ProductInventoryResponse;

public interface InventoryService {
    ProductInventoryResponse getInventory(Long productId);
    void updateInventory(Long productId, Integer quantity);
}
