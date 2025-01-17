package mk.finki.ukim.mk.lab.service.impl;

import jakarta.transaction.Transactional;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.repository.jpa.ArtistRepository;
import mk.finki.ukim.mk.lab.repository.jpa.SongRepository;
import mk.finki.ukim.mk.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;
    private final ArtistRepository artistRepository;

    public SongServiceImpl(SongRepository songRepository, ArtistRepository artistRepository) {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Song findById(Long id) {
        return songRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        song.getPerformers().add(artist);
        artist.getSongs().add(song);
        songRepository.save(song);
        artistRepository.save(artist);
        return artist;
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public void delete(Long id) {
        songRepository.deleteById(id);
    }

    @Override
    public void update(Long id, String trackId, String title, String genre, int year) {
        Song song = songRepository.findById(id).get();
        song.setTrackId(trackId);
        song.setTitle(title);
        song.setGenre(genre);
        song.setReleaseYear(year);
        this.songRepository.save(song);
    }
}
