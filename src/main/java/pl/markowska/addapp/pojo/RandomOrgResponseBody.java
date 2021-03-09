package pl.markowska.addapp.pojo;

import lombok.Data;

@Data
public class RandomOrgResponseBody {
    private String jsonrpc;
    private Result result;
    private Integer id;
}
