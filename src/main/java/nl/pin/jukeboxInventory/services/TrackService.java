package nl.pin.jukeboxInventory.services;

import nl.pin.jukeboxInventory.dtos.TrackDto;
import nl.pin.jukeboxInventory.exceptions.RecordNotFoundException;
import nl.pin.jukeboxInventory.models.Track;
import nl.pin.jukeboxInventory.repositories.TrackRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrackService {

    private final TrackRepository trackRepository;

    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public List<TrackDto> getAllTracks() {
        List<Track> tracks = trackRepository.findAll();
        List<TrackDto> dtos = new ArrayList<>();

        for (Track t:tracks
             ) {
            TrackDto dto = transferToDto(t);
            dtos.add(dto);
        }
        return dtos;
    }

    public TrackDto getTrackById(Long id) {
        Optional<Track> track = trackRepository.findById(id);

        if(track.isPresent()) {
            TrackDto dto = transferToDto(track.get());
            return dto;
        } else {
            throw new RecordNotFoundException("this ID does not exist");
        }
    }

    public TrackDto transferToDto(Track track) {
        TrackDto dto = new TrackDto();
        dto.setId(track.getId());
        dto.setTitle(track.getTitle());
        dto.setArtists(track.getArtists());
        return dto;
    }

}
