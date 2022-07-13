package com.mx.mlibre.mutants.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"com.mx.mlibre.service.*", "com.mx.mlibre.mutants.controller","com.mx.mlibre.repository.*"})
@EntityScan({"com.mx.mlibre.mutants.beans"})
@EnableJpaRepositories({"com.mx.mlibre.repository"})
@Configuration
public class MutantsConfig {

}
