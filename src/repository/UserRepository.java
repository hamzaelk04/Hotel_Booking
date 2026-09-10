package repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import exception.InvalidCredentialException;
import model.User;

public interface UserRepository {
    public void save(User user);

    Optional<User> findById(UUID id) throws InvalidCredentialException;

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    List<User> findAll();
}