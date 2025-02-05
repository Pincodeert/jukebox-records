package nl.pin.jukeboxInventory.controllers;

import nl.pin.jukeboxInventory.dtos.TrackDto;
import nl.pin.jukeboxInventory.models.Track;
import nl.pin.jukeboxInventory.services.TrackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrackController {

    private final TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping("/tracks")
    public ResponseEntity<List<TrackDto>> getAllTracks() {
        List<TrackDto> trackDtos = trackService.getAllTracks();
        return ResponseEntity.ok(trackDtos);
    }

    @GetMapping("/tracks/{id}")
    public ResponseEntity<TrackDto> getTrackById(@PathVariable Long id) {
        TrackDto trackDto = trackService.getTrackById(id);
        return ResponseEntity.ok(trackDto);
    }
}
