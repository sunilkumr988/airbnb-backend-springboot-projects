package com.Sunil.Projects.AirBnbApp.services;

import com.Sunil.Projects.AirBnbApp.dto.RoomDto;
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
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
@Slf4j
public class RoomServiceImpl implements RoomService{
    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    private final InventoryService inventoryService;
    private final ModelMapper modelMapper;
    @Override
    public RoomDto createNewRoom(Long hotelId ,RoomDto roomDto) {
        log.info("Creating A New Room In Hotel With Id: {}",hotelId);
        Hotel hotel=hotelRepository.findById(hotelId)
                .orElseThrow(()-> new ResourceNotFoundException("Hotel Not Found With Id: "+hotelId));
       Room room=modelMapper.map(roomDto,Room.class);
        room.setHotel(hotel);
        room=roomRepository.save(room);
        //TODO create inventory as soon as room is created adn if hotel is active
        if (hotel.getActive()) {
            inventoryService.initializeRoomForYear(room);
        }

        return modelMapper.map(room, RoomDto.class);
    }


    @Transactional
    @Override
    public List<RoomDto> getAllRoomINHotel(Long hotelId) {
        log.info("Get All The Rooms In Hotel With Id: {}", hotelId);
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel Not Found With Id: " + hotelId));
        return hotel.getRooms().stream()
                .map(element -> modelMapper.map(element, RoomDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public RoomDto getRoomById(Long roomId) {
        log.info("Get All The Rooms  With Id: {}",roomId);
        Room room=roomRepository.findById(roomId)
                .orElseThrow(()-> new ResourceNotFoundException("Room Not Found With Id: "+roomId));
        return modelMapper.map(room,RoomDto.class);
    }

    @org.springframework.transaction.annotation.Transactional
    @Override
    public void deleteRoomById(Long roomId) {
        log.info("Deleting the room with ID: {}", roomId);
        Room room = roomRepository
                .findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found with ID: "+roomId));
        inventoryService.deleteFutureInventories(room);
        roomRepository.deleteById(roomId);
    }
}
