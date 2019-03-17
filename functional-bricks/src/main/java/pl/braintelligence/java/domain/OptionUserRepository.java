package pl.braintelligence.java.domain;

import io.vavr.control.Option;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OptionUserRepository extends MongoRepository<User, String> {

    Option<OptionUser> findOne(String id);

}



