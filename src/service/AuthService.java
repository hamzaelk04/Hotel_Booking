package service;

import exception.EmailAlreadyExistsException;
import exception.EmailNotFoundException;
import exception.InvalidPasswordException;
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

    public Client login(String email, String password) throws EmailNotFoundException, InvalidPasswordException {
        if (!userRepository.existsByEmail(email)) {
            throw new EmailNotFoundException();
        }
        Client user = userRepository.findByEmail(email).orElse(null);

        if (!user.getPassword().equals(password)) {
            throw new InvalidPasswordException();
        }

        return user;
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