package org.example.apigateway.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/command")
public class CommandController {

    @GetMapping("/{id}")
    public ResponseEntity<T> command(@PathVariable("id") long id) {

    }
}
