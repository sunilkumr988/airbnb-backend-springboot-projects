package com.Sunil.Projects.AirBnbApp.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String city;

    // 🔥 Photos Collection
    @ElementCollection
    @CollectionTable(
            name = "hotel_photos",
            joinColumns = @JoinColumn(name = "hotel_id")
    )
    @Column(name = "photo_url")
    private List<String> photos;

    // 🔥 Amenities Collection
    @ElementCollection
    @CollectionTable(
            name = "hotel_amenities",
            joinColumns = @JoinColumn(name = "hotel_id")
    )
    @Column(name = "amenity")
    private List<String> amenities;

    // 🔥 Auto timestamps
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    // 🔥 Embedded object
    @Embedded
    private HotelContactInfo hotelContactInfo;

    @Column(nullable = false)
    private Boolean active;

    // 🔥 Owner Mapping
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")   // IMPORTANT
    private User owner;

    // 🔥 Rooms Mapping (Most Important Fix)
    @OneToMany(
            mappedBy = "hotel",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Room> rooms;
}