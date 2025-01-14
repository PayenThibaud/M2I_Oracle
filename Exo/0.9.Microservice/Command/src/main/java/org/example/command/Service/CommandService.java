package org.example.command.Service;

import org.example.command.Entity.Command;
import org.example.command.Repository.CommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandService {

    @Autowired
    private CommandRepository commandRepository;

    public Command getById(long id) {
        return commandRepository.getReferenceById(id);
    }
}
