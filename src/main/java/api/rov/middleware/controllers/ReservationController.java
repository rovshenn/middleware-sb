package api.rov.middleware.controllers;

import api.rov.middleware.entity.Reservation;
import api.rov.middleware.entity.Room;
import api.rov.middleware.repository.ReservationRepository;
import api.rov.middleware.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping
    public Iterable<Reservation> getReservations() {
        return this.reservationRepository.findAll();
    }
}
