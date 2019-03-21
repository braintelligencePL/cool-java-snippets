package pl.braintelligence.spock_tutorial.domain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserRepositoryImpl implements UserRepository {
    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public void save(User user) {
        log.info("User was saved.");
    }
}
