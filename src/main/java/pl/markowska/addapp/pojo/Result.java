package pl.markowska.addapp.pojo;

import lombok.Data;

@Data
public class Result {
    private Random random;
    private Integer bitsUsed;
    private Integer bitsLeft;
    private Integer requestsLeft;
    private Integer advisoryDelay;
}
