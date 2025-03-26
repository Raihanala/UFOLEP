package P013_UFOLEP.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private LocalDate date;  // ou LocalDateTime si besoin
    @OneToMany(mappedBy = "competition", cascade = CascadeType.ALL)
    private List<Cible> cibles = new ArrayList<>();
    public Competition() {}

    public Competition(String nom, LocalDate date) {
        this.nom = nom;
        this.date = date;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Competition [id=" + id + ", nom=" + nom + ", date=" + date + "]";
	}

    
}
