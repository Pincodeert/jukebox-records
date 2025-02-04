package nl.pin.jukeboxInventory.repositories;

import nl.pin.jukeboxInventory.models.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<Track, Long> {

}
