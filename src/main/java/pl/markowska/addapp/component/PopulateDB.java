package pl.markowska.addapp.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.markowska.addapp.model.mongo.RandomNumber;
import pl.markowska.addapp.repository.RandomNumbersRepository;

import javax.annotation.PostConstruct;
import java.util.Random;

@Component
public class PopulateDB {

    @Autowired
    private RandomNumbersRepository randomNumbersRepository;

    @PostConstruct
    private void populateRepositoryWithRandomNumbers() {
        Random randomGenerator = new Random();
        for (int i = 0; i < 10; i++) {
            randomNumbersRepository.save(RandomNumber
                    .builder()
                    .key(i)
                    .number(randomGenerator.nextInt())
                    .build());
        }
    }
}
