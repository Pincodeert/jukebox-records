package nl.pin.jukeboxInventory.repositories;

import nl.pin.jukeboxInventory.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

}
