package com.djeb.hotelmanagementbackend.repositories;

import com.djeb.hotelmanagementbackend.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Ajoutez des méthodes spécifiques au repository de Category si nécessaire
}
