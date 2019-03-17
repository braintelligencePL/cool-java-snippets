package pl.braintelligence.java.domain.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.braintelligence.java.domain.user.User;

public interface UserRepository extends MongoRepository<User, String> {
    User findOne(String id);
}



