package com.marvin.hibernate.csv.model;

public record CsvLine(
        long amount,
        String type,
        long time
) {
}
