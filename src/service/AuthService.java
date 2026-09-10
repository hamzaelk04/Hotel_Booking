package service;

import exception.EmailAlreadyExistsException;
import exception.EmailNotFoundException;
import exception.InvalidCredentialException;
import exception.InvalidPasswordException;
import model.User;
import repository.UserRepository;

import java.util.UUID;

public class AuthService {

    private final UserRepository userRepository;
    private User currentUser;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void register(User user) throws EmailAlreadyExistsException {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyExistsException();
        }

        currentUser = user;

        userRepository.save(currentUser);
    }

    public UUID login(String email, String password) throws EmailNotFoundException, InvalidPasswordException {
        if (!userRepository.existsByEmail(email)) {
            throw new EmailNotFoundException();
        }
        User user = userRepository.findByEmail(email).orElse(null);

        if (!user.getPassword().equals(password)) {
            throw new InvalidPasswordException();
        }

        currentUser = user;

        return user.getId();
    }

    public void logout(UUID id) {
        if (currentUser.getId() == id) {
            currentUser = null;
        } else {
            System.out.println("Something wrong!");
        }
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

    public void updateProfile(UUID id, String name, String email, String numberPhone) throws InvalidCredentialException {
        User user = userRepository.findById(id).orElseThrow(InvalidCredentialException::new);

        user.setName(name);
        user.setEmail(email);
        user.setNumberPhone(numberPhone);

        userRepository.save(user);
    }

    public void updatePassword() {
    }
}