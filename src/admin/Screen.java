package admin;

import exceptions.IdNotFoundException;
import exceptions.IsZeroOrNegException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Screen {
    int id;
    int theatreId;
    int capacity;
    List<Integer> show_ids;

    static Map<Integer, Screen> listedScreen = new HashMap<>();
    static int screenCount = 0;

    Screen(int theatreId, int capacity) {
        if(capacity <= 0) {
            throw new IsZeroOrNegException("Screen capacity must be positive");
        }
        try {
            Theatre.addScreen(theatreId, screenCount + 1);
        } catch (IdNotFoundException e) {
            throw new IdNotFoundException(e.getMessage());
        }
        this.id = ++screenCount;
        this.theatreId = theatreId;
        this.capacity = capacity;
        this.show_ids = new ArrayList<>();
        listedScreen.put(screenCount, this);
        System.out.println("Screen created with id : " + screenCount);
    }

    static Screen getById(int screen_id) {
        Screen screen = listedScreen.get(screen_id);
        if (screen == null) {
            throw new IdNotFoundException("Screen id not found: " + screen_id);
        }
        return screen;
    }

    static void fetchScreen(int screen_id) {
        Screen screen = listedScreen.get(screen_id);
        System.out.println("Screen Id : " + screen_id);
        System.out.println("Screen Capacity : " + screen.capacity);

        for(int show_id : screen.show_ids) {
            Show.fetchShow(show_id);
        }
    }
}
