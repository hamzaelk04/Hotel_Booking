package repository.impl;

import exception.InvalidCredentialException;
import model.User;
import repository.UserRepository;

import java.util.*;

public class InMemoryUserRepository implements UserRepository {
    private HashMap<UUID, User> users = new HashMap<>();

    @Override
    public void save(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public Optional<User> findById(UUID id) throws InvalidCredentialException{
        if (Optional.ofNullable(users.get(id)).isEmpty()) {
            throw new InvalidCredentialException();
        } else {
            return Optional.of(users.get(id));
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return users.values()
                .stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }

    @Override
    public boolean existsByEmail(String email) {
        return users.values()
                .stream()
                .anyMatch(user -> user.getEmail().equals(email));
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }
}