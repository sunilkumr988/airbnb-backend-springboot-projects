package com.Sunil.Projects.AirBnbApp.dto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class RoomDto {

    private Long id;
    private String roomType;
    private Integer basePrice;

    // ✅ FIXED
    private List<String> photos;
    private List<String> amenities;

    private Integer totalCount;
    private Integer capacity;
}
