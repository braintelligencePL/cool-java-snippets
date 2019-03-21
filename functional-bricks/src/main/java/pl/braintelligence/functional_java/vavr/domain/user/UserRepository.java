package pl.braintelligence.functional_java.vavr.domain.user;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findOne(String id);
}



