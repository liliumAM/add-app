package pl.markowska.addapp.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RandomOrgParams {
    private String apiKey;
    private int n;
    private int min;
    private int max;
}
