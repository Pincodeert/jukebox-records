package nl.pin.jukeboxInventory.controllers;

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
    public ResponseEntity<List<Track>> getAllTracks() {
        List<Track> tracks = trackService.getAllTracks();
        return ResponseEntity.ok(tracks);
    }

    @GetMapping("/tracks/{id}")
    public ResponseEntity<Track> getTrackById(@PathVariable Long id) {
        Track track = trackService.getTrackById(id);
        return ResponseEntity.ok(track);
    }
}
