package nl.pin.jukeboxInventory.services;

import nl.pin.jukeboxInventory.exceptions.RecordNotFoundException;
import nl.pin.jukeboxInventory.models.Record;
import nl.pin.jukeboxInventory.repositories.RecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecordService {

    private final RecordRepository recordRepository;


    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public List<Record> getAllRecords() {
        List<Record> records = recordRepository.findAll();
        return records;
    }

    public Record getRecordById(Long id) {
        Optional<Record> record = recordRepository.findById(id);

        if(record.isPresent()) {
            return record.get();
        } else {
            throw new RecordNotFoundException("this ID does not exist");
        }
    }

}
