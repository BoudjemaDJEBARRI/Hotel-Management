package com.djeb.hotelmanagementbackend.repositories;

import com.djeb.hotelmanagementbackend.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    // Ajoutez des méthodes spécifiques au repository de Booking si nécessaire
}
