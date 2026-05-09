package week8;

import jakarta.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Exhibition extends Event {
    protected Exhibition() {
    }

    public Exhibition(String title, LocalDate date, Integer duration, String location) {
        super(title, date, duration, location);
    }
}
