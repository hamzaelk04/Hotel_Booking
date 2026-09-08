package service;

import repository.UserRepository;

public class AuthService {

    private UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(String name, String email, String password, String numberPhone) {
        if (name.isBlank() || name == null) {
            throw new IllegalArgumentException("The name is obligatory!");
        } else if (email.isBlank() || email == null) {
            throw new IllegalArgumentException("The name is obligatory!");
        } else if (!email.contains("@")) {
            throw new IllegalArgumentException("You should enter a valid email!");
        } else if (password.isBlank() || password.length() < 6) {
            throw new IllegalArgumentException("Enter a valid email!");
        }
    }

    public void login() {}
    public void logout() {}
    public void sessionManagement() {}
    public void updateProfile() {}
    public void updatePassword() {}
}