package org.example.exo2bash.Tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

@Component
public class FileCopyTasklet implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        File sourceFile = new File("src/main/resources/jouets.csv");
        File destinationFile = new File("src/main/resources/jouets_temp.csv");

        if (sourceFile.exists()) {
            try {
                Files.copy(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Le fichier jouets.csv a été copié en jouets_temp.csv.");
            } catch (IOException e) {
                throw new RuntimeException("Erreur lors de la copie du fichier jouets.csv en jouets_temp.csv", e);
            }
        } else {
            throw new RuntimeException("Le fichier jouets.csv n'existe pas.");
        }
        return RepeatStatus.FINISHED;
    }
}