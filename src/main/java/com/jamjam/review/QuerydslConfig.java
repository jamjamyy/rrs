package com.jamjam.review;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
public class QuerydslConfig {
    private final EntityManager em;

    @Bean
    public JPAQueryFactory QueryFactory() {
        return new JPAQueryFactory(em);
    }
}
