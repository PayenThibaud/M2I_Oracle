package org.example.quiz_exo1.Service;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.quiz_exo1.Entity.Quiz;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class QuizService {
    private List<Quiz> listQuiz = new ArrayList<Quiz>();

    public Quiz save(int id, String question, List<String> listReponse,  String Bonnereponse, String pseudo){
        Quiz quiz = new Quiz(id, question, listReponse, Bonnereponse, pseudo);
        listQuiz.add(quiz);
        return quiz;
    }

    public List<Quiz> getAllQuiz(){
        return listQuiz;
    }

    public Quiz getQuiz(int id){
        return listQuiz.get(id);
    }
}
