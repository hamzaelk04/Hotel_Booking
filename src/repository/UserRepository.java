package repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import model.Client;

public interface UserRepository {
    public void save(Client client);

    Optional<Client> findById(UUID id);

    Optional<Client> findByEmail(String email);

    boolean existsByEmail(String email);

    List<Client> findAll();
}