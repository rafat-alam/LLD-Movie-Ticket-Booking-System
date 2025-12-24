import exceptions.IsZeroOrNegException;
import exceptions.YearException;

import java.util.Objects;

public class Date {
    int d, m, y;

    Date(int d, int m, int y) {
        if(d <= 0) {
            throw new IsZeroOrNegException("Date must be positive");
        }
        if(m <= 0) {
            throw new IsZeroOrNegException("Month must be positive");
        }
        if(y < 2020 || y > 2030) {
            throw new YearException("Year must be between [2020 - 2030]");
        }
        this.d = d;
        this.m = m;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Date date)) return false;
        return d == date.d && m == date.m && y == date.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(d, m, y);
    }
}
