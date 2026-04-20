package com.Sunil.Projects.AirBnbApp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.ScrollableResults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    @Column(nullable = false)
    private String roomType;

    @Column(nullable = false)
    private Integer basePrice;

    // ✅ FIXED photos
    @ElementCollection
    @CollectionTable(
            name = "room_photos",
            joinColumns = @JoinColumn(name = "room_id")
    )
    @Column(name = "photo_url")
    private List<String> photos;

    // ✅ FIXED amenities
    @ElementCollection
    @CollectionTable(
            name = "room_amenities",
            joinColumns = @JoinColumn(name = "room_id")
    )
    @Column(name = "amenity")
    private List<String> amenities;

    @Column(nullable = false)
    private Integer totalCount;

    @Column(nullable = false)
    private Integer capacity;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}