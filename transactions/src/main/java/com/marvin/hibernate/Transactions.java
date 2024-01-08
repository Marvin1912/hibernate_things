package com.marvin.hibernate;

import com.marvin.hibernate.service.TransactionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.marvin.hibernate")
public class Transactions implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Transactions.class, args);
    }

    private final TransactionService transactionService;

    public Transactions(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Override
    public void run(String... args) {
        transactionService.saveAll();
    }
}
