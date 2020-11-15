package api.rov.middleware.controllers;

import api.rov.middleware.business.domain.RoomReseravation;
import api.rov.middleware.business.service.ReservationService;
import api.rov.middleware.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public List<RoomReseravation> getReservations(@RequestParam(value = "date", required = false) String dateStr) {
        return this.reservationService.getRoomReservationForDate(DateUtils.createDateString(dateStr));
    }
}
