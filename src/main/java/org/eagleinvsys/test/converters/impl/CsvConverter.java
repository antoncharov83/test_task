package org.eagleinvsys.test.converters.impl;

import org.eagleinvsys.test.converters.Converter;
import org.eagleinvsys.test.converters.ConvertibleCollection;

import java.io.IOException;
import java.io.OutputStream;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

public class CsvConverter implements Converter {

    /**
     * Converts given {@link ConvertibleCollection} to CSV and outputs result as a text to the provided {@link OutputStream}
     *
     * @param collectionToConvert collection to convert to CSV format
     * @param outputStream        output stream to write CSV conversion result as text to
     */
    @Override
    public void convert(ConvertibleCollection collectionToConvert, OutputStream outputStream) {
        var csv = StreamSupport.stream(collectionToConvert.getRecords().spliterator(), false)
                        .map(r -> IntStream.of(1,2,3)
                                .mapToObj(String::valueOf)
                                .map(id -> r.getElement(id))
                                .collect(Collectors.joining(",")))
                        .collect(Collectors.joining(","));
        try {
            outputStream.write(csv.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}