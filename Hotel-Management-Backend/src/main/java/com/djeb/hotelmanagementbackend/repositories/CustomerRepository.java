package com.djeb.hotelmanagementbackend.repositories;

import com.djeb.hotelmanagementbackend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Ajoutez des méthodes spécifiques au repository de Customer si nécessaire
}
