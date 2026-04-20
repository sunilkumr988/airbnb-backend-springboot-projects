package com.Sunil.Projects.AirBnbApp.repositories;

import com.Sunil.Projects.AirBnbApp.entities.Inventory;
import com.Sunil.Projects.AirBnbApp.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    void deleteByRoom(Room room);
}
