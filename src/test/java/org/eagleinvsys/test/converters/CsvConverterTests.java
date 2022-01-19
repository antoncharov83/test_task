package org.eagleinvsys.test.converters;

import org.eagleinvsys.test.converters.impl.ConvertibleCollectionImpl;
import org.eagleinvsys.test.converters.impl.ConvertibleMessageImpl;
import org.eagleinvsys.test.converters.impl.CsvConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

class CsvConverterTests {

    private static ConvertibleCollection collectionToConvert;

    @BeforeAll
    public static void init() {
        collectionToConvert = new ConvertibleCollectionImpl(List.of("h1", "h2"), List.of(new ConvertibleMessageImpl(Map.of("1","A","2","B","3","C"))));
    }

    @Test
    public void toCsv() {
        var converter = new CsvConverter();
        var outputStream = new ByteArrayOutputStream();
        converter.convert(collectionToConvert, outputStream);
        var res = outputStream.toString();
        Assertions.assertEquals("A,B,C",res);
    }

}