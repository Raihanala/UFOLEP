package P013_UFOLEP.Repository;

import P013_UFOLEP.Model.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Long> {

    // Rechercher des compétitions par nom
    List<Competition> findByNom(String nom);

    // Rechercher des compétitions dont la date est après une date donnée
    List<Competition> findByDateAfter(LocalDate date);

    // Rechercher des compétitions entre deux dates
    List<Competition> findByDateBetween(LocalDate start, LocalDate end);
}
