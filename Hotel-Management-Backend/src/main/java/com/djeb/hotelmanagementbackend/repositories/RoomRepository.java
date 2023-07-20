package com.djeb.hotelmanagementbackend.repositories;

import com.djeb.hotelmanagementbackend.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    // Ajoutez des méthodes spécifiques au repository de Room si nécessaire
}
