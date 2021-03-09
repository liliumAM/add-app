package pl.markowska.addapp.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RandomOrgRequestBody {
    private String jsonrpc;
    private String method;
    private RandomOrgParams params;
    private int id;

}
