package service;

import exception.EmailAlreadyExistsException;
import model.Client;
import repository.UserRepository;

public class AuthService {

    private UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(String name, String email, String password, String numberPhone) throws EmailAlreadyExistsException {
        validateRegister(name, email, password, numberPhone);

        Client client = new Client(name, email, numberPhone, password);
        userRepository.save(client);

    }

    public void login() {
    }

    public void logout() {
    }

    public void sessionManagement() {
    }

    public void updateProfile() {
    }

    public void updatePassword() {
    }

    public void validateRegister(String name, String email, String password, String numberPhone) throws EmailAlreadyExistsException {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("The name is obligatory!");
        }

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("The email is obligatory!");
        }

        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException("You should enter a valid email!");
        }

        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Enter a valid email!");
        }

        if (password.length() < 6) {
            throw new IllegalArgumentException("Password must contain at least 6 characters.");
        }

        if (userRepository.existsByEmail(email)) {
            throw new EmailAlreadyExistsException();
        }

        if (numberPhone == null || numberPhone.isBlank()) {
            throw new IllegalArgumentException("Phone number is required.");
        }

        if (!numberPhone.matches("\\d{10}")) {
            throw new IllegalArgumentException(
                    "Phone number must contain exactly 10 digits."
            );
        }
    }
}