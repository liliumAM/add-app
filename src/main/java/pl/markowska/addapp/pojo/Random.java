package pl.markowska.addapp.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Random {
    private List<Integer> data = null;
    private String completionTime;
}
