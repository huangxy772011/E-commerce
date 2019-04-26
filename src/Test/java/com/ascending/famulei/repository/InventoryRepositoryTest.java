package com.ascending.famulei.repository;

import com.ascending.famulei.config.AppConfig;
import com.ascending.famulei.domain.Inventory;
import com.ascending.famulei.domain.Vendor;
import jdk.nashorn.internal.runtime.options.Option;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class InventoryRepositoryTest {
    @Autowired
    private InventoryRepository inventoryRepository;

    @Test
    @Transactional
    public void findInventoryByVendorId(){
        Inventory i = new Inventory();
        i.setDepartment("Food");
//        v.setLocation("Washington D.C.");
        inventoryRepository.save(i);
        Optional<Inventory> testInventory = inventoryRepository.findById(i.getId());
        assertNotNull(testInventory);
        assertEquals(i.getId(),testInventory.get().getId());
    }
}
