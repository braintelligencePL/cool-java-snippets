package pl.braintelligence.spock_tutorial.domain;

public interface UserRepository {
    boolean isAvailable();

    void save(User user);
}
