package org.example.exo3.Config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.BatchConfiguration;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Bean
    public BatchConfigurer batchConfigurer(DataSource dataSource) {
        return new DefaultBatchConfigurer(dataSource);
    }

    @Bean
    public Step readPhoneCsvStep(BatchConfigurer batchConfigurer) {
        return new StepBuilder("readPhoneCsvStep", batchConfigurer.getJobRepository())
                .<String, String>chunk(10)
                .reader(new PhoneCsvReader())  // Définissez votre propre lecteur
                .processor(new PhoneCsvProcessor()) // Définissez votre propre processeur
                .writer(new PhoneCsvWriter())  // Définissez votre propre écrivain
                .build();
    }

    @Bean
    public Job importInteractionsJob(BatchConfigurer batchConfigurer) {
        return batchConfigurer.getJobBuilderFactory()
                .get("importInteractionsJob")
                .start(readPhoneCsvStep(batchConfigurer))
                .build();
    }
}
