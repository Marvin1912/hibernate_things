package com.marvin.hibernate.csv;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@Component
public class CsvWriter {

    public <T> void writeListToCsv(Path file, List<T> records, Class<T> recordClass) throws IOException {
        final CsvMapper mapper = new CsvMapper();
        final CsvSchema schema = mapper.schemaFor(recordClass).withHeader();
        mapper.writer(schema).writeValue(file.toFile(), records);
    }

}
