package week8;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Conference extends Event {
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "conference_speaker",
            joinColumns = @JoinColumn(name = "conference_id"),
            inverseJoinColumns = @JoinColumn(name = "speaker_id")
    )
    private List<Speaker> speakers = new ArrayList<>();

    protected Conference() {
    }

    public Conference(String title, LocalDate date, Integer duration, String location) {
        super(title, date, duration, location);
    }

    public void addSpeaker(Speaker speaker) {
        speakers.add(speaker);
    }
}
