package pl.markowska.addapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.markowska.addapp.pojo.DataSource;
import pl.markowska.addapp.repository.RandomNumbersRepository;

import java.io.IOException;
import java.util.List;
import java.util.Random;

@Service
public class DataSumService {

    @Autowired
    private RandomOrgIntegrationService randomOrgIntegrationService;
    @Autowired
    private RandomNumbersRepository randomNumbersRepository;

    public int computeSum(List<DataSource> dataSources) throws IOException {
        int sum = 0;

        if (dataSources.contains(DataSource.JAVA_RANDOM)) {
            sum += getIntFromJava();
        } else if (dataSources.contains(DataSource.RANDOM_ORG)) {
            sum += getIntFromRandomOrg();
        } else if (dataSources.contains(DataSource.DB)) {
            sum += getIntFromDB();
        }
        return sum;
    }

    private int getIntFromJava() {
        Random generator = new Random();
        return generator.nextInt();
    }

    private int getIntFromRandomOrg() throws IOException {
        return randomOrgIntegrationService.getRandom();
    }

    private int getIntFromDB() {
        Random randomKey = new Random();
        return randomNumbersRepository.findFirstByKey(randomKey.nextInt(10)).getNumber();
    }
}
