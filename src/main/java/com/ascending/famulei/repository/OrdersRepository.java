package com.ascending.famulei.repository;

import com.ascending.famulei.domain.Customer;
import com.ascending.famulei.domain.Inventory;
import com.ascending.famulei.domain.Orders;
import com.ascending.famulei.domain.Vendor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OrdersRepository extends CrudRepository<Orders, Long> {
    List<Orders> findAll();

    @Query("select o FROM Orders o LEFT JOIN Fetch o.customer where o.customer.id=?1")
    Optional<Customer> findOrdersByCustomerId(Long id);
}
