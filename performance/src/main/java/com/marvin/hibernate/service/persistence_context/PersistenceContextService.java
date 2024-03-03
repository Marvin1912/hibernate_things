package com.marvin.hibernate.service.persistence_context;

import com.marvin.hibernate.csv.CsvWriter;
import com.marvin.hibernate.csv.model.CsvLine;
import com.marvin.hibernate.service.data.Deleter;
import com.marvin.hibernate.service.data.Generator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersistenceContextService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersistenceContextService.class);

    private final String csvOutputFile;
    private final CsvWriter csvWriter;
    private final Generator generator;
    private final DataProcessor dataProcessor;
    private final Deleter deleter;

    public PersistenceContextService(
            @Value("${csv.output.file}") String csvOutputFile,
            CsvWriter csvWriter,
            Generator generator,
            DataProcessor dataProcessor,
            Deleter deleter
    ) {
        this.csvOutputFile = csvOutputFile;
        this.csvWriter = csvWriter;
        this.generator = generator;
        this.dataProcessor = dataProcessor;
        this.deleter = deleter;
    }

    public void run() throws IOException {

        deleter.truncateAll();

        final List<CsvLine> csvLines = new ArrayList<>();

        for (int i = 0; i < 500; i++) {
            LOGGER.info("RUN: {}", i);
            long objects = generator.generateRootObjects(1, 250);

            BigDecimal time = dataProcessor.fetchDataEntity();
            LOGGER.info("[{}][ENTITY] {}ms", objects, time);
            csvLines.add(new CsvLine(objects, "ENTITY", time.doubleValue()));

            time = dataProcessor.fetchDataDto();
            LOGGER.info("[{}][DTO] {}ms", objects, time);
            csvLines.add(new CsvLine(objects, "DTO", time.doubleValue()));
        }

        csvWriter.writeListToCsv(Path.of(csvOutputFile), csvLines, CsvLine.class);
    }
}
