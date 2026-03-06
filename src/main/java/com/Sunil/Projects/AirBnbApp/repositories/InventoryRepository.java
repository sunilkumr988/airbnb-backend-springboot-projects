package com.Sunil.Projects.AirBnbApp.repositories;

import com.Sunil.Projects.AirBnbApp.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {
}
