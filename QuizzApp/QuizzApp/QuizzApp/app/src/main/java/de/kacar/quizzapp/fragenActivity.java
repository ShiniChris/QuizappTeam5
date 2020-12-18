package de.kacar.quizzapp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import de.kacar.quizzapp.connection.QuestionsResponse;


public class fragenActivity extends AppCompatActivity {

    public static class Question
    {
      private int id;
      private String kategorie;
      private String frage;
      private String antwort1;
      private String antwort2;
      private String antwort3;
      private String antwort4;


      public static final Question[]questions =
        {
             new Question(1,"Nordische Mythologie","Wie heißt der Gott des Donners","Thor","Loki","Heimdall","Odin"),
             new Question(2,"Geschichte","Wie heißt der Bundeskanzler 1998", "Schmidt", "Schröder", "Merkel", "Kohl")


        };
      private Question(int id,String kategorie,String frage,String antwort1,String antwort2,String antwort3,String antwort4){
          this.id = id;
          this.kategorie = kategorie;
          this.frage = frage;
          this.antwort1 =antwort1;
          this.antwort2 =antwort2;
          this.antwort3 =antwort3;
          this.antwort4 =antwort4;
      }
              public int getID(){
                  return id;
              }
            public String getKategorie(){
                return kategorie;
            }
            public String getFrage(){
                return frage;
            }
            public String getAntwort1(){
                return antwort1;
            }
        public String getAntwort2(){
            return antwort2;
        }
        public String getAntwort3(){
            return antwort3;
        }
        public String getAntwort4(){
            return antwort4;
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        int i =1;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragen);
        TextView kategorie,frage,a1,a2,a3,a4;
        kategorie = findViewById(R.id.guideline3);
        frage = findViewById(R.id.fragefeldText);
        a1 = findViewById(R.id.frageeinsButton);
        a2= findViewById(R.id.fragezweiButton);
        a3= findViewById(R.id.fragedreiButton);
        a4=findViewById((R.id.fragevierButton));
        frage.setText(Question.questions[i].getFrage());
        a1.setText(Question.questions[i].getAntwort1());
        a2.setText(Question.questions[i].getAntwort2());
        a3.setText(Question.questions[i].getAntwort3());
        a4.setText(Question.questions[i].getAntwort4());
    }



    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.frageeinsButton:
            case R.id.fragezweiButton:
            case R.id.fragedreiButton:
            case R.id.fragevierButton:
        }
    }
}
