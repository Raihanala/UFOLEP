package P013_UFOLEP.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String role;
    private String nom;
    private String prenom;
    private String club;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Score> scores = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cible_id") 
    private Cible cible;
    // Constructeurs
    public User() {}
    public User(String username, String password, String role, String nom, String prenom, String club) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.nom = nom;
        this.prenom = prenom;
        this.club = club;
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
	}
	@Override
	public int hashCode() {
		return Objects.hash(club, id, nom, password, prenom, role, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(club, other.club) && Objects.equals(id, other.id) && Objects.equals(nom, other.nom)
				&& Objects.equals(password, other.password) && Objects.equals(prenom, other.prenom)
				&& Objects.equals(role, other.role) && Objects.equals(username, other.username);
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + ", nom="
				+ nom + ", prenom=" + prenom + ", club=" + club + "]";
	}

  
}
