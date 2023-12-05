package ru.mirea.kovalev.asteroids;

import com.fasterxml.jackson.databind.json.JsonMapper;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class Last_Asteroid {
    public static void main(String[] args) throws IOException {

        LocalDateTime neededDate = LocalDateTime.of(2010,9,17,0,0,0,0);

        Retrofit rock = new Retrofit
                .Builder()
                .baseUrl("https://data.nasa.gov")
                .addConverterFactory(JacksonConverterFactory.create(new JsonMapper()))
                .build();
        AsteroidsService asteroidsService = rock.create(AsteroidsService.class);

        // Сегмент ниже должен занести в response список астероидов, из которого с помощью конкретной даты, я смогу найти конкретный астероид
        Response<List<Asteroid>> response = asteroidsService
                .getAsteroid().execute();
        List<Asteroid> asteroids = response.body();
        // Если не заработает, надо написать Ксенофонтову, прислать код

        /*asteroids.stream()
                .filter(asteroid -> asteroid.getDiscovery_date() == neededDate)
                .forEach(System.out::println);*/
    }
}
