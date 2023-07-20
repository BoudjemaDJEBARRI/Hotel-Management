package com.djeb.hotelmanagementbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Booking")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer checkIn;

    private Integer checkOut;

    @Column(name = "number_of_night")
    private Integer numberOfNight;

    @Column(name = "booking_date")
    private Integer bookingDate;

    @Column(name = "payment_status", length = 60)
    private String paymentStatus;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}