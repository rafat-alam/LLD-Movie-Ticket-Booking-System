import exceptions.IdNotFoundException;
import exceptions.IsZeroOrNegException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Screen {
    int id;
    int theatreId;
    int capacity;

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
        System.out.println("Screen Id : " + screen_id);
        System.out.println("Screen Capacity : " + listedScreen.get(screen_id).capacity);
    }
}
