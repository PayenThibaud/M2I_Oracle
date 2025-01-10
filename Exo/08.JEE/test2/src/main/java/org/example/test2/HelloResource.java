package org.example.test2;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.test2.Entity.Quiz;
import org.example.test2.Service.QuizService;

import java.util.List;

@Path("/quizzes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HelloResource {

    private final QuizService quizService;

    @Inject
    public HelloResource(QuizService quizService) {
        this.quizService = quizService;
    }

    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";}

    @POST
    public Quiz createQuiz(int id, String question, List<String> listReponse, String Bonnereponse, String
            pseudo) {
        return quizService.save(id, question, listReponse, Bonnereponse, pseudo);
    }

    @GET
    public List<Quiz> getAllQuiz() {
        return quizService.getAllQuiz();
    }

    @GET
    @Path("/{id}")
    public Quiz getQuiz(@QueryParam("id") int id) {
        return quizService.getQuiz(id);
    }

}