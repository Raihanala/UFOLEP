package P013_UFOLEP.Service;

import P013_UFOLEP.Model.Competition;
import P013_UFOLEP.Repository.CompetitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CompetitionService {

    @Autowired
    private CompetitionRepository competitionRepository;

    // Récupère toutes les compétitions
    public List<Competition> getAllCompetitions() {
        return competitionRepository.findAll();
    }

    // Récupère une compétition par son identifiant
    public Competition getCompetitionById(Long id) {
        return competitionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Competition not found with id: " + id));
    }

    // Crée et enregistre une nouvelle compétition
    public Competition createCompetition(Competition competition) {
        return competitionRepository.save(competition);
    }

    // Met à jour une compétition existante
    public Competition updateCompetition(Long id, Competition competitionDetails) {
        Competition competition = getCompetitionById(id);
        competition.setNom(competitionDetails.getNom());
        competition.setDate(competitionDetails.getDate());
        return competitionRepository.save(competition);
    }

    // Supprime une compétition par son identifiant
    public void deleteCompetition(Long id) {
        competitionRepository.deleteById(id);
    }

    // Recherche des compétitions par nom
    public List<Competition> getCompetitionsByNom(String nom) {
        return competitionRepository.findByNom(nom);
    }

    // Recherche des compétitions entre deux dates
    public List<Competition> getCompetitionsBetweenDates(LocalDate start, LocalDate end) {
        return competitionRepository.findByDateBetween(start, end);
    }
}
