package P013_UFOLEP.Repository;

import P013_UFOLEP.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Recherche d'un utilisateur par son username
    Optional<User> findByUsername(String username);

    // Recherche des utilisateurs ayant un rôle spécifique
    List<User> findByRole(String role);

    // Recherche par combinaison de nom et prénom
    List<User> findByNomAndPrenom(String nom, String prenom);

    // Requête personnalisée pour obtenir les utilisateurs d'un club, triés par username
    @Query("SELECT u FROM User u WHERE u.club = :club ORDER BY u.username ASC")
    List<User> findByClubOrdered(String club);

    // Compter le nombre d'utilisateurs ayant un rôle donné
    long countByRole(String role);

    // Vérifier si un utilisateur existe par username
    boolean existsByUsername(String username);
}
