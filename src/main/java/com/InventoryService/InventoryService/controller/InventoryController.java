package com.InventoryService.InventoryService.controller;

import com.InventoryService.InventoryService.dto.ProductInventoryResponse;
import com.InventoryService.InventoryService.service.factory.InventoryHandlerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryHandlerFactory factory;

    @GetMapping("/{productId}")
    public ResponseEntity<ProductInventoryResponse> getInventory(@PathVariable Long productId) {
        return ResponseEntity.ok(factory.getHandler(productId).processInventory(productId));

    }

    @PostMapping("/update")
    public ResponseEntity<String> updateInventory(@RequestParam Long productId,
                                                  @RequestParam Integer quantity) {
        factory.getHandler(productId).updateInventory(productId, quantity);
        return ResponseEntity.ok("Inventory updated");

    }
}
