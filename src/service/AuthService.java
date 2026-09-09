package service;

import exception.EmailAlreadyExistsException;
import exception.EmailNotFoundException;
import exception.InvalidPasswordException;
import model.User;
import repository.UserRepository;

public class AuthService {

    private UserRepository userRepository;
    private User currentUser;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(User user) throws EmailAlreadyExistsException {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyExistsException();
        }

        userRepository.save(user);
    }

    public User login(String email, String password) throws EmailNotFoundException, InvalidPasswordException {
        if (!userRepository.existsByEmail(email)) {
            throw new EmailNotFoundException();
        }
        User user = userRepository.findByEmail(email).orElse(null);

        if (!user.getPassword().equals(password)) {
            throw new InvalidPasswordException();
        }

        currentUser = user;

        return user;
    }

    public void logout() {
        currentUser = null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean isAuthenticated() {
        return currentUser != null;
    }

    public String sessionManagement() {
        return currentUser.getRole();
    }

    public void updateProfile() {
    }

    public void updatePassword() {
    }
}