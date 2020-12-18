package de.kacar.quizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import de.kacar.quizzapp.connection.APIUtils;
import de.kacar.quizzapp.connection.LoginResponse;
import de.kacar.quizzapp.connection.MyApiCall;
import de.kacar.quizzapp.connection.RegisterResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class regisActivity extends AppCompatActivity implements View.OnClickListener{
    public MyApiCall myapi  = APIUtils.getMyAPICall();
    TextView user,pass,pass2,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrieren);

        user = findViewById(R.id.usernameFieldR);
        pass = findViewById(R.id.passwordFieldR);
        pass2 = findViewById(R.id.passwordFieldRe);
        email = findViewById(R.id.emailFieldR);

        Button register = findViewById(R.id.registerButtonR);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(pass.getText().toString().equals(pass2.getText().toString())) {

            if (v.getId() == R.id.registerButtonR) {
                myapi.getRegister(user.getText().toString(), pass.getText().toString(), email.getText().toString()).enqueue(new Callback<RegisterResponse>() {

                    @Override
                    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                        if(response.isSuccessful()){
                            RegisterResponse RegisterResponse = response.body();
                            if(RegisterResponse.getSuccess()){
                            Intent intent = new Intent(regisActivity.this, hauptmenu.class);
                            startActivity(intent);
                            Toast.makeText(regisActivity.this,"Fehler beim registrieren",Toast.LENGTH_LONG).show();
                            }
                        }
                        else{
                            Toast.makeText(regisActivity.this,"Fehler beim registrieren",Toast.LENGTH_LONG).show();
                        }
                    }


                    @Override
                    public void onFailure(Call<RegisterResponse> call, Throwable t) {
                        Toast.makeText(regisActivity.this,"keine verbindung",Toast.LENGTH_LONG).show();
                    }
                });
            }

        }
        else{
            Toast.makeText(regisActivity.this,"Bitte geben sie zwei übereinstimmende passwörter ein",Toast.LENGTH_LONG).show();
        }
    }
}
