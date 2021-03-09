package pl.markowska.addapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.markowska.addapp.model.mongo.RandomNumber;

@Repository
public interface RandomNumbersRepository extends MongoRepository<RandomNumber, String> {
    RandomNumber findFirstByKey(int key);
}
