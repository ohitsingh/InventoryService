package com.InventoryService.InventoryService;

import com.InventoryService.InventoryService.service.InventoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class InventoryIntegrationTest {
    @Autowired
    private InventoryService inventoryService;

    @Test
    void testInventoryLoadsFromH2() {
        var response = inventoryService.getInventory(1001L);

        assertNotNull(response);
        assertEquals(1001L, response.getProductId());
        assertTrue(response.getBatches().size() > 0);
    }
}
