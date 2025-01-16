package org.example.exospringbashduno.Config;

import org.example.exospringbashduno.Entity.Dinosaur;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    public BatchConfig() {
    }

    @Bean
    @Scope("prototype")
    public FlatFileItemReader<Dinosaur> reader() {
        return new FlatFileItemReaderBuilder<Dinosaur>()
                .name("dinosaurItemReader")
                .resource(new FileSystemResource("src/main/resources/dinosaurs.csv"))
                .linesToSkip(1)
                .delimited()
                .names("id", "name", "species", "age")
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                    setTargetType(Dinosaur.class);
                }})
                .build();
    }


    @Bean
    public ItemProcessor<Dinosaur, Dinosaur> processor() {
        return dino -> {
            dino.setAge(dino.getAge() / 100);
            return dino;
        };
    }


    @Bean
    @Qualifier("jdbcWriter")
    public JdbcBatchItemWriter<Dinosaur> jdbcWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Dinosaur>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO dinosaur (id, name, species, age) VALUES (:id, :name, :species, :age) " +
                        "ON CONFLICT (id) DO UPDATE SET name = EXCLUDED.name, species = EXCLUDED.species, age = EXCLUDED.age")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    @Qualifier("customWriter")
    public ItemWriter<Dinosaur> customWriter(DataSource dataSource) {
        List<ItemWriter<? super Dinosaur>> writers = new ArrayList<>();

        writers.add(items -> {
            System.out.println("Avant :");
            items.forEach(dino -> System.out.println(dino));
        });

        writers.add(jdbcWriter(dataSource));

        writers.add(items -> {
            System.out.println("Apres :");
            items.forEach(dino -> System.out.println(dino));
        });

        CompositeItemWriter<Dinosaur> compositeItemWriter = new CompositeItemWriter<>();
        compositeItemWriter.setDelegates(writers);
        return compositeItemWriter;
    }


    @Bean
    public Job importJob(JobRepository jobRepository, Step step) {
        return new JobBuilder("importDinosaursJob", jobRepository)
                .start(step)
                .build();
    }

    @Bean
    public Step step(ItemReader<Dinosaur> reader,
                     ItemProcessor<Dinosaur, Dinosaur> processor,
                     @Qualifier("customWriter") ItemWriter<Dinosaur> writer,
                     JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("step", jobRepository)
                .<Dinosaur, Dinosaur>chunk(10, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

}
