package week8;

import java.time.LocalDate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AssociationDataLoader implements CommandLineRunner {
    private final AssociationRepository associationRepository;

    public AssociationDataLoader(AssociationRepository associationRepository) {
        this.associationRepository = associationRepository;
    }

    @Override
    public void run(String... args) {
        Association association = new Association("Nurse Association of Spain");

        association.addDivision(division("Andalusia Division", "South", "Maria Garcia"));
        association.addDivision(division("Aragon Division", "Northeast", "Lucia Martin"));
        association.addDivision(division("Asturias Division", "North", "Carmen Alvarez"));
        association.addDivision(division("Catalonia Division", "East", "Sofia Torres"));
        association.addDivision(division("Galicia Division", "Northwest", "Elena Fernandez"));
        association.addDivision(division("Madrid Division", "Central", "Isabel Ruiz"));
        association.addDivision(division("Valencia Division", "Mediterranean", "Paula Navarro"));

        associationRepository.save(association);
    }

    private Division division(String name, String district, String presidentName) {
        Division division = new Division(name, district);
        Member president = new Member(presidentName, MemberStatus.ACTIVE, LocalDate.now().plusYears(1));
        division.setPresident(president);
        return division;
    }
}
