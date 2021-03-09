package pl.markowska.addapp.model.mongo;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "randomNumber")
@Data
@Builder
public class RandomNumber {
    @Id
    private String id;
    private int key;
    private int number;
}
