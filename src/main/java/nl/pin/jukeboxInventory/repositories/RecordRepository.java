package nl.pin.jukeboxInventory.repositories;

import nl.pin.jukeboxInventory.models.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Long> {

}
