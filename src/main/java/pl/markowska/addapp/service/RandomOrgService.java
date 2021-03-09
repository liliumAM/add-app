package pl.markowska.addapp.service;

import pl.markowska.addapp.pojo.RandomOrgRequestBody;
import pl.markowska.addapp.pojo.RandomOrgResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface RandomOrgService {

    @POST
    Call<RandomOrgResponseBody> getRandomInt(@Body RandomOrgRequestBody randomOrgRequestBody);

}
