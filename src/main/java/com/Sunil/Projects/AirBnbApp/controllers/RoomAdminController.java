package com.Sunil.Projects.AirBnbApp.controllers;

import com.Sunil.Projects.AirBnbApp.dto.RoomDto;
import com.Sunil.Projects.AirBnbApp.services.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/hotels/{hotelId}/rooms")
@RequiredArgsConstructor
public class RoomAdminController {

    private final RoomService roomService;

    // 1️⃣ Create Room
    @PostMapping
    public ResponseEntity<RoomDto> createNewRoom(
            @PathVariable Long hotelId,
            @RequestBody RoomDto roomDto
    ){
        RoomDto room = roomService.createNewRoom(hotelId, roomDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(room);
    }

    // 2️⃣ Get All Rooms In Hotel
    @GetMapping
    public ResponseEntity<List<RoomDto>> getAllRoomsInHotel(
            @PathVariable Long hotelId
    ){
        List<RoomDto> rooms = roomService.getAllRoomINHotel(hotelId);
        return ResponseEntity.ok(rooms);
    }

    // 3️⃣ Get Room By
    @GetMapping("/{roomId}")
    public ResponseEntity<RoomDto> getRoomById(
            @PathVariable Long roomId
    ){
        RoomDto room = roomService.getRoomById(roomId);
        return ResponseEntity.ok(room);
    }

    // 4️⃣ Delete Room
    @DeleteMapping("/{roomId}")
    public ResponseEntity<Void> deleteRoom(
            @PathVariable Long roomId
    ){
        roomService.deleteRoomById(roomId);
        return ResponseEntity.noContent().build();
    }

}