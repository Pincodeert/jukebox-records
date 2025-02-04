package nl.pin.jukeboxInventory.services;

import nl.pin.jukeboxInventory.exceptions.RecordNotFoundException;
import nl.pin.jukeboxInventory.models.Track;
import nl.pin.jukeboxInventory.repositories.TrackRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackService {

    private final TrackRepository trackRepository;

    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public List<Track> getAllTracks() {
        List<Track> tracks = trackRepository.findAll();
        return tracks;
    }

    public Track getTrackById(Long id) {
        Optional<Track> track = trackRepository.findById(id);

        if(track.isPresent()) {
            return track.get();
        } else {
            throw new RecordNotFoundException("this ID does not exist");
        }
    }

}
