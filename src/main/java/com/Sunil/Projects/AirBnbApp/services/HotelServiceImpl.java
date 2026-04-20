package com.Sunil.Projects.AirBnbApp.services;
import com.Sunil.Projects.AirBnbApp.dto.HotelDto;
import com.Sunil.Projects.AirBnbApp.entities.Hotel;
import com.Sunil.Projects.AirBnbApp.entities.Room;
import com.Sunil.Projects.AirBnbApp.exception.ResourceNotFoundException;
import com.Sunil.Projects.AirBnbApp.repositories.HotelRepository;
import com.Sunil.Projects.AirBnbApp.repositories.RoomRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;
    private final InventoryService inventoryService;
    private final RoomRepository roomRepository;
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

    @Override
    public HotelDto updateHotelById(Long id, HotelDto hotelDto) {
        log.info("updating hotel with id :{}",id);
        Hotel hotel=hotelRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("hotel not found with id "+id));
         modelMapper.map(hotelDto,hotel);
         hotel.setId(id);
         hotel=hotelRepository.save(hotel);
         return modelMapper.map(hotel,HotelDto.class);

    }

    @Override
    @Transactional
    public void deleteHotelById(Long id) {
        Hotel hotel = hotelRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with ID: "+id));
        hotelRepository.deleteById(id);
        for(Room room: hotel.getRooms()) {
            inventoryService.deleteAllInventories(room);
            roomRepository.deleteById(room.getId());
        }
        hotelRepository.deleteById(id);
    }


    @Override
    @Transactional
    public void activateHotel(Long hotelId) {
        log.info("Activating the hotel with ID: {}", hotelId);
        Hotel hotel = hotelRepository
                .findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with ID: "+hotelId));
        hotel.setActive(true);
        // assuming only do it once
        for(Room room: hotel.getRooms()) {
            inventoryService.initializeRoomForYear(room);
        }

}

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
}
