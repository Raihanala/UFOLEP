package P013_UFOLEP.Service;

import P013_UFOLEP.Model.Score;
import P013_UFOLEP.Model.User;
import P013_UFOLEP.Repository.ScoreRepository;
import P013_UFOLEP.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private UserRepository userRepository;

    // Récupère la liste de tous les scores
    public List<Score> getAllScores() {
        return scoreRepository.findAll();
    }

    // Récupère un score par son identifiant
    public Score getScoreById(Long id) {
        return scoreRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Score not found with id: " + id));
    }

    // Crée et enregistre un score. Si un userId est fourni, le score est associé à cet utilisateur.
    public Score createScore(Score score, Long userId) {
        if (userId != null) {
            User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
            score.setUser(user);
        }
        // Par exemple, on affecte la date courante
        score.setDateTime(LocalDateTime.now());
        return scoreRepository.save(score);
    }

    // Met à jour un score existant
    public Score updateScore(Long id, Score scoreDetails) {
        Score score = getScoreById(id);
        score.setPoints(scoreDetails.getPoints());
        // Tu peux décider de mettre à jour la dateTime ou d'autres attributs
        return scoreRepository.save(score);
    }

    // Supprime un score par son identifiant
    public void deleteScore(Long id) {
        scoreRepository.deleteById(id);
    }

    // Récupère tous les scores d'un utilisateur spécifique
    public List<Score> getScoresByUser(Long userId) {
        return scoreRepository.findByUserId(userId);
    }
}
