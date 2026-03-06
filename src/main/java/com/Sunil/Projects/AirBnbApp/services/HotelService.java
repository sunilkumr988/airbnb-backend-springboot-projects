package com.Sunil.Projects.AirBnbApp.services;

import com.Sunil.Projects.AirBnbApp.dto.HotelDto;
import com.Sunil.Projects.AirBnbApp.entities.Hotel;

public interface HotelService {
    HotelDto createNewHotel(HotelDto hotelDto);
    HotelDto getHotelById(Long id);
}
