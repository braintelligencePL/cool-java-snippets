package pl.braintelligence.functional.standard.domain.user;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findOne(String id);
}



