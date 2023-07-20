package com.djeb.hotelmanagementbackend.repositories;

import com.djeb.hotelmanagementbackend.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    // Ajoutez des méthodes spécifiques au repository de Hotel si nécessaire
}
