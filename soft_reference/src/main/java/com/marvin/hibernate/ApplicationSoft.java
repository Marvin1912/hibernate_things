package com.marvin.hibernate;

import com.marvin.hibernate.service.SoftReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.marvin.hibernate")
public class ApplicationSoft implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationSoft.class, args);
    }

    private final SoftReference softReference;

    public ApplicationSoft(SoftReference softReference) {
        this.softReference = softReference;
    }

    @Override
    public void run(String... args) throws Exception {

        softReference.addRootObject();

    }
}
