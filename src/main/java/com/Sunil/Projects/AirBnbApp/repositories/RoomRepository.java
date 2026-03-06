package com.Sunil.Projects.AirBnbApp.repositories;
import com.Sunil.Projects.AirBnbApp.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Long> {
}
