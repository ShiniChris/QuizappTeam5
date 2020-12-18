package de.kacar.quizzapp.connection;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QAHolder {

    @SerializedName("frage")
    @Expose
    private QuestionsResponse frage;
    @SerializedName("antworten")
    @Expose
    private List<AnswersResponse> antworten = null;

    public QuestionsResponse getFrage() {
        return frage;
    }

    public void setFrage(QuestionsResponse frage) {
        this.frage = frage;
    }

    public List<AnswersResponse> getAntworten() {
        return antworten;
    }

    public void setAntworten(List<AnswersResponse> antworten) {
        this.antworten = antworten;
    }

}