package org.eagleinvsys.test.converters;

import org.eagleinvsys.test.converters.impl.CsvConverter;
import org.eagleinvsys.test.converters.impl.StandardCsvConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

class StandardCsvConverterTests {

    private static List<Map<String, String>> collectionToConvert;

    @BeforeAll
    public static void init() {
        collectionToConvert = List.of(Map.of("1","A","2","B","3","C"),
                                    Map.of("1","D","2","E","3","F"));
    }

    @Test
    public void toCsv() {
        var converterMock = new CsvConverter();
        var standardConverter = new StandardCsvConverter(converterMock);
        var outputStream = new ByteArrayOutputStream();
        standardConverter.convert(collectionToConvert, outputStream);
        var res = outputStream.toString();
        Assertions.assertEquals("A,B,C,D,E,F",res);
    }
}