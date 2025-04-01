package P013_UFOLEP.Service;

import P013_UFOLEP.Model.User;
import P013_UFOLEP.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Récupère la liste de tous les utilisateurs
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Récupère un utilisateur par son identifiant
    public User getUserById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    // Crée et enregistre un nouvel utilisateur
    public User createUser(User user) {
        // Ici, tu peux ajouter des validations (par exemple, vérifier si le username existe déjà)
        return userRepository.save(user);
    }

    // Met à jour un utilisateur existant
    public User updateUser(Long id, User userDetails) {
        User user = getUserById(id);
        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        user.setRole(userDetails.getRole());
        user.setNom(userDetails.getNom());
        user.setPrenom(userDetails.getPrenom());
        user.setClub(userDetails.getClub());
        // Si besoin, met à jour la cible associée :
        user.setCible(userDetails.getCible());
        return userRepository.save(user);
    }

    // Supprime un utilisateur par son identifiant
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Recherche un utilisateur par son username
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("User not found with username: " + username));
    }
}
