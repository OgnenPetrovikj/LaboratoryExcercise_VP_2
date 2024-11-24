//package mk.finki.ukim.mk.lab.repository;
//
//import mk.finki.ukim.mk.lab.model.Artist;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class ArtistRepository {
//    private List<Artist> artists = new ArrayList<>(5);
//
//    public ArtistRepository() {
//        artists.add(new Artist(1L, "Dragomir", "Despich", "Dezinger"));
//        artists.add(new Artist(2L, "Senidah", "Dimikj", "nebitno"));
//        artists.add(new Artist(3L, "Ana", "Shulevska", "Kafe"));
//    }
//
//    public List<Artist> findAll() {
//        return artists;
//    }
//
//    public Optional<Artist> findById(Long id) {
//        return artists.stream().filter(a -> a.getId().equals(id)).findFirst();
//    }
//}