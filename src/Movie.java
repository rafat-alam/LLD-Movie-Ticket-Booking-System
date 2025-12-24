import exceptions.EmptyField;
import exceptions.IdNotFoundException;
import exceptions.IsZeroOrNegException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Movie {
    int id;
    String name;
    int duration; // in minutes

    static Map<Integer, Movie> listedMovies = new HashMap<>();
    static int moviesCount = 0;

    Movie(String name, int duration) {
        if(Objects.equals(name, "")) {
            throw new EmptyField("Movie name must be there");
        }
        if (duration <= 0) {
            throw new IsZeroOrNegException("Movie duration must be positive");
        }

        this.id = ++moviesCount;
        this.name = name;
        this.duration = duration;
        listedMovies.put(this.id, this);

        System.out.println("Movie created with id : " + this.id);
    }

    static Movie getById(int movie_id) {
        Movie movie = listedMovies.get(movie_id);
        if (movie == null) {
            throw new IdNotFoundException("Movie id not found: " + movie_id);
        }
        return movie;
    }
}
