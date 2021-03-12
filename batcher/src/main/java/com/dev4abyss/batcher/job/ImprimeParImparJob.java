package com.dev4abyss.batcher.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
@Log4j2
@RequiredArgsConstructor
public class ImprimeParImparJob {

    private final JobBuilderFactory jobBuilderFactory;


    @Bean
    public Job impremeParImparJob(Step impremeParImparStep) {
        return jobBuilderFactory.get("impremeParImparJob")
                .start(impremeParImparStep)
                .incrementer(new RunIdIncrementer())
                .build();

    }


}
