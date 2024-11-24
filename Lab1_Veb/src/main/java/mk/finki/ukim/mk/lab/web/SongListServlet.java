package mk.finki.ukim.mk.lab.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.repository.SongRepository;
import mk.finki.ukim.mk.lab.service.impl.SongServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SongListServlet", urlPatterns = "/listSongs")
public class SongListServlet extends HttpServlet {

    private final SongServiceImpl songService = new SongServiceImpl(new SongRepository());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Song> songs = songService.listSongs();
        request.setAttribute("songs", songs);
        request.getRequestDispatcher("templates/listSongs.html").forward(request, response);
    }
}
