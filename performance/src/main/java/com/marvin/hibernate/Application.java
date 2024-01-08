package com.marvin.hibernate;

import com.marvin.hibernate.service.persistence_context.PersistenceContextService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    private enum Process {
        PERSISTENCE_CONTEXT, SAVE
    }

    private final PersistenceContextService persistenceContextService;

    public Application(PersistenceContextService persistenceContextService) {
        this.persistenceContextService = persistenceContextService;
    }

    @Override
    public void run(String... args) throws Exception {

        if (args.length == 0) {
            LOGGER.error("No process to start!");
            System.exit(1);
        }

        Process process = Process.valueOf(args[0]);

        LOGGER.info("Starting process {}!", process);

        if (process == Process.PERSISTENCE_CONTEXT) {
            persistenceContextService.run();
        }

        System.exit(1);
    }
}
