package de.kacar.quizzapp.connection;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnswersResponse {

    @SerializedName("ANSWERTEXT")
    @Expose
    private String aNSWERTEXT;
    @SerializedName("CORRECT")
    @Expose
    private String cORRECT;
    @SerializedName("QID")
    @Expose
    private String qID;

    public String getANSWERTEXT() {
        return aNSWERTEXT;
    }

    public void setANSWERTEXT(String aNSWERTEXT) {
        this.aNSWERTEXT = aNSWERTEXT;
    }

    public String getCORRECT() {
        return cORRECT;
    }

    public void setCORRECT(String cORRECT) {
        this.cORRECT = cORRECT;
    }

    public String getQID() {
        return qID;
    }

    public void setQID(String qID) {
        this.qID = qID;
    }

}