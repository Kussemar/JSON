package joke.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import joke.utils.HttpUtils;
import lombok.ToString;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@ToString
public class JokeFetcher {
    private final String chuck = "https://api.chucknorris.io/jokes/random";
    private final String dad = "https://icanhazdadjoke.com/";

    private static final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public String fetchData(String url) throws IOException {
        return HttpUtils.fetchData(url);
    }

    public String getJokesSequential() throws IOException, ExecutionException, InterruptedException {

        String chuckJson = HttpUtils.fetchData("https://api.chucknorris.io/jokes/random");
        String dadJson = HttpUtils.fetchData("https://icanhazdadjoke.com");

        ChuckNorris chuckDTO = gson.fromJson(chuckJson, ChuckNorris.class);
        DadJoke dadJoke = gson.fromJson(dadJson, DadJoke.class);

        CombinedJokesDTO dto = new CombinedJokesDTO(chuckDTO, dadJoke);

        return gson.toJson(dto);

    }

    public String getJokesParallel() throws IOException, ExecutionException, InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();

        Future<ChuckNorris> chuckNorrisFuture = es.submit(
                () -> gson.fromJson(fetchData(chuck), ChuckNorris.class)
        );

        Future<DadJoke> dadJokeFuture = es.submit(
                () -> gson.fromJson(fetchData(dad), DadJoke.class)
        );

        ChuckNorris chuckNorris = chuckNorrisFuture.get();
        DadJoke dadJoke = dadJokeFuture.get();

        CombinedJokesDTO dto = new CombinedJokesDTO(chuckNorris, dadJoke);
        es.shutdown();

        return gson.toJson(dto);
    }
}
