package api.rov.middleware.business.service;

import api.rov.middleware.business.domain.RoomReseravation;
import api.rov.middleware.entity.Guest;
import api.rov.middleware.entity.Reservation;
import api.rov.middleware.entity.Room;
import api.rov.middleware.repository.GuestRepository;
import api.rov.middleware.repository.ReservationRepository;
import api.rov.middleware.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ReservationService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public List<RoomReseravation> getRoomReservationForDate(Date date) {
        Iterable<Room> rooms = this.roomRepository.findAll();
        Iterable<Reservation> reservations = this.reservationRepository.findReservationByResDate(new java.sql.Date(date.getTime()));

        Map<Long, Room> roomMap = StreamSupport.stream(rooms.spliterator(), false)
                .collect(Collectors.toMap(val -> val.getRoomId(), val -> val));

        List<RoomReseravation> roomReseravations = StreamSupport.stream(reservations.spliterator(), false).map(reservation -> {
            Guest guest = this.guestRepository.findById(reservation.getGuestId()).get();
            Room room = roomMap.get(reservation.getRoomId());
            return getRoomReseravation(reservation, guest, room);
        }).collect(Collectors.toList());

        Collections.sort(roomReseravations, (o1, o2) -> {
            if(o1.getRoomName().equals(o2.getRoomName())) {
                return o1.getRoomNumber().compareTo(o2.getRoomNumber());
            }
            return o1.getRoomName().compareTo(o2.getFirstName());
        });
        return roomReseravations;
    }

    private RoomReseravation getRoomReseravation(Reservation reservation, Guest guest, Room room) {
        RoomReseravation roomReseravation = new RoomReseravation();
        roomReseravation.setRoomId(room.getRoomId());
        roomReseravation.setRoomName(room.getRoomName());
        roomReseravation.setRoomNumber(room.getRoomNumber());
        roomReseravation.setGuestId(guest.getGuestId());
        roomReseravation.setFirstName(guest.getFirstName());
        roomReseravation.setLastName(guest.getLastName());
        roomReseravation.setDate(reservation.getResDate());
        return roomReseravation;
    }
}
