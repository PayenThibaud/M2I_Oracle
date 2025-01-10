package org.example.demo.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo.Entity.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/persons")
public class PersonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("Titi", "Riri", 20));
        persons.add(new Person("Toto", "Roro", 15));
        persons.add(new Person("Tata", "Rara", 100));

        request.setAttribute("persons", persons);

        request.getRequestDispatcher("/persons.jsp").forward(request, response);
    }
}
