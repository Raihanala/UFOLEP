package P013_UFOLEP.Controller;

import P013_UFOLEP.Model.Cible;
import P013_UFOLEP.Service.CibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cibles")
public class CibleController {

    @Autowired
    private CibleService cibleService;

    // GET /api/cibles - liste toutes les cibles
    @GetMapping
    public List<Cible> getAllCibles() {
        return cibleService.getAllCibles();
    }

    // GET /api/cibles/{id} - récupère une cible par son id
    @GetMapping("/{id}")
    public Cible getCibleById(@PathVariable Long id) {
        return cibleService.getCibleById(id);
    }

    // POST /api/cibles - crée une nouvelle cible
    @PostMapping
    public Cible createCible(@RequestBody Cible cible) {
        return cibleService.createCible(cible);
    }

    // PUT /api/cibles/{id} - met à jour une cible existante
    @PutMapping("/{id}")
    public Cible updateCible(@PathVariable Long id, @RequestBody Cible cibleDetails) {
        return cibleService.updateCible(id, cibleDetails);
    }

    // DELETE /api/cibles/{id} - supprime une cible
    @DeleteMapping("/{id}")
    public void deleteCible(@PathVariable Long id) {
        cibleService.deleteCible(id);
    }

    // GET /api/cibles/byQrcode?qrcode=xxx - recherche une cible par son qrcode
    @GetMapping("/byQrcode")
    public Cible getCibleByQrcode(@RequestParam String qrcode) {
        return cibleService.getCibleByQrcode(qrcode);
    }
}
