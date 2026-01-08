package com.InventoryService.InventoryService.service;

import com.InventoryService.InventoryService.dto.InventoryBatchDTO;
import com.InventoryService.InventoryService.dto.ProductInventoryResponse;
import com.InventoryService.InventoryService.entity.InventoryBatch;
import com.InventoryService.InventoryService.repository.InventoryRepository;
import com.InventoryService.InventoryService.service.factory.ProductInventoryHandler;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryServiceImpl implements InventoryService, ProductInventoryHandler {
    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Autowired
    private InventoryRepository inventoryRepository;
    @Override
    public ProductInventoryResponse getInventory(Long productId) {

        List<InventoryBatch> batches = inventoryRepository.findByProductIdOrderByExpiryDate(productId);

        if (batches.isEmpty()) {
            return null;
        }

        String productName = batches.get(0).getProductName();

        List<InventoryBatchDTO> dtoList = batches.stream()
                .map(b -> new InventoryBatchDTO(b.getBatchId(), b.getQuantity(), b.getExpiryDate()))
                .collect(Collectors.toList()); // <InventoryBatch, InventoryBatchDTO>
        return new ProductInventoryResponse(productId, productName, dtoList);
    }

    @Transactional
    @Override
    public void updateInventory(Long productId, Integer orderedqQty) {

        List<InventoryBatch> batches = inventoryRepository.findByProductIdOrderByExpiryDate(productId);
        for (InventoryBatch batch : batches) {
            if (orderedqQty <= 0) {
                break;
            }
            int available = batch.getQuantity();
            if (available > 0){
                int used = Math.min(available, orderedqQty);
                batch.setQuantity(available - used);
                orderedqQty -= used;
                inventoryRepository.save(batch);
            }
        }

    }

    @Override
    public ProductInventoryResponse processInventory(Long productId) {
        return getInventory(productId);
    }
}
