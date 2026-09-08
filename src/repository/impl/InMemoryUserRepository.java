package repository.impl;

import model.Client;
import repository.UserRepository;

import java.util.*;

public class InMemoryUserRepository implements UserRepository {
    private HashMap<UUID, Client> users = new HashMap<>();

    @Override
    public void save(Client client) {
        users.put(client.getId(), client);
    }

    @Override
    public Optional<Client> findById(UUID id) {
        return Optional.ofNullable(users.get(id));
    }

    @Override
    public Optional<Client> findByEmail(String email) {
        return users.values()
                .stream()
                .filter(client -> client.getEmail().equals(email))
                .findFirst();
    }

    @Override
    public boolean existsByEmail(String email){
        return users.values()
                .stream()
                .anyMatch(client -> client.getEmail().equals(email));
    }

    @Override
    public List<Client> findAll() {
        return new ArrayList<>(users.values());
    }
}