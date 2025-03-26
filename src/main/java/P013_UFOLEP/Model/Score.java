package P013_UFOLEP.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int points;
    private LocalDateTime dateTime;

    // Relation avec User
    @ManyToOne
    private User user;

    // Relation avec Competition, si tu veux savoir à quelle compétition ce score appartient
    @ManyToOne
    private Competition competition;

    // Relation avec Cible, si tu veux savoir sur quelle cible a été réalisé ce score
    @ManyToOne
    private Cible cible;

    public Score() {}
    public Score(int points, LocalDateTime dateTime, User user, Competition competition, Cible cible) {
        this.points = points;
        this.dateTime = dateTime;
        this.user = user;
        this.competition = competition;
        this.cible = cible;
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Competition getCompetition() {
		return competition;
	}
	public void setCompetition(Competition competition) {
		this.competition = competition;
	}
	public Cible getCible() {
		return cible;
	}
	public void setCible(Cible cible) {
		this.cible = cible;
	}
	@Override
	public String toString() {
		return "Score [id=" + id + ", points=" + points + ", dateTime=" + dateTime + ", user=" + user + ", competition="
				+ competition + ", cible=" + cible + "]";
	}

}
