package api.rov.middleware.repository;

import api.rov.middleware.entity.Reservation;
import api.rov.middleware.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
}
