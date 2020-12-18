package de.kacar.quizzapp.connection;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class QuestionsResponse {


        @SerializedName("QID")
        @Expose
        private String qID;
        @SerializedName("CATEGORYTYPE")
        @Expose
        private String cATEGORYTYPE;
        @SerializedName("QTEXT")
        @Expose
        private String qTEXT;

        public String getQID() {
            return qID;
        }

        public void setQID(String qID) {
            this.qID = qID;
        }

        public String getCATEGORYTYPE() {
            return cATEGORYTYPE;
        }

        public void setCATEGORYTYPE(String cATEGORYTYPE) {
            this.cATEGORYTYPE = cATEGORYTYPE;
        }

        public String getQTEXT() {
            return qTEXT;
        }

        public void setQTEXT(String qTEXT) {
            this.qTEXT = qTEXT;
        }

    }