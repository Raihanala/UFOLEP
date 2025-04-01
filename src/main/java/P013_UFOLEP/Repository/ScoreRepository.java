package P013_UFOLEP.Repository;

import P013_UFOLEP.Model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {

    // Récupérer tous les scores d'un utilisateur donné
    List<Score> findByUserId(Long userId);

    // Récupérer tous les scores d'une compétition donnée
    List<Score> findByCompetitionId(Long competitionId);

    // Récupérer tous les scores d'une cible donnée
    List<Score> findByCibleId(Long cibleId);

    // Récupérer les scores dont les points sont supérieurs ou égaux à une valeur donnée
    List<Score> findByPointsGreaterThanEqual(int points);

    // Requête personnalisée pour récupérer les scores entre deux dates
    @Query("SELECT s FROM Score s WHERE s.dateTime >= :start AND s.dateTime <= :end")
    List<Score> findScoresBetweenDates(LocalDateTime start, LocalDateTime end);
}
