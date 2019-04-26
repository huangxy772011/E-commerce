package com.ascending.famulei.repository;

import com.ascending.famulei.domain.Inventory;
import com.ascending.famulei.domain.Vendor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface InventoryRepository extends CrudRepository<Inventory, Long> {
    List<Inventory> findAll();

    @Query("select i FROM Inventory i LEFT JOIN Fetch i.vendor where i.vendor.id=?1")
    Optional<Vendor> findInventoryByVendorId(Long id);
}