package com.dev4abyss.batcher.step;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Component
public class ImprimeParImparStep {

    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step impremeParImparStep() {
        return stepBuilderFactory.get("impremeParImparStep")
                .<Integer, String>chunk(10)
                .reader(contaAteDezReader())
                .processor(parOuImparProcessor())
                .writer(imprimirWriter())
                .build();
    }

    private IteratorItemReader<Integer> contaAteDezReader() {
        List<Integer> numeroDeUmADez = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        return new IteratorItemReader<>(numeroDeUmADez.iterator());
    }

    private FunctionItemProcessor<Integer, String> parOuImparProcessor() {
        return new FunctionItemProcessor<>(
                item -> item % 2 == 0 ? String.format("Item %s é par", item) : String.format("Item %s é impar", item
                ));
    }

    private ItemWriter<String> imprimirWriter() {
        return itens -> itens.forEach(System.out::println);
    }
}
