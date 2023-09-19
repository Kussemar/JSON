package joke.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
public class ChuckNorris {
    private String value;
    private String url;

    public ChuckNorris(String value, String url) {
        this.value = value;
        this.url = url;
    }
}
