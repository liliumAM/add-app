package pl.markowska.addapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import pl.markowska.addapp.service.RandomOrgService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RandomOrgIntegrationConfiguration {
    private static final String RANDOM_ORG_HOST = "https://api.random.org/json-rpc/2/invoke/";

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    RandomOrgService randomOrgService() {
        return new Retrofit.Builder()
                .baseUrl(RANDOM_ORG_HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(RandomOrgService.class);
    }
}
