package com.Sunil.Projects.AirBnbApp.services;

import com.Sunil.Projects.AirBnbApp.entities.Room;

public interface InventoryService {
    void initializeRoomForYear(Room roomId);
    void deleteAllInventories(Room room);
}
