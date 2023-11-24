package ru.mirea.kovalev.asteroids;

import com.fasterxml.jackson.databind.json.JsonMapper;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import ru.mirea.kovalev.stonks.DailyCurs;
import ru.mirea.kovalev.stonks.StonksService;
import ru.mirea.kovalev.stonks.Valute;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Last_Asteroid {
    public static void main(String[] args) throws IOException {

        Retrofit rock = new Retrofit
                .Builder()
                .baseUrl("https://data.nasa.gov")
                .addConverterFactory(JacksonConverterFactory.create(new JsonMapper()))
                .build();
        AsteroidsService asteroidsService = rock.create(AsteroidsService.class);

        LocalDateTime neededDate = LocalDateTime.of(2010,9,17,0,0,0,0);
        Response<List<Asteroid>> response = asteroidsService
                .getAsteroid(neededDate).execute();
        List<Asteroid> asteroid = response.body();

        System.out.println(asteroid);
        // Вместо вывода астероида, найденного в указанную дату, выводит "null". Как исправить не знаю
    }
}
