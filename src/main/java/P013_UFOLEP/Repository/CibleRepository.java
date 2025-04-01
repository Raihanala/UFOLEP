package P013_UFOLEP.Repository;

import P013_UFOLEP.Model.Cible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CibleRepository extends JpaRepository<Cible, Long> {

    // Rechercher une cible par son code QR
    Optional<Cible> findByQrcode(String qrcode);

    // Récupérer toutes les cibles associées à une compétition donnée
    List<Cible> findByCompetitionId(Long competitionId);
}
