package client;

import admin.Show;

public class Booking {
    static void initBookTicket(int show_id, int no_t) {
        Show.locking(show_id, no_t);
    }
}