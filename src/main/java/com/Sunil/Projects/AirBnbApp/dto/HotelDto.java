package com.Sunil.Projects.AirBnbApp.dto;
import com.Sunil.Projects.AirBnbApp.entities.HotelContactInfo;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class HotelDto {
    private Long id;
    private String name;
    private String city;
    private String[] photos;
    private String[] amenities;
    private HotelContactInfo hotelContactInfo;
    private Boolean active;
}
