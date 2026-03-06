package com.Sunil.Projects.AirBnbApp.controllers;

import com.Sunil.Projects.AirBnbApp.dto.HotelDto;
import com.Sunil.Projects.AirBnbApp.services.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/hotels")
@RequiredArgsConstructor
@Slf4j
public class HotelController {
    private final HotelService hotelService;
    @PostMapping
    public ResponseEntity<HotelDto> createNewHotel(@RequestBody HotelDto hotelDto){
        HotelDto hotel=hotelService.createNewHotel(hotelDto);
        return new ResponseEntity<>(hotel, HttpStatus.CREATED);
    }
    @GetMapping("/{hotelId}")
    public ResponseEntity<HotelDto> getHotelById(@PathVariable Long hotelId){
        HotelDto hotelDto=hotelService.getHotelById(hotelId);
        return ResponseEntity.ok(hotelDto);
    }

}
