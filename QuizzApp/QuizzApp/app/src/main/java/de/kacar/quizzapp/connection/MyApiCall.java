package de.kacar.quizzapp.connection;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MyApiCall {
    @GET("/register.php")
    Call<RegisterResponse> getRegister(@Query("username") String username, @Query("email") String email, @Query("password") String password);

    @GET("/login.php")
    Call<LoginResponse> getLogin(@Query("username") String username, @Query("email") String email, @Query("password") String password);
}
