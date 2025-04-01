package P013_UFOLEP.Service;

import P013_UFOLEP.Model.Cible;
import P013_UFOLEP.Repository.CibleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CibleService {

    @Autowired
    private CibleRepository cibleRepository;

    // Récupère toutes les cibles
    public List<Cible> getAllCibles() {
        return cibleRepository.findAll();
    }

    // Récupère une cible par son identifiant
    public Cible getCibleById(Long id) {
        return cibleRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Cible not found with id: " + id));
    }

    // Crée et enregistre une nouvelle cible
    public Cible createCible(Cible cible) {
        return cibleRepository.save(cible);
    }

    // Met à jour une cible existante
    public Cible updateCible(Long id, Cible cibleDetails) {
        Cible cible = getCibleById(id);
        cible.setDescription(cibleDetails.getDescription());
        cible.setQrcode(cibleDetails.getQrcode());
        // Optionnel : mettre à jour Competition si nécessaire
        return cibleRepository.save(cible);
    }

    // Supprime une cible par son identifiant
    public void deleteCible(Long id) {
        cibleRepository.deleteById(id);
    }

    // Recherche une cible par son qrcode
    public Cible getCibleByQrcode(String qrcode) {
        return cibleRepository.findByQrcode(qrcode)
            .orElseThrow(() -> new RuntimeException("Cible not found with qrcode: " + qrcode));
    }
}
