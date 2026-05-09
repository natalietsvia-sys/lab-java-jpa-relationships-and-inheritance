package week8;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private LocalDate date;
    private Integer duration;
    private String location;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "event_guest",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "guest_id")
    )
    private List<Guest> guests = new ArrayList<>();

    protected Event() {
    }

    public Event(String title, LocalDate date, Integer duration, String location) {
        this.title = title;
        this.date = date;
        this.duration = duration;
        this.location = location;
    }

    public void addGuest(Guest guest) {
        guests.add(guest);
    }
}
