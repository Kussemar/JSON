package joke.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import joke.utils.HttpUtils;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Main {

    static Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    private static final String chuck = "https://api.chucknorris.io/jokes/random";
    private static final String dad = "https://icanhazdadjoke.com/";

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        HttpUtils fetch = new HttpUtils();

        String dadString = HttpUtils.fetchData(dad);
        String norrisString = HttpUtils.fetchData(chuck);
        // from json to java object
        ChuckNorris norrisJoke = gson.fromJson(norrisString, ChuckNorris.class);
        DadJoke dadJoke = gson.fromJson(dadString, DadJoke.class);
        // from Java object to json
        CombinedJokesDTO combinedJokesDTO = new CombinedJokesDTO(norrisJoke, dadJoke);
        System.out.println(gson.toJson(combinedJokesDTO));

        JokeFetcher jokeFetcher = new JokeFetcher();
        String jokeSequential = jokeFetcher.getJokesSequential();
        System.out.println(jokeSequential);

        JokeFetcher jokesParralel = new JokeFetcher();
        jokesParralel.getJokesParallel();
        System.out.println(jokesParralel);


    }
}
