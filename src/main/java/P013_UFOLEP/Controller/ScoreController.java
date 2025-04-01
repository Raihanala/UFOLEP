package P013_UFOLEP.Controller;

import P013_UFOLEP.Model.Score;
import P013_UFOLEP.Service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scores")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    // GET /api/scores - liste tous les scores
    @GetMapping
    public List<Score> getAllScores() {
        return scoreService.getAllScores();
    }

    // GET /api/scores/{id} - récupère un score par son id
    @GetMapping("/{id}")
    public Score getScoreById(@PathVariable Long id) {
        return scoreService.getScoreById(id);
    }

    // POST /api/scores - crée un score
    // On peut associer un score à un utilisateur via le paramètre userId (optionnel)
    @PostMapping
    public Score createScore(@RequestBody Score score, 
                             @RequestParam(required = false) Long userId) {
        return scoreService.createScore(score, userId);
    }

    // PUT /api/scores/{id} - met à jour un score existant
    @PutMapping("/{id}")
    public Score updateScore(@PathVariable Long id, @RequestBody Score scoreDetails) {
        return scoreService.updateScore(id, scoreDetails);
    }

    // DELETE /api/scores/{id} - supprime un score
    @DeleteMapping("/{id}")
    public void deleteScore(@PathVariable Long id) {
        scoreService.deleteScore(id);
    }

    // GET /api/scores/byUser/{userId} - liste les scores d'un utilisateur spécifique
    @GetMapping("/byUser/{userId}")
    public List<Score> getScoresByUser(@PathVariable Long userId) {
        return scoreService.getScoresByUser(userId);
    }
}
