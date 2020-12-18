package de.kacar.quizzapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
        public TextView user, pass;
        Intent i = new Intent(this,regisActivity.class);
        Intent ii = new Intent(this,hauptmenu.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        user = findViewById(R.id.usernameField);
        pass = findViewById(R.id.passwordField);

    }
    public void onClick(View view)
    {
        switch (view.getId()) {
            case R.id.loginButton: if (user.getText().toString()== "Chris" && pass.getText().toString()=="1234")
            {
                    startActivity(ii);
            }
            else
            {
                startActivity(i);
            }
            case R.id.registerButton: startActivity(i);

        }
    }

}


