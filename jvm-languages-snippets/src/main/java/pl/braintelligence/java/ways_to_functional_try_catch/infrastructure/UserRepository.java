package pl.braintelligence.java.ways_to_functional_try_catch.infrastructure;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface UserRepository extends MongoRepository<Order, String> {
    List<Order> findByActiveTrue();
}
