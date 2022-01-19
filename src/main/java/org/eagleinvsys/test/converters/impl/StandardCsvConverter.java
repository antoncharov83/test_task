package org.eagleinvsys.test.converters.impl;

import org.eagleinvsys.test.converters.ConvertibleMessage;
import org.eagleinvsys.test.converters.StandardConverter;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StandardCsvConverter implements StandardConverter {

    private final CsvConverter csvConverter;

    public StandardCsvConverter(CsvConverter csvConverter) {
        this.csvConverter = csvConverter;
    }

    /**
     * Converts given {@link List<Map>} to CSV and outputs result as a text to the provided {@link OutputStream}
     *
     * @param collectionToConvert collection to convert to CSV format. All maps must have the same set of keys
     * @param outputStream        output stream to write CSV conversion result as text to
     */
    @Override
    public void convert(List<Map<String, String>> collectionToConvert, OutputStream outputStream) {
        var headers = Stream.generate(() -> "header")
                .limit(collectionToConvert.size())
                .collect(Collectors.toList());

        List<ConvertibleMessage> records = collectionToConvert.stream()
                .map(elements -> new ConvertibleMessageImpl(elements))
                .collect(Collectors.toList());

        var csvCollection = new ConvertibleCollectionImpl(headers, records);

        csvConverter.convert(csvCollection, outputStream);
    }

}