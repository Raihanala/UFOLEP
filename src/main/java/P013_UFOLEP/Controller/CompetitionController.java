package P013_UFOLEP.Controller;

import P013_UFOLEP.Model.Competition;
import P013_UFOLEP.Service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competitions")
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;

    // GET /api/competitions - liste toutes les compétitions
    @GetMapping
    public List<Competition> getAllCompetitions() {
        return competitionService.getAllCompetitions();
    }

    // GET /api/competitions/{id} - récupère une compétition par son id
    @GetMapping("/{id}")
    public Competition getCompetitionById(@PathVariable Long id) {
        return competitionService.getCompetitionById(id);
    }

    // POST /api/competitions - crée une nouvelle compétition
    @PostMapping
    public Competition createCompetition(@RequestBody Competition competition) {
        return competitionService.createCompetition(competition);
    }

    // PUT /api/competitions/{id} - met à jour une compétition existante
    @PutMapping("/{id}")
    public Competition updateCompetition(@PathVariable Long id, @RequestBody Competition competitionDetails) {
        return competitionService.updateCompetition(id, competitionDetails);
    }

    // DELETE /api/competitions/{id} - supprime une compétition
    @DeleteMapping("/{id}")
    public void deleteCompetition(@PathVariable Long id) {
        competitionService.deleteCompetition(id);
    }
}
