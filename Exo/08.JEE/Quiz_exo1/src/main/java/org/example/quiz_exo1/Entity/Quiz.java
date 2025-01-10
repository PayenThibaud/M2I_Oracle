package org.example.quiz_exo1.Entity;

import java.util.List;

public class Quiz {

    private int id;
    private String question;
    private List<String> listReponse;
    private String BonneReponse;
    private String pseudo;

    public Quiz(int id, String question, List<String> listReponse, String Bonnereponse, String pseudo) {
        this.id = id;
        this.question = question;
        this.listReponse = listReponse;
        this.BonneReponse = Bonnereponse;
        this.pseudo = pseudo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReponse() {
        return BonneReponse;
    }

    public void setReponse(String reponse) {
        this.BonneReponse = reponse;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public List<String> getListReponse() {
        return listReponse;
    }

    public void setListReponse(List<String> listReponse) {
        this.listReponse = listReponse;
    }
}
