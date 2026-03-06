package com.Sunil.Projects.AirBnbApp.repositories;

import com.Sunil.Projects.AirBnbApp.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,Long> {
}
