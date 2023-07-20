package com.djeb.hotelmanagementbackend;

import com.djeb.hotelmanagementbackend.entities.*;
import com.djeb.hotelmanagementbackend.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class HotelManagementBackendApplication {

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    private final BookingRepository bookingRepository;
    private final CategoryRepository categoryRepository;
    private final StaffRepository staffRepository;
    private final CustomerRepository customerRepository;
    private final PaymentRepository paymentRepository;

    public HotelManagementBackendApplication(RoomRepository roomRepository, HotelRepository hotelRepository, BookingRepository bookingRepository, CategoryRepository categoryRepository, StaffRepository staffRepository, CustomerRepository customerRepository, PaymentRepository paymentRepository) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
        this.bookingRepository = bookingRepository;
        this.categoryRepository = categoryRepository;
        this.staffRepository = staffRepository;
        this.customerRepository = customerRepository;
        this.paymentRepository = paymentRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(HotelManagementBackendApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            // Génération des données dans la base de données

            // Création des catégories
            Category category1 = new Category(null, "Standard", 100.0);
            Category category2 = new Category(null, "Deluxe", 150.0);
            categoryRepository.saveAll(Arrays.asList(category1, category2));

            // Création des hôtels
            Hotel hotel1 = new Hotel(null, "Hotel A", "1234567890", "hotelA@example.com", "123 Rue de l'Hôtel A");
            Hotel hotel2 = new Hotel(null, "Hotel B", "9876543210", "hotelB@example.com", "456 Rue de l'Hôtel B");
            hotelRepository.saveAll(Arrays.asList(hotel1, hotel2));

            // Création des chambres
            Room room1 = new Room(null, "Chambre 1", 2, "Petit-déjeuner inclus", true, true, category1, hotel1);
            Room room2 = new Room(null, "Chambre 2", 4, "Demi-pension", true, false, category2, hotel1);
            Room room3 = new Room(null, "Chambre 3", 3, "Sans repas", false, true, category1, hotel2);
            roomRepository.saveAll(Arrays.asList(room1, room2, room3));

            // Création des réservations
            Customer customer1 = new Customer(null, "John", "Doe", "john@example.com", "password", "1234567890", "California", "12345", "123 Street");
            Customer customer2 = new Customer(null, "Jane", "Smith", "jane@example.com", "password", "9876543210", "New York", "67890", "456 Avenue");
            customerRepository.saveAll(Arrays.asList(customer1, customer2));

            Booking booking1 = new Booking(null, 20230719, 20230722, 3, 20230715, "Paid", customer1, room1);
            Booking booking2 = new Booking(null, 20230720, 20230725, 5, 20230718, "Pending", customer2, room2);
            bookingRepository.saveAll(Arrays.asList(booking1, booking2));

            // Création du personnel
            Staff staff1 = new Staff(null, hotel1, "John", "Doe", "john@example.com", "password", "1234567890");
            Staff staff2 = new Staff(null, hotel2, "Jane", "Smith", "jane@example.com", "password", "9876543210");
            staffRepository.saveAll(Arrays.asList(staff1, staff2));

            // Création des paiements
            Payment payment1 = new Payment(null, customer1, "John", "Doe", booking1, "1234567812345678");
            Payment payment2 = new Payment(null, customer2, "Jane", "Smith", booking2, "9876543298765432");
            paymentRepository.saveAll(Arrays.asList(payment1, payment2));
        };
    }
}