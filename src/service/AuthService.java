package service;

import exception.EmailAlreadyExistsException;
import model.Client;
import repository.UserRepository;

public class AuthService {

    private UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(Client client) throws EmailAlreadyExistsException {
        if (userRepository.existsByEmail(client.getEmail())) {
            throw new EmailAlreadyExistsException();
        }

        userRepository.save(client);
    }

    public void login(String email, String password) {

    }

    public void logout() {
    }

    public void sessionManagement() {
    }

    public void updateProfile() {
    }

    public void updatePassword() {
    }
}