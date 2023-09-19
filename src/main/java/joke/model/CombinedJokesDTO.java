package joke.model;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class CombinedJokesDTO {
    private String url;
    private String value;
    private String id;
    private String joke;

    public CombinedJokesDTO(ChuckNorris norris, DadJoke dadJoke){
        this.url = norris.getUrl();
        this.value = norris.getValue();
        this.id = dadJoke.getId();
        this.joke = dadJoke.getJoke();
    }

    @Override
    public String toString() {
        return "CombinedJokesDTO{" + "url=" + url + ", value=" + value + ", id=" + id + ", joke=" + joke + '}';
    }

}
