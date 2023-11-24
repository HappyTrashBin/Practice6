package ru.mirea.kovalev.asteroids;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface AsteroidsService {
    @GET("/resource/2vr3-k9wn.json")
    Call<List<Asteroid>> getAsteroid(@Query("date_req") LocalDateTime discovery_date);
}
