package org.example.exo2bash.Config;

import org.example.exo2bash.Entity.Jouet;
import org.example.exo2bash.Repository.JouetRepository;
import org.example.exo2bash.Tasklet.FileCopyTasklet;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class JouetBatchConfig {

    private final JouetRepository jouetRepository;
    private final FileCopyTasklet fileCopyTasklet;

    public JouetBatchConfig(FileCopyTasklet fileCopyTasklet, JouetRepository jouetRepository) {
        this.fileCopyTasklet = fileCopyTasklet;
        this.jouetRepository = jouetRepository;
    }

    @Bean
    public FlatFileItemReader<Jouet> reader() {
        return new FlatFileItemReaderBuilder<Jouet>()
                .name("jouetItemReader")
                .resource(new ClassPathResource("jouets_temp.csv"))
                .linesToSkip(1)
                .delimited()
                .delimiter(",")
                .names("id_jouet", "nom", "description", "prix")
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                    setTargetType(Jouet.class);
                }})
                .build();
    }

    @Bean
    public ItemProcessor<Jouet, Jouet> processor() {
        return jouet -> jouet;
    }

    @Bean
    @Qualifier("jdbcWriter")
    public JdbcBatchItemWriter<Jouet> jdbcWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Jouet>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO jouet (id_jouet, nom, description, prix) " +
                        "VALUES (:id_jouet, :nom, :description, :prix) " +
                        "ON CONFLICT (id_jouet) DO UPDATE SET nom = EXCLUDED.nom, description = EXCLUDED.description, prix = EXCLUDED.prix")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Step stepProcessing(JobRepository jobRepository, PlatformTransactionManager transactionManager,
                               @Qualifier("jdbcWriter") ItemWriter<Jouet> jdbcWriter) {
        return new StepBuilder("stepProcessing", jobRepository)
                .<Jouet, Jouet>chunk(10, transactionManager) // Traitement en morceaux de 10 éléments
                .reader(reader())
                .processor(processor())
                .writer(jdbcWriter)
                .build();
    }

    @Bean
    public Step stepFileCopy(JobRepository jobRepository, PlatformTransactionManager transactionManager, FileCopyTasklet fileCopyTasklet) {
        return new StepBuilder("stepFileCopy", jobRepository)
                .tasklet(fileCopyTasklet)
                .transactionManager(transactionManager)
                .build();
    }

    @Bean
    public Job importJob(JobRepository jobRepository, Step stepFileCopy, Step stepProcessing) {
        return new JobBuilder("importProductsJob", jobRepository)
                .start(stepFileCopy)
                .next(stepProcessing)
                .build();
    }
}
