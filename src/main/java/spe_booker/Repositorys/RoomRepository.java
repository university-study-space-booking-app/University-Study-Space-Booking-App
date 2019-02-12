package spe_booker.Repositorys;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import spe_booker.models.Room;

public interface RoomRepository extends CrudRepository<Room, Long> {
    List<Room> findByRoomNo(String RoomNo);
    List<Room> findAll();
}