package com.Sunil.Projects.AirBnbApp.services;

import com.Sunil.Projects.AirBnbApp.dto.RoomDto;
import java.util.List;
public interface RoomService {
    RoomDto createNewRoom(Long hotelId ,RoomDto roomDto);
    List<RoomDto> getAllRoomINHotel(Long hotelId);
    RoomDto getRoomById(Long roomId);
    void deleteRoomById(Long roomId);

}
