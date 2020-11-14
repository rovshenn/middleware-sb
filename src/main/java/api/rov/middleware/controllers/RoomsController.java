package api.rov.middleware.controllers;

import api.rov.middleware.entity.Room;
import api.rov.middleware.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms")
public class RoomsController {
    @Autowired
    private RoomRepository roomRepository;

    @GetMapping
    public Iterable<Room> getRooms() {
        return this.roomRepository.findAll();
    }
}
