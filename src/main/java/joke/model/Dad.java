package joke.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Dad {
    private String value;
    private String url;

    public Dad(String value, String url) {
        this.value = value;
        this.url = url;
    }
}
