//package mk.finki.ukim.mk.lab.repository;
//
//import mk.finki.ukim.mk.lab.model.Artist;
//import mk.finki.ukim.mk.lab.model.Song;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class SongRepository {
//    private final List<Song> songs;
//
//    public SongRepository() {
//        this.songs = new ArrayList<>(5);
//
//        Artist artist1 = new Artist(1L, "Axl", "Rose", "Lead vocalist of Guns N' Roses");
//        Artist artist2 = new Artist(2L, "Jon", "Bon Jovi", "Rock singer and songwriter");
//
//        songs.add(new Song("1", "Sweet Child O' Mine", "Rock", 1987, artist1));
//        songs.add(new Song("2", "Livin' on a Prayer", "Rock", 1986, artist2));
//        songs.add(new Song("3", "November Rain", "Rock", 1991, artist1));
//        songs.add(new Song("4", "Bed of Roses", "Rock", 1992, artist2));
//        songs.add(new Song("5", "Don't Cry", "Rock", 1991, artist1));
//    }
//
//    public List<Song> findAll() {
//        return songs;
//    }
//
//    public Song findByTrackId(String trackId) {
//        return songs.stream().filter(s -> s.getTrackId().equals(trackId)).findFirst().orElse(null);
//    }
//
//    public Artist addArtistToSong(Artist artist, Song song) {
//        song.getPerformers().add(artist);
//        return artist;
//    }
//}
