package nl.pin.jukeboxInventory.services;

import nl.pin.jukeboxInventory.exceptions.RecordNotFoundException;
import nl.pin.jukeboxInventory.models.Artist;
import nl.pin.jukeboxInventory.repositories.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public List<Artist> getAllArtists() {
        List<Artist> artists = artistRepository.findAll();
        return artists;
    }

    public Artist getArtistById(Long id) {
        Optional<Artist> artist = artistRepository.findById(id);

        if(artist.isPresent()) {
            return artist.get();
        } else {
            throw new RecordNotFoundException("this ID does not exist");
        }
    }

}
