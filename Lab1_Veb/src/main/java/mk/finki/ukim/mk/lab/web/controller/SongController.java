package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Song;
import org.springframework.ui.Model;
import mk.finki.ukim.mk.lab.service.AlbumService;
import mk.finki.ukim.mk.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/songs")
public class SongController {
    private final SongService songService;
    private final AlbumService albumService;

    public SongController(SongService songService, AlbumService albumService) {
        this.songService = songService;
        this.albumService = albumService;
    }

    @GetMapping
    public String getSongsPage(@RequestParam(required = false) String error, Model model) {
        model.addAttribute("error", error);
        model.addAttribute("songs", songService.listSongs());
        model.addAttribute("albums", albumService.findAll());
        return "listSongs";
    }

    @GetMapping("/add")
    public String saveSong(@RequestParam(required = false) Long id, @RequestParam String trackId, @RequestParam String title, @RequestParam String genre, @RequestParam String year, @RequestParam Long albumId) {
        if(id != null){
            this.songService.update(id, trackId, title, genre, Integer.parseInt(year));
        }else {
            Album album = albumService.findById(albumId);
            Song newSong = new Song(trackId, title, genre, Integer.parseInt(year));
            newSong.setAlbum(album);
            songService.save(newSong);
        }
        return "redirect:/songs";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam Long id, @RequestParam String trackId, @RequestParam String title, @RequestParam String genre, @RequestParam String year, @RequestParam Long albumId) {
        Song song = songService.findById(id);
        song.setTrackId(trackId);
        song.setTitle(title);
        song.setGenre(genre);
        song.setReleaseYear(Integer.parseInt(year));
        song.setAlbum(albumService.findById(albumId));
        songService.save(song);
        return "redirect:/songs";
    }

    @GetMapping("/edit/{songId}")
    public String editSong(@PathVariable Long songId, Model model) {
        Song song = songService.findById(songId);
        model.addAttribute("song", song);
        return "redirect:/artists?trackId=" + songId;
    }

    @GetMapping("/edit-form/{id}")
    public String getEditSongForm(@PathVariable Long id, Model model) {
        Song song = songService.findById(id);
        if (song == null) {
            return "redirect:/songs?error=SongNotFound";
        }
        model.addAttribute("trackId", song.getTrackId());
        model.addAttribute("title", song.getTitle());
        model.addAttribute("genre", song.getGenre());
        model.addAttribute("year", song.getReleaseYear());
        return "add-song";
    }

    @GetMapping("/add-form")
    public String getAddSongPage() {
        return "add-song";
    }

    @GetMapping("/delete/{id}")
    public String deleteSong(@PathVariable Long id) {
        songService.delete(id);
        return "redirect:/songs";
    }
}
