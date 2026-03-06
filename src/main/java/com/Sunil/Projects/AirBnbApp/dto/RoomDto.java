package com.Sunil.Projects.AirBnbApp.dto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RoomDto {
    private Long id;
    private String roomType;
    private Integer basePrice;
    private String[] photos;
    private String[] amenities;
    private Integer totalCount;
    private Integer capacity;

}
