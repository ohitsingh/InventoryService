package com.InventoryService.InventoryService.service.factory;

import com.InventoryService.InventoryService.service.InventoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InventoryHandlerFactory {

    @Autowired
    private InventoryServiceImpl inventoryService;

    public ProductInventoryHandler getHandler(Long productId) {
        return inventoryService;
    }
}
