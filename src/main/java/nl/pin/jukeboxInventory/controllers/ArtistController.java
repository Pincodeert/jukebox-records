package nl.pin.jukeboxInventory.controllers;

import nl.pin.jukeboxInventory.dtos.ArtistDto;
import nl.pin.jukeboxInventory.models.Artist;
import nl.pin.jukeboxInventory.services.ArtistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArtistController {

    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/artists")
    public ResponseEntity<List<ArtistDto>> getAllArtists() {
        List<ArtistDto> artists = artistService.getAllArtists();
        return ResponseEntity.ok(artists);
    }

    @GetMapping("/artists/{id}")
    public ResponseEntity<ArtistDto> getArtistById(@PathVariable Long id) {
        ArtistDto artistDto = artistService.getArtistById(id);
        return ResponseEntity.ok(artistDto);
    }
}
