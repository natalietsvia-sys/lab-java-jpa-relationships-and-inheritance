package week8;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String district;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "association_id")
    private Association association;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "president_id")
    private Member president;

    @OneToMany(mappedBy = "division", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Member> members = new ArrayList<>();

    protected Division() {
    }

    public Division(String name, String district) {
        this.name = name;
        this.district = district;
    }

    public Long getId() {
        return id;
    }

    public void setAssociation(Association association) {
        this.association = association;
    }

    public void setPresident(Member president) {
        this.president = president;
        addMember(president);
    }

    public void addMember(Member member) {
        members.add(member);
        member.setDivision(this);
    }
}
