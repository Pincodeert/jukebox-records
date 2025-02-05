package nl.pin.jukeboxInventory.services;

import nl.pin.jukeboxInventory.dtos.ArtistDto;
import nl.pin.jukeboxInventory.exceptions.RecordNotFoundException;
import nl.pin.jukeboxInventory.models.Artist;
import nl.pin.jukeboxInventory.repositories.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public List<ArtistDto> getAllArtists() {
        List<Artist> artists = artistRepository.findAll();
        List<ArtistDto> dtos = new ArrayList<>();

        for (Artist a:artists
             ) {
            ArtistDto dto = transferToDto(a);
            dtos.add(dto);
        }
        return dtos;
    }

    public ArtistDto getArtistById(Long id) {
        Optional<Artist> artist = artistRepository.findById(id);

        if(artist.isPresent()) {
            ArtistDto dto = transferToDto(artist.get());
            return dto;
        } else {
            throw new RecordNotFoundException("this ID does not exist");
        }
    }

    public ArtistDto transferToDto(Artist artist) {
        ArtistDto dto = new ArtistDto();

        dto.setId(artist.getId());
        dto.setFirstName(artist.getFirstName());
        dto.setLastName(artist.getLastName());

        return dto;
    }

}
