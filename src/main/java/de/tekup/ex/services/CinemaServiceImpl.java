package de.tekup.ex.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import de.tekup.ex.models.Movie;
import de.tekup.ex.models.Star;
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
		Star star = reposStar.findById(starName)
				.orElseThrow(()-> new NoSuchElementException("Star with this name is not found"));
		Set<Studio> studios = new HashSet<>();
		
		for (Movie movie : star.getMovies()) {
			studios.add(movie.getStudio());
			
		}
		return new ArrayList<>(studios);
		/*return star.getMovies().stream()
								.map(movie -> movie.getStudio())
								.distinct()
								.collect(Collectors.toList());
								*/
	}

	@Override
	public List<Movie> getColoredMoviesByStudio(String studioName) {
		Studio studio = repoStudio.findById(studioName)
				.orElseThrow(()-> new NoSuchElementException("Studio with this name is not found"));
		
		return studio.getMovies()
					.stream()
					.filter(movie -> movie.getColor() == 1)
					.collect(Collectors.toList());
	}

}
