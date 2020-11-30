package de.tekup.ex.services;

import java.util.List;

import org.springframework.stereotype.Service;

import de.tekup.ex.models.Movie;
import de.tekup.ex.models.Studio;
import de.tekup.ex.repositories.MovieRepository;
import de.tekup.ex.repositories.StarRepository;
import de.tekup.ex.repositories.StudioRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CinemaServiceImpl implements CinemaService {
	
	private MovieRepository reposMovie;
	private StudioRepository repoStudio;
	private StarRepository reposStar;

	@Override
	public List<Studio> getStudiosByStar(String starName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movie> getColoredMoviesByStudio(String studioName) {
		// TODO Auto-generated method stub
		return null;
	}

}
