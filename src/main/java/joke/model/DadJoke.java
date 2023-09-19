package joke.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class DadJoke {
    private String id;
    private String joke;

    public DadJoke(String id, String joke) {
        this.id = id;
        this.joke = joke;
    }


}
