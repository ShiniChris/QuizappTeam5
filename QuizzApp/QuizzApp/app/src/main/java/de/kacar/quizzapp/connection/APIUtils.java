package de.kacar.quizzapp.connection;

public class APIUtils {

        public static final String URL = "http://130.61.50.54/~quizzteam5/QuizApp/";

        public static MyApiCall getMyAPICall(){
            return RetrofitClient.getClient(URL).create(MyApiCall.class);

    }
}
