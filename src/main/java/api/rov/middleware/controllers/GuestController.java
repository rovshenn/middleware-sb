package api.rov.middleware.controllers;

import api.rov.middleware.entity.Guest;
import api.rov.middleware.entity.Room;
import api.rov.middleware.repository.GuestRepository;
import api.rov.middleware.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guests")
public class GuestController {
    @Autowired
    private GuestRepository guestRepository;

    @GetMapping
    public Iterable<Guest> getGuests() {
        return this.guestRepository.findAll();
    }
}
