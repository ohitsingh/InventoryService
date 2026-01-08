package com.InventoryService.InventoryService;

import com.InventoryService.InventoryService.entity.InventoryBatch;
import com.InventoryService.InventoryService.repository.InventoryRepository;
import com.InventoryService.InventoryService.service.InventoryServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class InventoryServiceApplicationTests {

	@Test
	void getInventryByExpiryDate() {

		InventoryRepository repo = mock(InventoryRepository.class);

		InventoryBatch b1 = new InventoryBatch(1L,1005L,"smartwatch",40, LocalDate.of(2026,3,31));
		InventoryBatch b2 = new InventoryBatch(2L,1005L,"smartwatch",39, LocalDate.of(2026,4,24));

		when(repo.findByProductIdOrderByExpiryDate(1005L))
				.thenReturn(Arrays.asList(b1,b2));

		InventoryServiceImpl service = new InventoryServiceImpl(repo);
		var result = service.getInventory(1005L);

		assertEquals(1005L, result.getProductId());
		assertEquals(2, result.getBatches().size());
		assertEquals(40, result.getBatches().get(0).getQuantity()); // FIXED
	}

}
