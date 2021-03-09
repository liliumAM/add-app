package pl.markowska.addapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.markowska.addapp.pojo.RandomOrgParams;
import pl.markowska.addapp.pojo.RandomOrgRequestBody;
import pl.markowska.addapp.pojo.RandomOrgResponseBody;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.Random;

@Service
public class RandomOrgIntegrationService {

    @Autowired
    private RandomOrgService randomOrgService;

    @Value("${random-org.jsonrpc}")
    private String jsonrpc;
    @Value("${random-org.api-key}")
    private String apiKey;
    @Value("${random-org.method}")
    private String method;
    @Value("${random-org.min}")
    private int min;
    @Value("${random-org.max}")
    private int max;
    @Value("${random-org.n}")
    private int n;

    private RandomOrgRequestBody buildRandomOrgRequestBody() {
        Random idGenerator = new Random();
        return RandomOrgRequestBody.builder()
                .id(idGenerator.nextInt(10))
                .jsonrpc(jsonrpc)
                .method(method)
                .params(RandomOrgParams.builder()
                        .apiKey(apiKey)
                        .max(max)
                        .min(min)
                        .n(n)
                        .build())
                .build();

    }

    public int getRandom() throws IOException {
        Call<RandomOrgResponseBody> getRandomInt = randomOrgService.getRandomInt(buildRandomOrgRequestBody());
        Response<RandomOrgResponseBody> getRandomIntResponse = getRandomInt.execute();

        return getRandomIntResponse
                .body()
                .getResult()
                .getRandom()
                .getData()
                .get(0);
    }
}
