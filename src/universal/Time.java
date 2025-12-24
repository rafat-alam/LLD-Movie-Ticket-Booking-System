package universal;

import exceptions.TimeException;

public class Time {
    public int hr, min;

    public Time(int hr, int min) {
        if(hr < 0) {
            throw new TimeException("Hour cannot be negative.");
        }
        if(hr > 23) {
            throw new TimeException("Hour cannot be greater than 23");
        }
        if(min < 0) {
            throw new TimeException("Minute cannot be negative.");
        }
        if(min > 59) {
            throw new TimeException("Minute cannot be greater than 59");
        }
        this.hr = hr;
        this.min = min;
    }
}