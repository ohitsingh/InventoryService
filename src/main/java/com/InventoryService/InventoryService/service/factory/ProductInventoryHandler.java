package com.InventoryService.InventoryService.service.factory;

import com.InventoryService.InventoryService.dto.ProductInventoryResponse;

public interface ProductInventoryHandler {
    ProductInventoryResponse processInventory(Long productId);

    void updateInventory(Long productId, Integer quantity);
}
