package de.kacar.quizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import de.kacar.quizzapp.connection.APIUtils;
import de.kacar.quizzapp.connection.LoginResponse;
import de.kacar.quizzapp.connection.MyApiCall;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
        public TextView user, pass;
        public MyApiCall myapi  = APIUtils.getMyAPICall();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        user = findViewById(R.id.usernameField);
        pass = findViewById(R.id.passwordField);
        Button login = findViewById(R.id.loginButton);
        Button register = findViewById(R.id.registerButton);

        login.setOnClickListener(this);
        register.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.loginButton){
            myapi.getLogin(user.getText().toString(), pass.getText().toString()).enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {


                    if(response.isSuccessful()){
                        LoginResponse loginResponse = response.body();
                        Intent intent = new Intent(MainActivity.this, hauptmenu.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(MainActivity.this,"something",Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    Toast.makeText(MainActivity.this,"wrong",Toast.LENGTH_LONG).show();
                }

            });
        }
        if(v.getId()==R.id.registerButton){
            Intent intent = new Intent(MainActivity.this, regisActivity.class);
            startActivity(intent);
        }
    }
}


