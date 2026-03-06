package com.Sunil.Projects.AirBnbApp.services;

import com.Sunil.Projects.AirBnbApp.dto.HotelDto;
import com.Sunil.Projects.AirBnbApp.entities.Hotel;
import com.Sunil.Projects.AirBnbApp.exception.ResourceNotFoundException;
import com.Sunil.Projects.AirBnbApp.repositories.HotelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;
    @Override
    public HotelDto createNewHotel(HotelDto hotelDto) {
        log.info("Creating a new hotel with name :{}",hotelDto.getName());
        Hotel hotel=modelMapper.map(hotelDto ,Hotel.class);
        hotel.setActive(false);
        hotel=hotelRepository.save(hotel);
        log.info("Creating a new hotel with id :{}",hotelDto.getId());
        return modelMapper.map(hotel,HotelDto.class);
    }

    @Override
    public HotelDto getHotelById(Long id) {
        log.info("getting hotel with id :{}",id);
        Hotel hotel=hotelRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("hotel not found with id "+id));

        return modelMapper.map(hotel,HotelDto.class);
    }
}
