package com.ghoshtubai.movieinfoservice.controller;

import com.ghoshtubai.movieinfoservice.model.ImdbMovie;
import com.ghoshtubai.movieinfoservice.model.MovieDetails;
import com.ghoshtubai.movieinfoservice.model.MovieInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movieinfo")
public class MovieInfoController {
    @Autowired
    RestTemplate restTemplate;
    @Value("${api_key}")
    private String API_KEYS;
    @GetMapping("/{movieId}")
    public MovieInfo getMovieDetails(@PathVariable final String movieId){
        String url = "http://www.omdbapi.com/?t="+movieId+"&apikey="+API_KEYS;
        ImdbMovie imdbMovie = restTemplate.getForObject(url,ImdbMovie.class);
        MovieDetails details = new MovieDetails();
        details.setGenre(imdbMovie.getGenre());
        details.setDescription(imdbMovie.getPlot());
        details.setReleaseDate(imdbMovie.getReleased());
        return new MovieInfo(movieId,details);
    }
}
