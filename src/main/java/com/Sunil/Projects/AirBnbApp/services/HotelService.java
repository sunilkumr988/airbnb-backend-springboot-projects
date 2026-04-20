package com.Sunil.Projects.AirBnbApp.services;

import com.Sunil.Projects.AirBnbApp.dto.HotelDto;
import com.Sunil.Projects.AirBnbApp.entities.Hotel;

import java.util.List;

public interface HotelService {
    HotelDto createNewHotel(HotelDto hotelDto);
    HotelDto getHotelById(Long id);
    HotelDto updateHotelById(Long id ,HotelDto hotelDto);
    void deleteHotelById(Long id);
    void activateHotel(Long hotelId);

    List<Hotel> getAllHotels();
}
