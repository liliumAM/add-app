package pl.markowska.addapp.pojo;

import lombok.Data;

import java.util.List;

@Data
public class SumUpDataReponseBody {
    private List<DataSource> dataSources;
}
