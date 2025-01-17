package org.example.exo2bash.Controller;

import org.example.exo2bash.Dto.JouetDtoReceive;
import org.example.exo2bash.Dto.JouetDtoSend;
import org.example.exo2bash.Service.JouetService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 ###
 POST http://localhost:8081/Jouet
 Content-Type: application/json

 {
 "nom": "Poupee",
 "description": "Joli poupee",
 "prix": "20"
 }
 */


@RestController
@RequestMapping("Jouet")
public class JouetController extends GeneriqueController<JouetDtoReceive, JouetDtoSend, JouetService> {

    private final JobLauncher jobLauncher;
    private final Job job;

    public JouetController(JouetService jouetService, JobLauncher jobLauncher, Job job) {
        super(jouetService);
        this.jobLauncher = jobLauncher;
        this.job = job;
    }

    @GetMapping("fichier")
    public void addProduct () throws Exception{
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time",System.currentTimeMillis())
                .toJobParameters();

        jobLauncher.run(job,jobParameters);
    }
}
